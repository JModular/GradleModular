package com.android.retrofit.rx;

/**
 * @author Arison
 * 回调接口
 * @param <T>
 */
public interface Result1Listener<T> extends ResultListener<T> {
	void onResponse(T t);
}
