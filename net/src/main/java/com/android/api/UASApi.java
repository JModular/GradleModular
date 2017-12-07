package com.android.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.android.core.net.HttpClient;
import com.android.core.net.HttpClient.Method;
import com.android.retrofit.rx.ResultListener;
import com.android.retrofit.rx.ResultSubscriber;

public class UASApi {
	public static void main(String[] args) {
//		HttpClient.getInstance(new HttpClient.Builder("http://qq784602719.imwork.net:43580/"))
//		.Api()
//		.send(new HttpClient.Builder("user/list")
//				.build(), new ResultSubscriber<>(new Result2Listener<Object>() {
//
//					@Override
//					public void onResponse(Object t) {
//						System.out.println("success:"+t.toString());
//						
//					}
//
//					@Override
//					public void onFailure(Object t) {
//						System.err.println("failure:"+t.toString());
//						
//					}
//				}));
		
		
		HttpClient.getInstance(new HttpClient.Builder("http://qq784602719.imwork.net:43580/"))
		.Api()
		.send(new HttpClient.Builder("user/list")
				.header("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
				.add("page", 0)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

					@Override
					public void onResponse(Object t) {
						System.out.println("success:"+t.toString());
						
					}

				}));
	}

	
	
	public static void testSession(){
		 Map<String,Object> headers=new LinkedHashMap<>();
		 headers.put("Cookie", "sessionId="+"0508dsafdafasdfwqewrqe");
		 headers.put("Cookie1", "12329320491");
		  HttpClient httpClient=new HttpClient.Builder("http://192.168.253.200:8080/Chapter/").build();
          httpClient.Api().send(new HttpClient.Builder()
          .url("getParam")
          .add("kind","cc")
          .header("Cookie", "sessionId="+"0908dsafdafasdfwqewrqe")
          .addHeaders(headers)
          .method(Method.GET)
          .build(),new ResultSubscriber<Object>(new ResultListener<Object>() {
   
              @Override
              public void onResponse(Object o) {
                  System.out.println(o.toString());
              }
          }));
		
//		  HttpClient httpClient=new HttpClient.Builder("http://192.168.253.31:8687/city/thxz/").build();
//          httpClient.Api().send(new HttpClient.Builder()
//          .url("api/serve/getDefaultServices.action")
//          .add("kind","cc")
//          .method(Method.POST)
//          .build(),new ResultSubscriber<Object>(new ResultListener<Object>() {
//   
//              @Override
//              public void onResponse(Object o) {
//                  System.out.println(o.toString());
//              }
//          }));
	}
	
	
	public void testAPI(){
		//https://218.17.158.219:9443/uas_test/common/dbfind.action?which=form&ob=&client=Android%20Client&pageSize=20&condition=upper(cu_servicecode)%20like%20%27%25%25%27&field=cu_servicecode&caller=Customer!Base&page=1&_config=&master=UAS_TEST&sessionUser=U0736&sessionId=4A15660FED697CCF6B83C3AE5B9872D4
	
			
			 HttpClient httpClient=new HttpClient.Builder("https://218.17.158.219:9443/uas_test/")
					 .isDebug(true)
					  .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
					 .header("Cookie", "JSESSIONID=4A15660FED697CCF6B83C3AE5B9872D4")
					 .build();
	         httpClient.Api().send(new HttpClient.Builder()
	         .url("common/dbfind.action")
	         .add("which", "form")
	         .add("ob", "")
	         .add("pageSize", "20")
	         .add("page", "1")
	         .add("condition", "upper(cu_servicecode) like '%ZH%'")
	         .add("field", "cu_servicecode")
	         .add("caller", "Customer!Base")
	         .add("master", "UAS_TEST")
	         .add("_config", "")
	         .add("sessionUser", "U0736")
	       
	         .add("sessionId","4A15660FED697CCF6B83C3AE5B9872D4")
	         .method(Method.GET)
	         .build(),new ResultSubscriber<Object>(new ResultListener<Object>() {
	  
	             @Override
	             public void onResponse(Object o) {
	                 System.out.println(o.toString());
	             }
	         }));
			
			
			
//			   HttpClient httpClient=new HttpClient.Builder("http://192.168.253.29:8080/ERP/").isDebug(true).build();
//	           httpClient.Api().send(new HttpClient.Builder()
//	           .url("api/serve/query.action")
//	           .add("page","1")
//	           .add("pageSize","20")
//	           .add("serve_id", "54")
//	           //client_type=cc  access_token=234434 
//	           .add("client_type", "cc")
//	           .add("access_token", "234434")
//	           .method(Method.GET)
//	           .build(),new ResultSubscriber<Object>(new ResultListener<Object>() {
	//    
//	               @Override
//	               public void onResponse(Object o) {
//	                   System.out.println(o.toString());
//	               }
//	           }));
	}
	
}
