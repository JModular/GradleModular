package com.android.thread;

public class MyObject {
	
//     public void methodA(){   
//	    synchronized (this){
//	    	 System.out.println("methodA");
//	    	  while(true){
//	  	    	
//	  	    }
//	    }
//	  
//    }
//    
//    public void methodB(){  
//	   synchronized(this){
//		   System.out.println("methodB");
//	   }
//   }
//    
    
	 synchronized public void methodA(){   	   
	    System.out.println("methodA,��Ҫִ��10���ӵ�ҵ���߼�...");
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	  
	    System.out.println("methodA,ִ����ϣ�");
   }
   
	 synchronized  public void methodB(){  	
		   System.out.println("methodB");
     }
}
