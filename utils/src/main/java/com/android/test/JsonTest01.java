package com.android.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.android.model.ContactsBean;

public class JsonTest01 {

	public static void main(String[] args) {
		 String hex="{\"contacts\":[{\"companyName\":\"深圳市优软科技有限公司\",\"name\":\"张三\",\"sex\":\"男\",\"age\":25,\"position\":\"财务经理\",\"department\":\"财务部\",\"brithday\":\"1992-08-17\",\"phone\":\"13266699268\",\"isDMakers\":1,\"notes\":\"特殊客户\"},{\"companyName\":\"深圳市优软科技有限公司\",\"name\":\"张三\",\"sex\":\"男\",\"age\":25,\"position\":\"财务经理\",\"department\":\"财务部\",\"brithday\":\"1992-08-17\",\"phone\":\"13266699268\",\"isDMakers\":1,\"notes\":\"特殊客户\"}]}";
	       
		  System.out.println("contacts:"+JSON.parseObject(hex).getJSONArray("contacts").toJSONString());
		  ArrayList<ContactsBean> datas= JSON.parseObject(JSON.parseObject(hex).getJSONArray("contacts").toJSONString()
	        ,new TypeReference<ArrayList<ContactsBean>>(){});
	        
	        System.out.println("datas:"+JSON.toJSONString(datas));
	        

	        //解析json字符串  
            List<ContactsBean> ContactsBean2 = JSON.parseArray(JSON.parseObject(hex).getJSONArray("contacts").toJSONString(),ContactsBean.class); 
	
            System.out.println("datas:"+JSON.toJSONString(ContactsBean2));
	}
	
	



}
