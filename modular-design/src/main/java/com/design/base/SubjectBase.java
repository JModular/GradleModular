package com.design.base;

public abstract class SubjectBase {
	
	public abstract void init();
	
	public void onCreate(){
		onSubjectBase();
		init();
	}
	
	public void onSubjectBase(){
		System.out.println("SubjectBase  父类执行方法！");
	}

}
