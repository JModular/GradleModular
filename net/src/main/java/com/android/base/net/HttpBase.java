package com.android.base.net;

import rx.Subscriber;

/**
 * 网络操作抽象类
 * @author Arison
 *
 */
public abstract class HttpBase {
	
	
	/**
	 * 全局配置参数
	 */
	public HttpClient mbuilder;
	/**
	 * 设置全局builder 
	 * 初始化全局参数
	 * @param client
	 */
	public void setBuilder(HttpClient client) {
		this.mbuilder=client;
	}
	
    /**
     * 初始化具体的网络请求客户端
     * 初始化全局参数
     * 比如Okhttp,Retrofit,Volley,HttpClient,HttpUrlConnection
     */
    public abstract void initClient();
    
	
	/**
	 * @param builder
	 * @param s rxjava
	 */
	public  void send(HttpClient builder,Subscriber<Object> s){
		if (builder.getMethod()==HttpClient.Method.GET) {
			get(builder, s);
		}
		if (builder.getMethod()==HttpClient.Method.POST) {
			post(builder, s);
		}
	};
	
	public abstract void get(HttpClient builder,Subscriber<Object> s);
	
	public abstract void post(HttpClient builder,Subscriber<Object> s);
	
}
