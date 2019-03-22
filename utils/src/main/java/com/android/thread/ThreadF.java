package com.android.thread;

public class ThreadF extends Thread {
	private  Object list;
	
	public ThreadF(Object list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		System.out.println("线程F开始执行...");
		synchronized (list) {
			for (int i = 0; i < 12; i++) {
				MyList.add();
				if (MyList.size()==5) {
					list.notify();
					System.out.println("线程F发布  notify通知");
				}
				System.out.println("线程F 添加了" + (i + 1) + "个元素!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("线程F等待十秒...");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("线程F销毁...");
		
	}
}
