package com.android.core.net;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.core.impl.RetrofitImpl;
import com.android.core.net.HttpClient.CacheType;
import com.android.core.net.HttpClient.Method;
import com.android.demo.OkhttpUtils;
import com.android.retrofit.rx.ResultListener;
import com.android.retrofit.rx.ResultSubscriber;
import com.android.retrofit.subscriber.NetResquestSubscriber;
import com.android.retrofit.subscriber.SubscriberOnNextListener;

import okhttp3.MediaType;
import okhttp3.RequestBody;

@SuppressWarnings("unused")
public class testHttp {

	public static final String BASE_URL = "http://192.168.253.200:8080/Chapter/";

	public static HttpClient httpClient = new HttpClient.Builder(BASE_URL)// 根路径
			.header("Cookie", "abdclejdldj82jk23jfjd")// 全局请求头 //局部可累加
			.header("Cache-control", "max-age=600")
			.maxRetryCount(0)// 局部可覆盖
			.isDebug(true)// 局部可覆盖
			.retryTimeout(1000)// 局部可覆盖
			.cacheFile(new File("C:/Cache"))// 局部可覆盖
			.cacheFileSize(10240 * 1024)// 局部可覆盖
			.cacheType(CacheType.ONLY_NETWORK)// 局部可覆盖
			.cacheTime(60 * 200)// 设置10分钟 //局部可覆盖
			.connectTimeout(5000)// 局部可覆盖
			.readTimeout(5000)// 局部可覆盖
			.writeTimeout(7000)// 局部可覆盖
			.httpBase(RetrofitImpl.getInstance())// 局部可覆盖
			.build(true);// 保持单例

	public static void main(String[] args) throws UnsupportedEncodingException {

		// testAPIBody("17607612611","易女士");//发短信
	 testAPIBody("13266699268","刘");//发短信
		//testRetrofitImpl();
		


	}

	// stars:>5+language:java+created:>=2000-12-14//okhttp方式支持
	private static String q = "stars:>5+language:java+created:>=2000-12-14";// Retrofit不支持，需要解码
	private static String sort = "stars";
	private static String order = "desc";
	private static String page = "1";
	private static String per_page = "10";

	public static void testGithupApi() throws UnsupportedEncodingException {
		OkhttpUtils.println(URLEncoder.encode(q, "UTF-8"));
		OkhttpUtils.println(URLDecoder.decode(q, "UTF-8"));
		httpClient = httpClient.newBuilder().url("https://api.github.com/").httpBase(OkhttpImpl.getInstance()).build();
		httpClient.Api()
				.send(new HttpClient.Builder().url("search/repositories")
						.add("q", q)
						.add("sort", sort)
						.add("order", order)
						.add("page", page)
						.add("per_page", per_page)
						.method(Method.GET)
						.build(), new NetResquestSubscriber<>(new SubscriberOnNextListener<Object>() {

							@Override
							public void onNext(Object t) {
								OkhttpUtils.println("主线程：" + t.toString());
							}
						}));
	}

	private static void testAPIBody(String phone, String name) {
		String content = "{\"receiver\":\"" + phone
				+ "\",\"params\":[\""
				+ name
				+ "\"],\"templateId\":\"4b60e18b-de2e-410f-9de1-819265d9e636\"}";
		httpClient = httpClient.newBuilder().url("http://message.ubtob.com/").build();
		httpClient.Api()
				.send(new HttpClient.Builder().url("sms/send")// 子路径
						.add("body", content)// 局部参数
						.method(Method.POST)
						.build(), new NetResquestSubscriber<Object>(new SubscriberOnNextListener<Object>() {

							@Override
							public void onNext(Object t) {
								OkhttpUtils.println(t.toString());
							}
						}));
	}

	private static void testUploadFiles() {
		File f1 = new File("C://Users//Arison//Downloads//SmartAdmin_1_3.zip");
		File f2 = new File("C://Users//Arison//Downloads//RetrofitWrapper.java");
		File f3 = new File("C://Users//Arison//Downloads//BaiduTranslate_chrome_1.2.crx");
		httpClient.Api().send(
				new HttpClient.Builder()
						.url("uploadFiles")
						.add("file1", f1)
						.add("file2", f2)
						.add("file3", f3)
						.add("phone", "1234567890")
						.filesKey("file")
						.method(Method.POST)
						.build(),
				new NetResquestSubscriber<>(new SubscriberOnNextListener<Object>() {

					@Override
					public void onNext(Object t) {

				
					}
				}));
		
	
		httpClient.newBuilder().isDebug(true).build(true);
		//httpClient=httpClient.newBuilder().isDebug(true).build();
		httpClient.Api().send(
				new HttpClient.Builder()
						.url("uploadFiles")
						.add("file1", f1)
						.add("phone", "1234567890")
						.filesKey("file")
						.method(Method.POST)
						.build(),
				new NetResquestSubscriber<>(new SubscriberOnNextListener<Object>() {

					@Override
					public void onNext(Object t) {

			
					}
				}));

	}

	private static void testRetrofitImpl() {

		httpClient.newBuilder().url("http://192.168.253.66:8082/").isDebug(true).build(true);
		httpClient.Api().send(new HttpClient.Builder()
				.url("sso/mobile/userspace/register")
				.method(Method.POST)
				.build(),
				new ResultSubscriber<>(new ResultListener<Object>() {

					@Override
					public void onResponse(Object t) {

					}
				}));

//		httpClient
//				.Api().send(
//						new HttpClient.Builder().url("getParam")// 子路径
//								.add("param3", "value1")// 局部参数
//								.add("param4", "value2")
//								.add("q", "stars:>5+language:java+created:>=2000-12-14")
//								.header("cookies", "cookies")// 局部请求头
//								.header("Accept",
//										"text/html,application/json,application/xml;q=0.9,image/webp,*/*;q=0.8")
//								.header("Cookie", "android")// 局部请求头
//								.header("Cookie", "java")// 局部请求头---同名请求会覆盖
//								.header("header3", "header1")// 局部请求头
//								.header("header4", "header2")// 局部请求头
//
//								.method(Method.GET)
//								.build(),
//						new NetResquestSubscriber<Object>(new SubscriberOnNextListener<Object>() {
//
//							@Override
//							public void onNext(Object t) {
//								
//							}
//						}));
	}

	/**
	 * OkhttpImpl 实现的网络请求
	 * 
	 * @param
	 */
	private static void testOkhttpImpl() {

		httpClient = httpClient.newBuilder().maxRetryCount(8).httpBase(OkhttpImpl.getInstance()).build(true);

		httpClient.Api()
				.send(new HttpClient.Builder().url("getParam")
						.add("username", "xiaomi")
						.add("password", "111111")

						.header("header", "new header")
						.method(Method.GET)
						.build(), new NetResquestSubscriber<>(new SubscriberOnNextListener<Object>() {

							@Override
							public void onNext(Object t) {
								OkhttpUtils.println(t);

							}
						}));

	}

}
