package com.modular.rx.operators.create;

import com.modular.rx.operators.creating.From;
import com.modular.rx.utils.RxUtils;

public class FromTest {

	public static void main(String[] args) {
		// From.formArray();
		 From.fromCallable();
		// From.fromFuture();
		// From.fromIterable();// 不阻塞主线程
		RxUtils.threadInfo("---from end----");
	}

}
