package com.modular.rx.utils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * 定时器类
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
			  System.out.println("任务开始执行........"+number);
				
			}
		});
          
          while(true){
          }
	}

	/**
	 * milliseconds毫秒后执行next操作
	 *
	 * @param milliseconds
	 * @param next
	 */
	@SuppressWarnings("deprecation")
	public static void timer(long milliseconds, final IRxNext next) {
       mSubscription=Observable.timer(milliseconds,milliseconds, TimeUnit.SECONDS)
    		   .subscribeOn(RxUtils.getNamedScheduler("线程1"))
    		   .subscribe(new Action1<Long>() {

				@Override
				public void call(Long t) {
					   if(next!=null){
                           next.doNext(t);
                       }
                       //取消订阅
                      // cancel();
					
				}
			});
	}

	
    /** 每隔milliseconds毫秒后执行next操作
    *
    * @param milliseconds
    * @param next
    */
   public static void interval(long milliseconds,final IRxNext next){
       mSubscription=Observable.interval(milliseconds, TimeUnit.MILLISECONDS)
               .observeOn(RxUtils.getNamedScheduler("线程1"))
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
     * 取消订阅
     */
    public static void cancel(){
        if(mSubscription!=null&&!mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
        }
    }
}
