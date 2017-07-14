package com.android.utils.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.android.model.DataState;
import com.android.utils.JDateUtils;


public class TestMain {

	public static void main(String[] args) {
	   List<DataState> datas=new ArrayList<DataState>();
		
	   datas=	JDateUtils.timeAddMuilt("2017-07-13 01:00", "2017-07-13 23:45", 15);
	   System.out.println( JSON.toJSONString(datas));
	   
//	   datas=	JDateUtils.timeAddMuilt("01:30", "23:45");
//	   System.out.println( JSON.toJSONString(datas));
	  
	   System.out.println(JDateUtils.isToday("2017-07-12 23:59", "yyyy-MM-dd HH:mm"));;
	
	   
	  // System.out.println(JDateUtils.daysToNewYear());
	   
	}

}
