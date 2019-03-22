package com.android.thread;

public class ThreadC extends Thread {

	private MyList list;

	public ThreadC(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		System.out.println("�߳�C����...");
		for (int i = 0; i < 10; i++) {
			list.add();
			System.out.println("�����" + (i + 1) + "��Ԫ��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
		System.out.println("�߳�C����...");
	}
}
