package com.android.api;

import com.android.core.net.HttpClient;
import com.android.core.net.HttpClient.Method;
import com.android.retrofit.subscriber.NetResquestSubscriber;
import com.android.retrofit.subscriber.SubscriberOnNextListener;

public class PlatformApi {

	public static void main(String[] args) {
	
		testApi();
	}
	
	
	public static void testApi(){
		   HttpClient httpClient=new HttpClient.Builder("https://account.ubtob.com/")
				   .isDebug(true)
				   .build();
	        httpClient.Api().send(new HttpClient.Builder("api/userspace/userSpaceDetail/keyword")
	                .add("keyword","深")
	                .add("pageNumber","1")
	                .method(Method.GET)
	                .build(),new NetResquestSubscriber<>(new SubscriberOnNextListener<Object>() {

						@Override
						public void onNext(Object t) {
							System.out.println(t);
							
						}
					}));
	}

}
