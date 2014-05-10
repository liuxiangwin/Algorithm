package com.liuxiangwin.DesignPattern03.Factory.test;

public class MySQLConnection implements Connection {
	public MySQLConnection()
	{
		System.out.println("This is the MySQL Connection");
	}
	public Connection createDbConnection() {
		// TODO Auto-generated method stub
		return new MySQLConnection();
	}

}
