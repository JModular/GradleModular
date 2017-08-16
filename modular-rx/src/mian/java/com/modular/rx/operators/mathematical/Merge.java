package com.modular.rx.operators.mathematical;

import java.util.concurrent.TimeUnit;

import com.modular.rx.utils.RxUtils;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class Merge {

	public static void main(String[] args) {
      
	//	mergeSimple();
		mergeDelayError();
	}
	
	public static void  mergeSimple(){
		Observable<Integer> adds=Observable.just(1,2,3).subscribeOn(RxUtils.getNamedScheduler("线程1"));
		Observable<String> events=Observable.just("china","usa","jrans").subscribeOn(RxUtils.getNamedScheduler("线程1"));
		Observable<Integer> afters=Observable.just(15,16,17).subscribeOn(RxUtils.getNamedScheduler("线程1"));;
		Observable.merge(adds,events,afters)
		//.subscribe(new ProxySubscriber<Object>());
		.subscribe(new Subscriber<Object>() {

			@Override
			public void onCompleted() {
				System.out.println("onCompleted()");
				
			}

			@Override
			public void onError(Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void onNext(Object t) {
				if(t instanceof String){
					System.out.println("字符串："+t);
				}else{
					System.out.println(t);
				}
			
				
			}
		});
	}
	
	@SuppressWarnings("deprecation")
	public static void mergeDelayError(){
	     //产生0,5,10数列,最后会产生一个错误
        Observable<Long> errorObservable = Observable.error(new Exception("this is end!"));
        Observable < Long > observable1 = Observable.timer(0, 1000, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return aLong * 5;
                    }
                }).take(3).mergeWith(errorObservable.delay(3500, TimeUnit.MILLISECONDS));

        //产生0,10,20,30,40数列
        Observable<Long> observable2 = Observable.timer(500, 1000, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return aLong * 10;
                    }
                }).take(5);

        Observable.mergeDelayError(observable1, observable2)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Sequence complete.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.err.println("Error: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("Next:" + aLong);
                    }
                });
	}

}
