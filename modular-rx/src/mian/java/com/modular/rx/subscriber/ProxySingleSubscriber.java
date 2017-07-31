package com.modular.rx.subscriber;

import com.alibaba.fastjson.JSON;
import com.modular.rx.utils.RxUtils;

import rx.SingleSubscriber;

public class ProxySingleSubscriber<T> extends SingleSubscriber<T> {

	@Override
	public void onSuccess(T value) {
		RxUtils.threadInfo("onNext start:");
		System.out.println(JSON.toJSON(value));
		RxUtils.threadInfo("onNext end:");

	}

	@Override
	public void onError(Throwable e) {
		e.printStackTrace();
	}

}
