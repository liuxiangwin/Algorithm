package com.liuxiangwin.DesignPattern02.Decorator.test;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   IPicture picture=new Picture();
	   picture= new PhotoDecorator(picture);
	   System.out.println(picture.Description());
	   picture=new ColorDecorator(picture);
	   System.out.println(picture.Description());
	   picture=new PeopleDecorator(picture);
	   System.out.println(picture.Description());
	   
	   System.out.println("=================================");
	   System.out.println("========We could Decorator in another way======");
	   
	   //IPicture picture=new 
	}

}
