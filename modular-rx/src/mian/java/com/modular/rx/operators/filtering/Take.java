package com.modular.rx.operators.filtering;

import rx.Observable;
import rx.Subscriber;

public class Take {

	public static void main(String[] args) {
		take();

	}

	public static void take() {
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
		.take(4)
		.subscribe(new Subscriber<Integer>() {
			@Override
			public void onNext(Integer item) {
				System.out.println("Next: " + item);
			}

			@Override
			public void onError(Throwable error) {
				System.err.println("Error: " + error.getMessage());
			}

			@Override
			public void onCompleted() {
				System.out.println("Sequence complete.");
			}
		});
		
		
	}
}
