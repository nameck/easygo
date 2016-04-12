package com.initialize;

public class Sub extends Base{
	static int b;
	static{
		System.out.println("初始化子类中的类成员变量b");
	}
	public Sub(){
		System.out.println("子类的构造方法调用show方法");
		show();
	}
	public void show(){
		System.out.println("子类的show方法");
		System.out.println(b);
	}
}
