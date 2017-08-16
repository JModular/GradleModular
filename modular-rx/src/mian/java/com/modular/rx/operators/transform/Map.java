package com.modular.rx.operators.transform;

import java.util.Collections;
import java.util.List;

import com.modular.rx.subscriber.ProxySubscriber;

import rx.Observable;
import rx.functions.Func1;

public class Map {
   
	public static void fromMap(){
		Observable.from(new String[]{"Lin Yin","Mir alis","Geng oris"})
		.map(new Func1<String, String>() {

			@Override
			public String call(String t) {
			
				return t.toUpperCase();
			}
		}).toList()
		.map(new Func1<List<String>, List<String>>() {

			@Override
			public List<String> call(List<String> t) {
				Collections.reverse(t);
				return t;
			}
		}).subscribe(new ProxySubscriber<List<String>>());
	}
}
