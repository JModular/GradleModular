package com.android.test;

import java.util.ArrayList;

public class JSONTest {

	public static void main(String[] args) {
		 ArrayList<Item> items = new ArrayList<Item>();  
	        // ����������ʾ��A,B,C,,,F�������ַ�����Ϊ����ı�ǩ��  
	        // ÿһ��װ��5�������ݡ�  
	        String[] groups = { "A", "B", "C", "D", "E", "F" };  
	        for (int i = 0; i < groups.length; i++) {  
	  
	            String s = groups[i];  
	  
	            Item group = new Item();  
	            group.type = Item.GROUP;  
	            group.text = s;  
	            items.add(group);  
	  
	            for (int j = 0; j < 5; j++) {  
	  
	                Item child = new Item();  
	                child.type = Item.CHILD;  
	                child.text = s + " ������:" + j;  
	                items.add(child);  
	            }  
	        }  

	}
	
	 // ���ڳ������ݿ���ࡣ  
    // �ֶη�Ϊ���ͣ�type����ֵ��text����  
	public static class Item {  
        public static final int GROUP = 0;  
        public static final int CHILD = 1;  
  
        public int type;  
        public String text;  
    }  
  

}
