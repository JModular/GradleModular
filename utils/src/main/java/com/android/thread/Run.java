package com.android.thread;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		 

	}



	private static void testWait() throws InterruptedException {
		Object service=new Object();
		ThreadE te=new ThreadE(service);
		te.start();
		Thread.sleep(50);
		ThreadF tf=new ThreadF(service);
		tf.start();
	}



	private static void testWhile() {
		MyList service=new MyList();
		  
		ThreadC tc=new ThreadC(service);
		ThreadD td=new ThreadD(service);
		  
		tc.start();

		td.start();
	}

	
	
	@SuppressWarnings("unused")
	private static void testSynchronized() throws InterruptedException {
		MyObject object = new MyObject();

		//�߳�A���߳�B ���е���ͬһ������:object
		ThreadA a = new ThreadA(object);
		ThreadB b = new ThreadB(object);
		a.start();	  
		//��������ͣһ�ᣬ���߳�A���Ȼ�ȡ���������߳�B����ȴ��߳�Aִ���귽��methodA֮�󣬲���ִ��methodB
		Thread.sleep(1000);
		b.start();
	}

}
