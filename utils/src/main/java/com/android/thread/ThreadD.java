package com.android.thread;

public class ThreadD extends Thread {
	private MyList list;
	
	private boolean stoped=false;

	public ThreadD(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		System.out.println("�߳�D����...");
//		try {
			while (!stoped) {
				if (list.size() == 5) {
					System.out.println("�߳�D:list.size()="+list.size());
					System.out.println("==5, �߳�D׼���˳���");
					//throw new InterruptedException();
					stoped=true;//�ر��߳�
					}
			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("�߳�D����...");
	}
}
