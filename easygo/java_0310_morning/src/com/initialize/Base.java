package com.initialize;

public class Base {
	String name = "base";
	static int a = 1;
	static int b;
	static{
		System.out.println("初始化父类中的类成员变量b");
		b=2;
	}
	public Base(){
		System.out.println("父类的构造方法调用show方法");
		this.show();
	}
	public void show(){
		System.out.println("父类的show方法");
		System.out.println(b);
	}
}
