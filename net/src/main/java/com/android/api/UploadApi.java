package com.android.api;

import java.io.File;

import com.android.core.net.HttpClient;
import com.android.core.net.HttpClient.Method;
import com.android.retrofit.rx.ResultListener;
import com.android.retrofit.rx.ResultSubscriber;

/**
 * 上传接口
 * @author Arison
 *
 */
public class UploadApi {

	public static void main(String[] args) {
		//File f1 = new File("C://Users//Arison//Downloads//DropboxInstaller.exe");
		// File f2=new File("C://Users//Arison//Downloads//10015100100_2.exe");
		File f1 = new File("C://Users//Arison//Downloads//Android技术内部分享.pptx");
	    HttpClient httpClient=new HttpClient.Builder("https://admin-city.ubtob.com/").build();
        httpClient.Api().send(new HttpClient.Builder()
                .url("api/serve/uploadAttach.action")
                .add("access_token","12321")
                .add("file", f1)
                .filesKey("file")
                .add("client_type","cc")
                .method(Method.POST)
                .build(),new ResultSubscriber<Object>(new ResultListener<Object>() {

            @Override
            public void onResponse(Object o) {
                  System.out.println("o:"+o.toString());
            }
        }));
	}

}
