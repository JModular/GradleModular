package com.design.base;

/**
 * ����д�����ء�
 * ����������֮��Ķ�̬�ԣ��Ը���ĺ����������¶��塣
 * ����������ж���ĳ�������丸������ͬ�����ƺͲ�����
 * ����˵�÷�������д (Overriding)����Java�У�
 * ����ɼ̳и����еķ�����������Ҫ���±�д��ͬ�ķ�����
 * ����ʱ���ಢ����ԭ�ⲻ���ؼ̳и���ķ�������������
 * һ�����޸ģ������Ҫ���÷�������д��������д�ֳƷ������ǡ�
 * @author Arison
 *
 */
public class Subject extends SubjectBase {

	public void init() {
		System.out.println("Subject ����ִ�з���������ǿ����ʵ��");

	}
	
	public void onCreate(){
		onSubject();
		super.onCreate();
		
	}
	
	public void onSubject(){
		System.out.println("Subject ����ִ�з����� ������䲻ǿ��ʵ��");
	}

}
