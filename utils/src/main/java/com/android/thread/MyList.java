package com.android.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ʾ���߳�ͨѶ��ʽ while()��ʽ
 * 
 * @author Arison
 *
 */
public class MyList {

	// Java�ڴ�ɼ���
	// volatile
	volatile static private List<String> list = new ArrayList<String>();

	public static void add() {
		list.add("elements");
	}

	// ��������ӹؼ���synchronizedҲ�ܱ�֤�ɼ���
	// public synchronized int size() {
	// return list.size();
	// }

	public static int size() {
		return list.size();
	}
}
