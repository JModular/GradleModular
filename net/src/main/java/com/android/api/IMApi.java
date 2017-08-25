package com.android.api;

import java.io.File;

import com.alibaba.fastjson.JSON;
import com.android.core.net.HttpClient;
import com.android.core.net.HttpClient.CacheType;
import com.android.core.net.RetrofitImpl;
import com.android.retrofit.subscriber.NetResquestSubscriber;
import com.android.retrofit.subscriber.SubscriberOnNextListener;


public class IMApi {
	
	public static final String BASE_URL = "http://113.105.74.140:8092/";

	public static HttpClient httpClient = new HttpClient.Builder(BASE_URL)// 根路径
			.header("Cookie", "abdclejdldj82jk23jfjd")// 全局请求头 //局部可累加
			.header("Cache-control", "max-age=600")
			.maxRetryCount(0)// 局部可覆盖
			.isDebug(false)// 局部可覆盖
			.retryTimeout(1000)// 局部可覆盖
			.cacheFile(new File("C:/Cache"))// 局部可覆盖
			.cacheFileSize(1024000 * 1024)// 局部可覆盖
			.cacheType(CacheType.ONLY_NETWORK)// 局部可覆盖
			.cacheTime(60 * 200)// 设置10分钟 //局部可覆盖
			.connectTimeout(5000)// 局部可覆盖
			.readTimeout(5000)// 局部可覆盖
			.writeTimeout(7000)// 局部可覆盖
			.httpBase(RetrofitImpl.getInstance())// 局部可覆盖
			.build(true);// 保持单例

	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			searchByKey("13266699268");
		}
	}
	
	
	private static void searchByKey(String key) {
	httpClient.Api().send(new HttpClient.Builder().url("user/appSearch")
			.add("name", "13266699268")
			.add("token", "388298a0c89f4a38b2fed4cd4123d441")
						.build(),
			new NetResquestSubscriber<>(new SubscriberOnNextListener<Object>() {

				@Override
				public void onNext(Object t) {
				System.out.println(JSON.toJSONString(t));
					
				}
			}));
	}

}
