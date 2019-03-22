package com.android.thread;

public class ThreadE extends Thread {
	private Object list;
	
	
	
	public ThreadE(Object list) {
		super();
		this.list = list;
	}



	@Override
	public void run() {
		System.out.println("�߳�E��ʼִ��...");
		synchronized (list) {
			if(MyList.size()!=5){
				System.out.println("�߳� E wait begin "+ System.currentTimeMillis());
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				 System.out.println("�߳� E wait end "+ System.currentTimeMillis());
			}
		}
		System.out.println("�߳�E����...");
	}
}
