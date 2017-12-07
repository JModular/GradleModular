package com.android.api;

import com.android.core.net.HttpClient;
import com.android.core.net.HttpClient.Method;
import com.android.retrofit.rx.Result2Listener;
import com.android.retrofit.rx.ResultListener;
import com.android.retrofit.rx.ResultSubscriber;
@SuppressWarnings("unused")
public class RetrofitApi {
    //Https方式
	private static final String BASE_URLS = "https://192.168.253.200:8081/Chapter/";
	//Http方式
	private static final String BASE_URL = "http://192.168.253.200:8080/Chapter/";

	public static void main(String[] args) {
		testException();
	}

	public static void testHeaders() {
		HttpClient httpClient = new HttpClient.Builder(BASE_URL).isDebug(false)
				.connectTimeout(5000)
				.readTimeout(5000)
				.build();
		httpClient.Api().send(new HttpClient.Builder().url("index.action")
				.add("header", "123459")
				.add("master", "usa")
				.add("token", "388298a0c89f4a38b2fed4cd4123d441")
				.method(Method.POST)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

					@Override
					public void onResponse(Object t) {
						System.out.println(t);

					}
				}));
	}

	public static void test200() {
		HttpClient httpClient = new HttpClient.Builder(BASE_URL).isDebug(true)
				.add("header", "12345")
				.add("master", "china")
				.connectTimeout(5000)
				.readTimeout(5000)
				.build();
		httpClient.Api().send(new HttpClient.Builder().url("/postParam")
				.add("header", "123459")
				.add("master", "usa")
				.add("token", "388298a0c89f4a38b2fed4cd4123d441")
				.method(Method.POST)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

					@Override
					public void onResponse(Object t) {
						System.out.println(t);

					}
				}));
	}

	public static void test500() {

	}

	public static void test404() {
		HttpClient httpClient = new HttpClient.Builder(BASE_URL).isDebug(true).build();
		httpClient.getHeaders().remove("client");
		HttpClient httb =
				new HttpClient.Builder().url("/postParam").add("dfw", "saf").add("df", "d").method(Method.POST).build();
		httb.getHeaders().remove("client");
		httpClient.Api().send(httb, new ResultSubscriber<Object>(new Result2Listener<Object>() {

			@Override
			public void onResponse(Object t) {
				System.out.println(" onResponse:" + t.toString());

			}

			@Override
			public void onFailure(Object t) {
				System.out.println("onFailure:" + t.toString());

			}
		}));
	}

	public static void testGet() {
		// http://lj.ubtob.com/appIndex
		HttpClient httpClient = new HttpClient.Builder("http://lj.ubtob.com/").isDebug(true).build();
		HttpClient httb = new HttpClient.Builder().url("appIndex").method(Method.GET).build();
		httpClient.Api().send(httb, new ResultSubscriber<Object>(new Result2Listener<Object>() {

			@Override
			public void onResponse(Object t) {
				System.out.println(" onResponse:" + t.toString());

			}

			@Override
			public void onFailure(Object t) {
				System.out.println("onFailure:" + t.toString());

			}
		}));
	}

	public static void testPost() {

	}

	public static void testUpload() {

	}

	public static void testDownload() {

	}

	public static void testJson() {

	}

	public static void testXml() {

	}

	public static void testException() {
		HttpClient httpClient = new HttpClient.Builder(BASE_URL).isDebug(true).build();
		httpClient.Api().send(new HttpClient.Builder().url("exception01")
				.add("token", "388298a0c89f4a38b2fed4cd4123d441")
				.method(Method.GET)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

					@Override
					public void onResponse(Object t) {
						System.out.println(t);
					}
				}));
		
	}

	/**
	 * 测试服务器拒绝访问异常 服务器超时连接超时异常
	 */
	public static void testConnectionException() {
		HttpClient httpClient = new HttpClient.Builder(BASE_URL).isDebug(true)
				.add("header", "12345")
				.connectTimeout(5000)
				.readTimeout(5000)
				.build();
		httpClient.Api()
				.send(new HttpClient.Builder().url("user/appSaveBusiness")
						.add("token", "388298a0c89f4a38b2fed4cd4123d441")
						.method(Method.POST)
						.build(), new ResultSubscriber<>(new ResultListener<Object>() {

							@Override
							public void onResponse(Object t) {
								System.out.println(t);

							}
						}));
	}

	public static void testHtmlApi() {
		HttpClient httpClient = new HttpClient.Builder("http://c.m.163.com/").isDebug(true).build();
		httpClient.Api()
				.send(new HttpClient.Builder().url("nc/video/list/V9LG4B3A0/n/1-20.html")
						.header("User-Agent",
								"Mozilla/5.0 (Linux; Android 5.1.1; Nexus 6 Build/LYZ28E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Mobile Safari/537.36")
						.method(Method.GET)
						.build(), new ResultSubscriber<Object>(new ResultListener<Object>() {

							@Override
							public void onResponse(Object o) {
								System.out.println(o.toString());
							}
						}));
	}

	public static void testTimer() {
		HttpClient httpClient = new HttpClient.Builder("http://113.105.74.140:8092/").build(true);
		httpClient.Api()
				.send(new HttpClient.Builder().url("user/appStepsrank")
						// token=2e0a8cb174d345cf87b62f2ed7ec8f83&userid=100263
						.add("token", "2e0a8cb174d345cf87b62f2ed7ec8f8")
						.add("userid", "100263")
						.add("client", "2343243")
						.header("content-type", "application/x-www-form-urlencoded;charset=UTF-8")
						.method(Method.GET)
						.build(), new ResultSubscriber<Object>(new Result2Listener<Object>() {

							@Override
							public void onResponse(Object o) {
								System.out.println(o.toString());
							}

							@Override
							public void onFailure(Object o) {
								// TODO Auto-generated method stub
								System.out.println(o.toString());

							}
						}));
	}
}
