package com.modular.rx.operators.create;

import com.modular.rx.utils.RxUtils;

public class FromTest {

	public static void main(String[] args) {
	    //From.formArray();
	    //From.fromCallable();
	    From.fromFuture();
	    RxUtils.threadInfo("---from end----");
	}

}
