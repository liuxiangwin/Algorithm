package com.liuxiangwin.jvm.knowledge;

public class TestClassLoaderAndBlock {

	/**
	 * @param args
	 */
	TestClassLoaderAndBlock()
	{
		System.out.println("Construtor  Block");
	}
	
	static{}
	{
		System.out.println("Static Block");
		
	}
	{
		System.out.println("Dynamic Block");
	}
	public static void main(String[] args)  throws Exception {
		//TestClassLoaderAndBlock test1=new TestClassLoaderAndBlock();
		//TestClassLoaderAndBlock test2= new TestClassLoaderAndBlock();
		new TestClassLoaderAndBlock();
		new TestClassLoaderAndBlock();
	}

}
