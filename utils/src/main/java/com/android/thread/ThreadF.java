package com.android.thread;

public class ThreadF extends Thread {
	private  Object list;
	
	public ThreadF(Object list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		System.out.println("�߳�F��ʼִ��...");
		synchronized (list) {
			for (int i = 0; i < 12; i++) {
				MyList.add();
				if (MyList.size()==5) {
					list.notify();
					System.out.println("�߳�F����  notify֪ͨ");
				}
				System.out.println("�߳�F �����" + (i + 1) + "��Ԫ��!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("�߳�F�ȴ�ʮ��...");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("�߳�F����...");
		
	}
}
