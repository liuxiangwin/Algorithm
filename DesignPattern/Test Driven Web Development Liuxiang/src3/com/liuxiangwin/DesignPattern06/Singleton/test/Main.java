package com.liuxiangwin.DesignPattern06.Singleton.test;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase database=DataBase.getInstance("product");
		System.out.println("This is the "+database.get_dataBaseName()+
				"database");
		
		DataBase database2=DataBase.getInstance("employee");
		System.out.println("This is the "+database2.get_dataBaseName()+
		"database");
		
		DataBase database3=DataBase.getInstance("Manager");
		System.out.println("This is the "+database3.get_dataBaseName()+
		"database");
	}

}
