package com.android.test;

import java.util.ArrayList;

public class JSONTest {

	public static void main(String[] args) {
		 ArrayList<Item> items = new ArrayList<Item>();  
	        // 假设我们演示以A,B,C,,,F这样的字符串作为分组的标签。  
	        // 每一组装载5个子数据。  
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
	                child.text = s + " 组数据:" + j;  
	                items.add(child);  
	            }  
	        }  

	}
	
	 // 用于承载数据块的类。  
    // 字段分为类型（type）和值（text）。  
	public static class Item {  
        public static final int GROUP = 0;  
        public static final int CHILD = 1;  
  
        public int type;  
        public String text;  
    }  
  

}
