package com.modular.rx.thread.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		 ExecutorService executorService = Executors.newCachedThreadPool();  
	        for (int i = 1; i < 1000000; i++)  
	            executorService.submit(new Runnable() {
					
					@Override
					public void run() {
						 try {  
							 System.out.println("i=");
					            Thread.sleep(15000);  
					        } catch (InterruptedException e) {  
					        	System.out.println("XXXX");
					            e.printStackTrace();  
					        }  
						
					}
				});  

	}

}
