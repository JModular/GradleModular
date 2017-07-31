package com.modular.rx.subjects;

import com.modular.rx.subscriber.ProxySubscriber;

import rx.subjects.PublishSubject;

public class PublishSubjectDemo {

	static PublishSubject<String> pSubject;
	
	public static void simpleCase() {
		pSubject=PublishSubject.create();
		
		pSubject.subscribe(new ProxySubscriber<String>());
		
		
	}
	
	public static void sendMessage(String msg) {
		pSubject.onNext(msg);
	}
	
}
