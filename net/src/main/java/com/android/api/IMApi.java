package com.android.api;

import java.io.File;

import org.apache.commons.lang.StringEscapeUtils;

import com.android.core.impl.RetrofitImpl;
import com.android.core.net.HttpClient;
import com.android.core.net.HttpClient.CacheType;
import com.android.core.net.HttpClient.Method;
import com.android.retrofit.rx.ResultListener;
import com.android.retrofit.rx.ResultSubscriber;
import com.android.retrofit.subscriber.NetResquestSubscriber;
import com.android.retrofit.subscriber.SubscriberOnNextListener;

public class IMApi {

	public static final String BASE_URL = "http://113.105.74.140:8092/";

	public static HttpClient httpClient = new HttpClient.Builder(BASE_URL)// 根路径
			.header("Cookie", "abdclejdldj82jk23jfjd")// 全局请求头 //局部可累加
			.header("Cache-control", "max-age=600")
			.add("param", "commonParam")
			.maxRetryCount(0)// 局部可覆盖
			.isDebug(true)// 局部可覆盖
			.retryTimeout(1000)// 局部可覆盖
			.cacheFile(new File("C:/Cache"))// 局部可覆盖
			.cacheFileSize(1024000 * 1024)// 局部可覆盖
			.cacheType(CacheType.ONLY_NETWORK)// 局部可覆盖
			.cacheTime(60 * 200)// 设置10分钟 //局部可覆盖
			.connectTimeout(5000)// 局部可覆盖
			.readTimeout(5000)// 局部可覆盖
			.writeTimeout(7000)// 局部可覆盖
			.httpBase(RetrofitImpl.getInstance())// 局部可覆盖
			.build();// 保持单例

	public static void main(String[] args) {
		//searchByKey("13266699268");
		//bookFindByDetail();
		//sendDataContact();
		//apiSimple();
		saveBusiness();
	}

	public static void bookFindByDetail() {
		httpClient.Api()
				.send(new HttpClient.Builder().url("user/appBusinessDetail")
						.add("id", "10002")
						.add("token", "388298a0c89f4a38b2fed4cd4123d441")
						.build(), new NetResquestSubscriber<>(new SubscriberOnNextListener<Object>() {

							@Override
							public void onNext(Object t) {
								System.out.println(t.toString());

							}
						}));
	}
	
	//上传本地通讯录
	@SuppressWarnings("unused")
	private static void sendDataContact(){
		 StringBuilder mapBuilder = new StringBuilder("[");
         for (int i = 0; i < 1; i++) {
             if (i == 1 - 1) {
                 mapBuilder.append("{\n" +
                         "\"am_telephone\":\"" + "13266699268" + "\",\n" +
                         "\"am_username\":\"" + "\\ " + "\",\n" +
                         "\"am_userid\":\"" + 0 + "\"\n" +
                         "}]");
             } else {
                 mapBuilder.append("{\n" +
                		  "\"am_telephone\":\"" + "31432" + "\",\n" +
                          "\"am_username\":\"" + "\n\\ " + "\",\n" +
                         "\"am_userid\":\"" + 0 + "\"\n" +
                         "},");
             }
         }
         System.out.println(StringEscapeUtils.unescapeJava(mapBuilder.toString()));
 
		httpClient.Api()
		.send(new HttpClient.Builder().url("/user/appMobileContact")
				.add("userid", "100263")
				.add("username", "刘杰")
				.add("map", StringEscapeUtils.unescapeJava(mapBuilder.toString()))
				.method(Method.POST)
				.add("token", "1c18e1314d314f8eb9704194581c6917")
				.build(), new NetResquestSubscriber<>(new SubscriberOnNextListener<Object>() {

					@Override
					public void onNext(Object t) {
						System.out.println(t.toString());

					}
				}));
	}

	@SuppressWarnings("unused")
	private static void searchByKey(String key) {
		httpClient.Api()
				.send(new HttpClient.Builder().url("user/appSearch")
						.add("name", "13266699268")
						.add("token", "388298a0c89f4a38b2fed4cd4123d441")
						.build(), new NetResquestSubscriber<>(new SubscriberOnNextListener<Object>() {

							@Override
							public void onNext(Object t) {
								System.out.println(t.toString());

							}
						}));
	}
	
	
	private static void apiSimple(){
		HttpClient httpClient=new HttpClient.Builder(BASE_URL).isDebug(true).add("header", "12345").build();
		httpClient.Api().send(new HttpClient.Builder()
				.url("user/appSearch")
				.add("name", "13266699268")
				.add("token", "388298a0c89f4a38b2fed4cd4123d441")
				.method(Method.POST)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

			@Override
			public void onResponse(Object t) {
				System.out.println(t);
				
			}
		}));
	}
	
	
	public static void saveBusiness(){
		String map="{\"ab_bman\":\"黄耀鹏,孙土桂\",\"ab_bmanid\":\"100119,100237\",\"ab_bcompany\":\"深圳市优软科技有限公司,深圳市优软科技有限公司\",\"ab_btelephone\":\"15018524229,13266703535\",\"ab_starttime\":\"2017-09-26 16:00\",\"ab_endtime\":\"2017-09-26 17:15\",\"ab_recordid\":\"100263\",\"ab_recordman\":\"刘杰\",\"ab_type\":\"高尔夫\",\"ab_confirmstatus\":\"未确认\",\"ab_address\":\"科技南五路5号英唐大厦6楼深圳市博源新通信科技有限公司\",\"ab_longitude\":\"113.95281170406882\",\"ab_latitude\":\"22.54080169455676\"}";
	   //this.headers.put("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
		HttpClient httpClient=new HttpClient.Builder(BASE_URL).isDebug(true)
				.add("header", "12345")
				.connectTimeout(5000)
				.readTimeout(5000)
				.build();
		httpClient.Api().send(new HttpClient.Builder()
				.url("user/appSaveBusiness")
				.add("map", StringEscapeUtils.unescapeJava(map))
				.add("token", "388298a0c89f4a38b2fed4cd4123d441")
				.method(Method.POST)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

			@Override
			public void onResponse(Object t) {
				System.out.println(t);
				
			}
		}));
	}
	
	

}
