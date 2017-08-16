package com.modular.rx.thread.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtil {
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	volatile static int i=0;
	public static void main(String[] args) {
		
	      while (true) {
	    	
			ThreadUtil.getInstance().addTask(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					System.out.println("执行线程！"+Thread.currentThread().getId());
					Thread.sleep(12000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
	    }
	}
	
	private static ThreadUtil instance = null;

    public static ThreadUtil getInstance() {
        if (instance == null) {
            synchronized (ThreadUtil.class) {
                instance = new ThreadUtil();
            }
        }
        return instance;
    }


    /**
     * 开启循环线程
     *
     * @param runnable
     */
    public void addLoopTask(Runnable runnable) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(runnable);
    }

    //普通线程
    public void addTask(Runnable runnable) {
       
        cachedThreadPool.execute(runnable);
    }

}
