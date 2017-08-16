package com.modular.rx.utils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * ��ʱ����
 * @author Arison 
 */
public class RxTimerUtil {

	private static Subscription mSubscription;
	
	private static long i=0;

	public interface IRxNext {
		void doNext(long number);
	}

	public static void main(String[] args) {
          timer(1, new IRxNext() {
			
			@Override
			public void doNext(long number) {
				i=number;
				if(i==1500){
					cancel();
				}
			  System.out.println("����ʼִ��........"+number);
				
			}
		});
          
          while(true){
          }
	}

	/**
	 * milliseconds�����ִ��next����
	 *
	 * @param milliseconds
	 * @param next
	 */
	@SuppressWarnings("deprecation")
	public static void timer(long milliseconds, final IRxNext next) {
       mSubscription=Observable.timer(milliseconds,milliseconds, TimeUnit.SECONDS)
    		   .subscribeOn(RxUtils.getNamedScheduler("�߳�1"))
    		   .subscribe(new Action1<Long>() {

				@Override
				public void call(Long t) {
					   if(next!=null){
                           next.doNext(t);
                       }
                       //ȡ������
                      // cancel();
					
				}
			});
	}

	
    /** ÿ��milliseconds�����ִ��next����
    *
    * @param milliseconds
    * @param next
    */
   public static void interval(long milliseconds,final IRxNext next){
       mSubscription=Observable.interval(milliseconds, TimeUnit.MILLISECONDS)
               .observeOn(RxUtils.getNamedScheduler("�߳�1"))
               .subscribe(new Action1<Long>() {
                   @Override
                   public void call(Long number) {
                       if(next!=null){
                           next.doNext(number);
                       }
                   }
               });
   }

	
	  /**
     * ȡ������
     */
    public static void cancel(){
        if(mSubscription!=null&&!mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
        }
    }
}
