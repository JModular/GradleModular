
package com.android.core.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.android.core.net.HttpBase;
import com.android.core.net.HttpClient;
import com.android.core.net.HttpClient.CacheType;
import com.android.core.utils.DateFormatUtil;
import com.android.core.utils.RxjavaUtils;
import com.android.core.utils.StringUtils;
import com.android.demo.OkhttpUtils;
import com.android.retrofit.Interceptor.CacheInterceptor;
import com.android.retrofit.Interceptor.LogInterceptor;
import com.android.retrofit.converter.StringConverterFactory;

import com.android.retrofit.service.ParamService;

import okhttp3.Cache;
import okhttp3.Cookie;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Retrofit封装Okhttp的方式进行网络操作
 * 
 * @author Arison
 *
 */
public class RetrofitImpl extends HttpBase {

	public Retrofit retrofit;
	private static RetrofitImpl instance;
	@SuppressWarnings("unused")
	private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

	public static RetrofitImpl getInstance() {
		if (instance == null) {
			synchronized (RetrofitImpl.class) {
				if (instance == null) {
					instance = new RetrofitImpl();
				}
			}
		}

		return instance;
	}

	@Override
	public void initClient() {
		// 本类保证初始化一次,减少系统开销
		Builder okBuilder = new OkHttpClient.Builder()
				.connectTimeout(mbuilder.getConnectTimeout(), TimeUnit.SECONDS)
				.readTimeout(mbuilder.getReadTimeout(), TimeUnit.SECONDS)
				.writeTimeout(mbuilder.getWriteTimeout(), TimeUnit.SECONDS)
				.sslSocketFactory(OkhttpUtils.createSSLSocketFactory(), new OkhttpUtils. TrustAllCerts())// 信任所有证书
				.hostnameVerifier(new OkhttpUtils.TrustAllHostnameVerifier());

		LogInterceptor logInterceptor = new LogInterceptor();
		logInterceptor.setBuilder(mbuilder);
		//okBuilder.addInterceptor(logInterceptor);
		okBuilder.addNetworkInterceptor(logInterceptor);
		if (mbuilder.getCacheFileSize() != 0) {
			okBuilder.cache(new Cache(mbuilder.getCacheFile(), mbuilder.getCacheFileSize()));
			okBuilder.addInterceptor(
					new CacheInterceptor(String.valueOf(mbuilder.getCacheTime()), mbuilder.getCacheType()));
		}

		// 后期缓存策略改进
		switch (mbuilder.getCacheType()) {
		case CacheType.ONLY_NETWORK:
			//OkhttpUtils.println("CacheType.ONLY_NETWORK");

			break;
		case CacheType.ONLY_CACHED:
			//OkhttpUtils.println("CacheType.ONLY_CACHED");
			// okBuilder.cache(new Cache(mbuilder.getCacheFile(),
			// mbuilder.getCacheFileSize()));

			break;
		case CacheType.CACHED_ELSE_NETWORK:

			break;
		case CacheType.NETWORK_ELSE_CACHED:

			break;
		default:
			break;
		}

		if(!StringUtils.isEmpty(mbuilder.getBaseUrl())){
			System.err.println(mbuilder.getBaseUrl());
			OkHttpClient client = okBuilder.build();
			retrofit = new Retrofit.Builder()
					.client(client)
					.baseUrl(mbuilder.getBaseUrl())
					.addConverterFactory(StringConverterFactory.create())
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
					.build();
		}
		
	}

	public <T> T initApi(Class<T> service) {
		return retrofit.create(service);
	}

	@Override
	public void get(HttpClient builder, Subscriber<Object> s) {
		ParamService paramService = initApi(ParamService.class);
		Observable<Object> o = paramService.getParam(builder.getBaseUrl(), builder.getParams(), builder.getHeaders());
		toSubscribe(o, s);

	}

	@Override
	public void post(HttpClient builder, Subscriber<Object> s) {
		ParamService paramService = initApi(ParamService.class);
		Observable<Object> o;
		if (builder.getParams().containsKey("body")) {
			// body提交
			System.out.println("body方式提交----------");
			o = paramService.postBody(
					builder.getBaseUrl(),
					builder.getParams().get("body"),
					builder.getParams(),
					builder.getHeaders());

		} else if (builder.getUploadFileKeys() != null) {
			MultipartBody.Builder mb = new MultipartBody.Builder();
			mb.setType(MultipartBody.FORM);
			for (String key : builder.getParams().keySet()) {
				Object object = builder.getParams().get(key);
				if (!(object instanceof File)) {
					mb.addFormDataPart(key, object.toString());
				} else {
					File file = (File) object;
					// 其中参数“file”和服务器接收的参数 一一对应,保证多文件上传唯一key不变
					mb.addFormDataPart(builder.getUploadFileKeys(), file.getName(), RequestBody.create(null, file));
				}
			}
			// 图片上传
			o = paramService.uploads(builder.getBaseUrl(), mb.build());
		} else {
			// 表单提交
			o = paramService.postParam(builder.getBaseUrl(), builder.getParams(), builder.getHeaders());

		}

		toSubscribe(o, s);

	}

	private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
		o.retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {

			@Override
			public Observable<?> call(Observable<? extends Throwable> t) {
			
				return t.flatMap(new Func1<Throwable, Observable<?>>() {
					private int count = 0;

					@Override
					public Observable<?> call(Throwable t) {
						OkhttpUtils.println(
								"重连数：" + mbuilder.getMaxRetryCount() + " 当前数：" + count + " 间隔时间："
										+ mbuilder.getRetryTimeout() + " 当前时间：" + DateFormatUtil.getDateTimeStr());
						if (++count <= mbuilder.getMaxRetryCount()) {
							OkhttpUtils.println("请求异常：" + t.getMessage());
							Observable<?> ob = Observable.timer(mbuilder.getRetryTimeout(), TimeUnit.MILLISECONDS);
			
							return ob;
						}

						return Observable.error(t);
					}
				});
			}
		}).map(new Func1<T, T>() {

			@Override
			public T call(T t) {
				return (T) t;
			}
		}).subscribeOn(RxjavaUtils.getNamedScheduler("线程1")).subscribe(s);
	}
}