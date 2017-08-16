package com.modular.rx.operators.creating;

import java.util.concurrent.TimeUnit;

import com.modular.rx.utils.RxUtils;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * timer Deprecated
 * 
 * @author Arison
 *
 */
public class Timer {

	public static void main(String[] args) {
		 timerSimple();
		//interval();

	}

	public static void interval() {
		Observable.interval(0, 1, TimeUnit.SECONDS)
				.subscribeOn(RxUtils.getNamedScheduler("线程1"))
				.subscribe(new Observer<Long>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onNext(Long aLong) {
						System.out.println(aLong);
					}
				});
		
		while(true){
			
		}
	}

	@SuppressWarnings("deprecation")
	public static void timerSimple() {

		Observable.timer(0, 1, TimeUnit.SECONDS)
				.subscribeOn(RxUtils.getNamedScheduler("线程1"))
				.map(new Func1<Long, Long>() {

					@Override
					public Long call(Long t) {
						return t * 5;
					}
				})
				// .take(9)
				.subscribe(new Subscriber<Long>() {

					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onNext(Long t) {
						System.out.println(t);

					}
				});
        while(true){
			
		}
	}
	

}
