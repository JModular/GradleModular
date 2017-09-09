package com.android.api;

import org.apache.commons.lang.StringEscapeUtils;

import com.android.core.net.HttpClient;
import com.android.core.net.HttpClient.Method;
import com.android.retrofit.rx.ResultListener;
import com.android.retrofit.rx.ResultSubscriber;

public class RetrofitApi {
	
	private static final String BASE_URL="http://localhost:8080/Chapter/";

	public static void main(String[] args) {
       testConnectionException();

	}
	
	public static void test200(){
		
	}
	
	public static void test500(){
		
	}
	
	public static void test400(){
		
	}
	
	public static void testGet(){
		
	}
	
	public static void testPost(){
		
	}
	
	public static void testUpload(){
		
	}
	
	public static void testDownload(){
		
	}
	
	public static void testJson(){
		
	}
	
	
	public static void testXml(){
		
	}
	
	public static void testException(){
		
	}
	
	
	/**
	 * 测试服务器拒绝访问异常
	 * 服务器超时连接超时异常
	 */
	public static void testConnectionException(){
		HttpClient httpClient=new HttpClient.Builder(BASE_URL).isDebug(true)
				.add("header", "12345")
				.connectTimeout(5000)
				.readTimeout(5000)
				.build();
		httpClient.Api().send(new HttpClient.Builder()
				.url("user/appSaveBusiness")
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
