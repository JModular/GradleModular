package com.modular.rx;

import java.util.concurrent.TimeUnit;


import rx.Observable;
import rx.functions.Action1;

public class RxMain {

	public static void main(String[] args) {
	
	}
	
	/**
	 * —”≥Ÿ»ŒŒÒ
	 */
	private static void test0() {
		Observable.timer(4, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
			@Override
			public void call(Long aLong) {
				System.out.println("—”≥Ÿ4√Î÷¥––°£°£°£°£°£°£°£");
			}
		});
	}

	
	private static void test1() {
		String phong = "181 3050 6086";
		System.out.println(phong.replace(" ", "").replace("-", ""));
		
		boolean f = true && true;
		System.err.println("true&&true=" + f);
		f = true && false;
		System.err.println("true&&false=" + f);
		f = false && false;
		System.err.println("false&&false=" + f);

		f = false || false;
		System.err.println("false||false=" + f);
		f = true || false;
		System.err.println("true||false=" + f);
		f = true || true;
		System.err.println("true||true=" + f);
	}


}
