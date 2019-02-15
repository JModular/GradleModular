package com.android.api;

import com.github.kevinsawicki.http.HttpRequest;

/**
 * 人脸设备对接Http对接通信
 * @author Arison
 *
 */
public class SmartSchoolApi {
	
	private static String baseUrl="http://10.1.80.196:8085/";
      
	public static void main(String[] args) {
		

	}
	
	/**
	 * 添加白名单
	 */
	public static void add(){
		HttpRequest request=  HttpRequest.get(baseUrl+"")
				 .form("telephone", "13430818775");
		String result=request.body();
		System.out.println(""+result);
	}
	
	/**
	 * 请求白名单
	 * 
	 */
	public static void list(){
		HttpRequest request =HttpRequest.post(baseUrl+"")
				.form("","");
		String result=request.body();
		System.out.println(""+result);
	}
	
	/**
	 * 删除白名单
	 */
	public static void delete(){
		HttpRequest request =HttpRequest.post(baseUrl+"")
				.form("","");
		String result=request.body();
		System.out.println(""+result);
		
	}

}
