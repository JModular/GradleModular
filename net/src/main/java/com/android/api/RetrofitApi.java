package com.android.api;

import java.io.File;

import com.alibaba.fastjson.JSON;
import com.android.core.net.HttpClient;
import com.android.core.net.HttpClient.Method;
import com.android.core.net.OkhttpImpl;
import com.android.retrofit.rx.Result2Listener;
import com.android.retrofit.rx.ResultListener;
import com.android.retrofit.rx.ResultSubscriber;
@SuppressWarnings("unused")
public class RetrofitApi {
    //Https方式
	private static final String BASE_URLS = "https://192.168.253.200:8081/Chapter/";
	//Http方式
	private static final String BASE_URL = "http://192.168.253.200:8080/Chapter/";
	
	private static final String APPID="wxbc1f8607137d3b8a";
	
	private static final String  AppSecret ="cadf13c4e21c2c122cb2341b341e5c22";
    
	String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxbc1f8607137d3b8a&"
			+ "redirect_uri="
			+ "http://qq784602719.imwork.net/wxlogin&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	String loginurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxbc1f8607137d3b8a&redirect_uri=http%3a%2f%2fqq784602719.imwork.net%2fwxlogin&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
	
	
	static String openId="o8lZ9uFG2FswQt_kPkBu2G_ac2TU";
	//o8lZ9uGnn074M2wiP_5cWsZ3NL8s
	//o8lZ9uIQ41kV_1_wimarsRSuCH98
	//o8lZ9uFsI8dHoh4-Kf-EI8babwj4
	//o8lZ9uL7H-1nWjGk1awUJdyh_9Rg
	//o8lZ9uFG2FswQt_kPkBu2G_ac2TU  小燕子
	
	//o8lZ9uIQ41kV_1_wimarsRSuCH98
	public static void main(String[] args) {
		getAcessToken(openId);
	}

	public static void getAcessToken(String openid){
		HttpClient httpClient = new HttpClient.Builder("https://api.weixin.qq.com/").isDebug(false)
				.connectTimeout(5000)
				.readTimeout(5000)
				.build();
		httpClient.Api().send(new HttpClient.Builder().url("cgi-bin/token")
				.add("grant_type", "client_credential")
				.add("appid", APPID)
				.add("secret", AppSecret)
				.method(Method.GET)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

					@Override
					public void onResponse(Object t) {
						System.out.println(t);
                      String access_token=JSON.parseObject(t.toString()).getString("access_token");
                      //getWxTemple(access_token);
                     // getUserInfo(access_token,"ovR4k0SMuiKh-vhfuKhl1sIO2VI8");
                      getSendMsgTemple(openid,access_token);
					}
				}));
		
	}
	
	
	public static void getUserInfo(String access_token,String openId){
		HttpClient httpClient = new HttpClient.Builder("https://api.weixin.qq.com/").isDebug(true)	
				.build();
		httpClient.Api().send(new HttpClient.Builder()
				.url("cgi-bin/user/info")
				.add("access_token", access_token)
				.add("openid", openId)
				.add("lang","zh_CN")
				.httpBase(OkhttpImpl.getInstance())
				.method(Method.GET)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

					@Override
					public void onResponse(Object t) {
						System.out.println("用户消息："+t);
                    
					}
				}));
	}
	
	public static void getWxTemple(String access_token){
		HttpClient httpClient = new HttpClient.Builder("https://api.weixin.qq.com/").isDebug(true)	
				.build();
		httpClient.Api().send(new HttpClient.Builder()
				.url("cgi-bin/template/get_all_private_template")
				.add("access_token", access_token)
				//.add("body", "access_token="+access_token)
				.httpBase(OkhttpImpl.getInstance())
				.method(Method.GET)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

					@Override
					public void onResponse(Object t) {
						System.out.println("模板消息："+t);
                    
					}
				}));
		
	}
	
	
	
	public static void getSendMsgTemple(String openid ,String access_token){
		String json="{\"touser\":\""+openid+"\",\"template_id\":\"oi4SokVV7Is0kZz5w8VJG1b3zrLWtApqftCN4iJ3Iyc\","
				+ "\"url\":\""+"http://qq784602719.imwork.net/html/welcome.html"+"\","
				+ "\"data\":{\"first\":{\"value\":\"刘杰向您提交了请假条！\",\"color\":\"#173177\"},\"keyword1\":{\"value\":\"骑车去旅行\",\"color\":\"#173177\"},\"keyword2\":{\"value\":\"事假\",\"color\":\"#173177\"},\"keyword3\":{\"value\":\"2018年09月30日 12:00到18:00\",\"color\":\"#173177\"},\"keyword4\":{\"value\":\"半天\",\"color\":\"#173177\"},\"remark\":{\"value\":\"点击模板URL进入调转界面！！！\",\"color\":\"#173177\"}}}";
		HttpClient httpClient = new HttpClient.Builder("https://api.weixin.qq.com/").isDebug(true)	
				.build();
		httpClient.Api().send(new HttpClient.Builder()
				.url("cgi-bin/message/template/send")
				.add("access_token", access_token)
				.add("body", json)
				.httpBase(OkhttpImpl.getInstance())
				.method(Method.POST)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

					@Override
					public void onResponse(Object t) {
						System.out.println("发送消息："+t);
                    
					}
				}));
		
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
//
		File f1 = new File("C://Users//Arison//Downloads//QQ截图20180925160836.png");
		HttpClient httpClient = new HttpClient.Builder("https://mobile.ubtob.com:8443/linkman/").isDebug(true).build();

		httpClient.Api().send(new HttpClient.Builder().url("mobile/upload")
				.filesKey("file")
				.add("file1", f1)
				.method(Method.POST)
				.build(), new ResultSubscriber<>(new ResultListener<Object>() {

					@Override
					public void onResponse(Object t) {
						System.out.println(t);
					}
				}));
		
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
