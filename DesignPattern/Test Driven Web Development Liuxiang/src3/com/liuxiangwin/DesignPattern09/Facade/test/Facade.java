package com.liuxiangwin.DesignPattern09.Facade.test;

public class Facade {
   private static SubsystemA subSystemA=new SubsystemA();
   private static SubsystemB subSystemB=new SubsystemB();
   private static SubsystemC subSystemC=new SubsystemC();
	
	public static void operation1()
	{
		subSystemA.A1();
		subSystemB.A2();
		subSystemC.A3();
	}
	
	

	public static void operation2()
	{
		subSystemA.AtoA();
		subSystemC.A3();
		
	}
	
	public static void main(String[] args) {
		Facade.operation1();
		Facade.operation2();
	}

}
