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

		//线程A与线程B 持有的是同一个对象:object
		ThreadA a = new ThreadA(object);
		ThreadB b = new ThreadB(object);
		a.start();	  
		//这里先暂停一会，让线程A优先获取对象锁。线程B必须等待线程A执行完方法methodA之后，才能执行methodB
		Thread.sleep(1000);
		b.start();
	}

}
