package com.modular.rx.utils;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {

	@SuppressWarnings("unchecked")
	public static <T> List<T> getList(Class<T> mClass){
		 RxUtils.threadInfo("getList 运行的线程：");
		List<T> mlist=new ArrayList<T>();
		for(int i=0;i<100;i++){
			if (mClass.getName() instanceof String) {
				mlist.add((T)(i+""));
			}else{
				mlist.add((T)(Integer.valueOf(i)));
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return mlist;
	}
}
