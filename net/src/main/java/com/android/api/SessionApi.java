package com.android.api;

import com.android.core.net.HttpClient;
import com.android.core.net.HttpClient.Method;
import com.android.retrofit.rx.ResultListener;
import com.android.retrofit.rx.ResultSubscriber;

public class SessionApi {

	public static void main(String[] args) {
		 //testLogin();
		
		 testGetUser();
	}
	
	public static void testLogin(){
		HttpClient httpClient=new HttpClient.Builder("http://192.168.253.200:8080/Chapter/").build();
        httpClient.Api().send(new HttpClient.Builder()
        .url("user/13266699268/111111")
        .method(Method.POST)
        .build(),new ResultSubscriber<Object>(new ResultListener<Object>() {
 
            @Override
            public void onResponse(Object o) {
                System.out.println(o.toString());
               
            }
        }));
	}
	
	//http://192.168.253.200:8080/Chapter/user/info
	//http://192.168.253.200:8080/Chapter/getParam/app/json
	public static void testGetUser(){
		  HttpClient httpClient=new HttpClient.Builder("http://192.168.253.200:8080/Chapter/")
				  .build();
          httpClient.Api().send(new HttpClient.Builder()
          .url("user/info")
          .header("Cookie", "JSESSIONID=B2608EA1BFF429E128D358374133D614")
          .method(Method.GET)
          .build(),new ResultSubscriber<Object>(new ResultListener<Object>() {
   
              @Override
              public void onResponse(Object o) {
                  System.out.println(o.toString());
              }
          }));
	}

}
