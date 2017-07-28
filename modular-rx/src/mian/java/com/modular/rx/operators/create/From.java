package com.modular.rx.operators.create;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.modular.rx.subscriber.ProxySubscriber;
import com.modular.rx.utils.DataUtils;
import com.modular.rx.utils.RxUtils;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

//fromArray��fromCallable��fromFuture��fromIterable��fromPublisher
public class From {

	public static void formArray() {
		Integer[] items = { 0, 1, 2, 3, 4, 5 };
		Observable<Integer> myObservable = Observable.from(items);
		myObservable.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t);

			}
		}, new Action1<Throwable>() {

			@Override
			public void call(Throwable t) {
				t.printStackTrace();

			}
		}, new Action0() {

			@Override
			public void call() {
				System.out.println("complete");

			}
		});

	}

	
	/**
	 * fromCallable ������
	 * ָ����ȡ����Դ �����߳����У������������߳�
	 * 
	 */
	public static void fromCallable() {
		Observable.fromCallable(new Callable<List<String>>() {

			@Override
			public List<String> call() throws Exception {
				return DataUtils.getList(String.class);
			}
		})
		.subscribeOn(RxUtils.getNamedScheduler("�̣߳�0812"))
		.observeOn(RxUtils.getNamedScheduler("�̣߳�0815"))
		.subscribe(new ProxySubscriber<List<String>>());
		//��д�����������д��
		Observable.fromCallable(()->{
			return DataUtils.getList(String.class);
		})
		.subscribeOn(RxUtils.getNamedScheduler("�̣߳�0816"))
		.observeOn(RxUtils.getNamedScheduler("�̣߳�0817"))
		.subscribe(new ProxySubscriber<List<String>>());
	}
	
	
	public static void fromFuture(){
		List<FutureTask<String>> future=new ArrayList<FutureTask<String>>() ;
		
		future.add(new FutureTask<>(new Callable<String>() {

			@Override
			public String call() throws Exception {
			
				return "test";
			}
		}));
		
		future.add(new FutureTask<>(new Callable<String>() {

			@Override
			public String call() throws Exception {
			
				return "test1";
			}
		}));
		
		future.add(new FutureTask<>(new Callable<String>() {

			@Override
			public String call() throws Exception {
			
				return "test2";
			}
		}));
		
	   for (FutureTask<String> future2 : future) {
			future2.run();
		}
		//����FutureTask
		FutureTask<String> future1=new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
			
				return "test";
			}
		});
		 
		 future1.run();
		 
		 
	   
		Observable.from(future)
		.subscribeOn(RxUtils.getNamedScheduler("�̣߳�0812"))
		.observeOn(RxUtils.getNamedScheduler("�̣߳�0815"))
		.map(new Func1<FutureTask<String>, String>() {

			@Override
			public String call(FutureTask<String> t) {
				try {
					return t.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
				return null;
			}
		})
		.subscribe(new ProxySubscriber<String>());
		
	}

}
