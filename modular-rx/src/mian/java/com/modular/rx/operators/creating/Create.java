package com.modular.rx.operators.creating;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class Create {

	public static void createSimple() {
		Observable.create(new OnSubscribe<String>() {

			@Override
			public void call(Subscriber<? super String> observer) {
				try {
					if (!observer.isUnsubscribed()) {
						for (int i = 1; i < 5; i++) {
							observer.onNext(i + "");
							if (i == 3) {
								throw new Exception("等于3出现异常！");
							}

						}
						observer.onCompleted();
					}
				} catch (Exception e) {
					observer.onError(e);
				}

			}
		}).subscribe(new Subscriber<String>() {

			@Override
			public void onCompleted() {
				System.out.println("onCompleted");

			}

			@Override
			public void onError(Throwable e) {
				e.printStackTrace();

			}

			@Override
			public void onNext(String t) {
				System.out.println(t);

			}
		});
	}
}
