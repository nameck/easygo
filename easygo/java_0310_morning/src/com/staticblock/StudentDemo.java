package com.staticblock;
//第一步：
//第二步：赋初值， a=0;b=0;
//第三步：初始化中的步骤
public class StudentDemo {
	String name;
	int age;
	static int a = 1;
	static int b;
	//静态初始化块
	static{
		b=2;
	}
	//初始化块，会执行，执行的时机是构造方法中调用父类构造器之后
	{
		age = 3;
	}
	public StudentDemo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public static void main(String[] args) {
		StudentDemo s = new StudentDemo("张三", 20);
	}
}
