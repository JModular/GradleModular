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
		System.out.println("线程D启动...");
//		try {
			while (!stoped) {
				if (list.size() == 5) {
					System.out.println("线程D:list.size()="+list.size());
					System.out.println("==5, 线程D准备退出了");
					//throw new InterruptedException();
					stoped=true;//关闭线程
					}
			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("线程D销毁...");
	}
}
