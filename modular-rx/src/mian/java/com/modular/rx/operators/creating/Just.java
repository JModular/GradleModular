package com.modular.rx.operators.creating;

import java.util.List;

import com.modular.rx.subscriber.ProxySubscriber;
import com.modular.rx.utils.DataUtils;
import com.modular.rx.utils.RxUtils;

import rx.Observable;

public class Just {

	public static void JustList() {
		Observable<List<Integer>> listObservable = Observable.just(DataUtils.getList(Integer.class));
		listObservable.subscribeOn(RxUtils.getNamedScheduler("线程：0812"))
				.observeOn(RxUtils.getNamedScheduler("线程：0815"))
				.subscribe(new ProxySubscriber<List<Integer>>());
	}

}
