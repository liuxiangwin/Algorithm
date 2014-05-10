package com.Alogrithm.javabasic.test;

public class TestBlock {

	static
	{
		new TestBlock();
		System.out.println("TestBlock static block");
	}
	{
		//new TestBlock();
		System.out.println("TestBlock dynamic block");
	}
	TestBlock()
	{
		System.out.println("TestBlock construtor block");
	}
	public static void main(String[] args) {
        new C_();
        System.out.println("=====");
        new C_();
        System.out.println("=====");
        new TestBlock();
        System.out.println("=====");
        new TestBlock();
	}

}


class A_{
	
	static
	{
		System.out.println("A_ static block");
	}
	{
		System.out.println("A_ dynamic block");
	}
	A_()
	{
		System.out.println("A_ construtor block");
	}
	
}

class B_ extends A_{
	
	static
	{
		System.out.println("B_ static block");
	}
	{
		System.out.println("B_ dynamic block");
	}
	B_()
	{
		System.out.println("B_ construtor block");
	}
	
}

class C_ extends B_{
	static
	{
		System.out.println("C_ static block");
	}
	{
		System.out.println("C_ dynamic block");
	}
	C_()
	{
		System.out.println("C_ construtor block");
	}
	
}