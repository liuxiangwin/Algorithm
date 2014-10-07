package com.liuxiangwin.jvm.knowledge;

public class TestByNewInstance {

	/**
  1.用new语句创建对象，这是最常见的创建对象的方法。

  2.运用反射手段,调用java.lang.Class或者
  java.lang.reflect.Constructor类的newInstance()实例方法。

  3.调用对象的clone()方法。

  4.运用反序列化手段，
      调用java.io.ObjectInputStream对象的 readObject()方法。
	 */
	
	public void  countMachine()
	{
		System.out.println("count Machine be invoked");
	}

}
