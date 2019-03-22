package com.android.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示多线程通讯方式 while()方式
 * 
 * @author Arison
 *
 */
public class MyList {

	// Java内存可见性
	// volatile
	volatile static private List<String> list = new ArrayList<String>();

	public static void add() {
		list.add("elements");
	}

	// 方法上添加关键字synchronized也能保证可见性
	// public synchronized int size() {
	// return list.size();
	// }

	public static int size() {
		return list.size();
	}
}
