package com.modular.rx.operators.create;

import com.modular.rx.operators.creating.Just;
import com.modular.rx.utils.RxUtils;

public class JustTest {

	public static void main(String[] args) {

		// 耗时任务会阻塞当前执行线程！
		Just.JustList();
		RxUtils.threadInfo("---Just end----");

	}

}
