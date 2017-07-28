package com.modular.rx.subscriber;

import com.alibaba.fastjson.JSON;
import com.modular.rx.utils.RxUtils;

import rx.Subscriber;


/**
 * 通用订阅事件
 * @author Arison
 * @param <T>
 */
public class ProxySubscriber<T> extends Subscriber<T> {

	@Override
	public void onCompleted() {
	  
		
	}

	@Override
	public void onError(Throwable e) {
		e.printStackTrace();
		
	}

	@Override
	public void onNext(T t) {
	 RxUtils.threadInfo("onNext start:");
		System.out.println(JSON.toJSON(t));
	 RxUtils.threadInfo("onNext end:");
	}

}
