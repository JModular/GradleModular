package com.android.thread;

public class ThreadC extends Thread {

	private MyList list;

	public ThreadC(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		System.out.println("线程C启动...");
		for (int i = 0; i < 10; i++) {
			list.add();
			System.out.println("添加了" + (i + 1) + "个元素");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
		System.out.println("线程C销毁...");
	}
}
