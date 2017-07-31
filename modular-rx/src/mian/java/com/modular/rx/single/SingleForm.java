package com.modular.rx.single;

import java.util.List;
import java.util.concurrent.Callable;

import com.modular.rx.subscriber.ProxySingleSubscriber;
import com.modular.rx.utils.DataUtils;
import com.modular.rx.utils.RxUtils;

import rx.Single;

/**
 * Single+Form������
 * 
 * @author Arison
 *
 */
public class SingleForm {

	public static void formCallable() {

		Single<List<String>> tvShowSingle = Single.fromCallable(new Callable<List<String>>() {

			@Override
			public List<String> call() throws Exception {
				RxUtils.threadWait();
				System.out.println("fromCallable ֻ����subsribe����ִ��֮���ִ�У�");
				return DataUtils.getList(String.class);
			}
		});
		
		tvShowSingle.subscribeOn(RxUtils.getNamedScheduler("�̣߳�0812"))
				.observeOn(RxUtils.getNamedScheduler("�̣߳�0815"))
				.subscribe(new ProxySingleSubscriber<List<String>>());
	}
}
