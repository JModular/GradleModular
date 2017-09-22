package com.android.demo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.android.core.utils.RxBus;

import rx.Subscriber;

public class OkhttpApp {

	public static final String BASE_URL = "http://192.168.253.200:8080/Chapter/";

	public static void main(String[] args) {
		initOkhttp();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id1", "1");
		params.put("id2", "2");
		params.put("id3", "3");
		params.put("id4", "4");

		// sendHttpMethod(params);//get,post方法

		// uploadFile(params);//单文件上传

		uploadMulitFiles(params);// 多文件上传

	}

	@SuppressWarnings("unused")
	private static void sendHttpMethod(Map<String, Object> params) {
		// 访问get请求 -----> 404,500 走onResponse(Call call, Response response)
		OkhttpUtils.sendGetHttp(BASE_URL + "exception04", params, null, null);
		// 访问post请求
		OkhttpUtils.sendPostHttp(BASE_URL + "param", params, null, null);
	}

	/**
	 * 上传单个文件 建议使用uploadMulitFiles代替
	 * 
	 * @param params
	 */
	@SuppressWarnings("unused")
	private static void uploadFile(Map<String, Object> params) {
		// 上传单个文件---可以直接使用多文件上传函数
		OkhttpUtils.uploadFile(
				BASE_URL + "uploadSigleFile",
				params,
				"C://Users//Arison//Downloads//JJPlayer_2.8.2.1_setup_jjvod.1444617961.exe");

		OkhttpUtils.uploadFile(
				BASE_URL + "uploadFile",
				params,
				"C://Users//Arison//Downloads//JJPlayer_2.8.2.1_setup_jjvod.1444617961.exe");
	}

	/**
	 * 多文件上传
	 * 
	 * @param params
	 */
	private static void uploadMulitFiles(Map<String, Object> params) {
		// 上传多个文件+普通的表单参数

		File f1 = new File("C://Users//Arison//Downloads//DropboxInstaller.exe");
		// File f2=new File("C://Users//Arison//Downloads//10015100100_2.exe");
		File f3 = new File("C://Users//Arison//Downloads//Android技术内部分享.pptx");

		params.put("file1", f1);
		// params.put("file2", f2);
		params.put("file3", f3);

		OkhttpUtils.uploadFile(BASE_URL + "uploadFiles", params);
		OkhttpUtils.uploadFile(BASE_URL + "uploadMulitFiles", params);
	}

	private static void initOkhttp() {
		// 重连次数
		OkhttpUtils.maxLoadTimes = 0;

		RxBus.getInstance().toObservable().subscribe(new Subscriber<Object>() {

			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(Object t) {
				OkhttpUtils.println("请求结果:" + t.toString());

			}
		});
	}

}
