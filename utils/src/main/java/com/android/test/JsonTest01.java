package com.android.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.android.model.ContactsBean;

public class JsonTest01 {

	public static void main(String[] args) {
		 String hex="{\"contacts\":[{\"companyName\":\"����������Ƽ����޹�˾\",\"name\":\"����\",\"sex\":\"��\",\"age\":25,\"position\":\"������\",\"department\":\"����\",\"brithday\":\"1992-08-17\",\"phone\":\"13266699268\",\"isDMakers\":1,\"notes\":\"����ͻ�\"},{\"companyName\":\"����������Ƽ����޹�˾\",\"name\":\"����\",\"sex\":\"��\",\"age\":25,\"position\":\"������\",\"department\":\"����\",\"brithday\":\"1992-08-17\",\"phone\":\"13266699268\",\"isDMakers\":1,\"notes\":\"����ͻ�\"}]}";
	       
		  System.out.println("contacts:"+JSON.parseObject(hex).getJSONArray("contacts").toJSONString());
		  ArrayList<ContactsBean> datas= JSON.parseObject(JSON.parseObject(hex).getJSONArray("contacts").toJSONString()
	        ,new TypeReference<ArrayList<ContactsBean>>(){});
	        
	        System.out.println("datas:"+JSON.toJSONString(datas));
	        

	        //����json�ַ���  
            List<ContactsBean> ContactsBean2 = JSON.parseArray(JSON.parseObject(hex).getJSONArray("contacts").toJSONString(),ContactsBean.class); 
	
            System.out.println("datas:"+JSON.toJSONString(ContactsBean2));
	}
	
	



}
