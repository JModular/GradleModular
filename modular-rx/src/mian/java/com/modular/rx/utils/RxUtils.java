package com.modular.rx.utils;

import java.util.concurrent.Executors;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class RxUtils {

	
	public static Scheduler getNamedScheduler(String name) {
		return Schedulers.from(Executors.newCachedThreadPool(r -> new Thread(r,
				name)));
	}

	public static void threadInfo(String caller) {
		System.out.println(caller + " => " + Thread.currentThread().getName());
	}
}
