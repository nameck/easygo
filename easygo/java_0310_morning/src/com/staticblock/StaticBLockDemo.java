package com.staticblock;
//当前代码的执行顺序：初始化先执行，或执行main主函数中的代码
//第一步：执行的应该是类加载中的连接步骤为类的静态Field分配内存，简单来说知道了存在如下的静态整型变量，a,c,b;
//第二步：执行的应该是类加载中的连接步骤，设置静态Field默认初始值，即a=0,c=0,b=0;
//第三步：执行的应该是类加载中的初始化步骤，a=5,c=0,b=6,b=9
public class StaticBLockDemo {
	static int a = 5;
	static int c;
	//静态初始化块
	static{
		b=6;
		System.out.println("---------");
	}
	public static void main(String[] args) {
		System.err.println(StaticBLockDemo.b);
	}
	static int b = 9;
}
