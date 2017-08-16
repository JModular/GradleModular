package com.modular.rx;

public class RxMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		 String phong ="181 3050 6086";
		
		 System.out.println(phong.replace(" ", "").replace("-", ""));
		 boolean f=true&&true;
		 System.err.println("true&&true="+f);
		 f=true&&false;
		 System.err.println("true&&false="+f);
		 f=false&&false;
		 System.err.println("false&&false="+f);
		 
		 f=false||false;
		 System.err.println("false||false="+f);
		 f=true||false;
		 System.err.println("true||false="+f);
		 f=true||true;
		 System.err.println("true||true="+f);
	
	}

}
