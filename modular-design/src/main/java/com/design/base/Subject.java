package com.design.base;

/**
 * 【重写与重载】
 * 父类与子类之间的多态性，对父类的函数进行重新定义。
 * 如果在子类中定义某方法与其父类有相同的名称和参数，
 * 我们说该方法被重写 (Overriding)。在Java中，
 * 子类可继承父类中的方法，而不需要重新编写相同的方法。
 * 但有时子类并不想原封不动地继承父类的方法，而是想作
 * 一定的修改，这就需要采用方法的重写。方法重写又称方法覆盖。
 * @author Arison
 *
 */
public class Subject extends SubjectBase {

	public void init() {
		System.out.println("Subject 子类执行方法！父类强制其实现");

	}
	
	public void onCreate(){
		onSubject();
		super.onCreate();
		
	}
	
	public void onSubject(){
		System.out.println("Subject 子类执行方法！ 父类对其不强制实现");
	}

}
