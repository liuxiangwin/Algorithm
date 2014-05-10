package com.liuxiangwin.DesignPattern03.Factory.test;

public class OracleConnection implements Connection {
	public OracleConnection()
	{
		System.out.println("This is the Oracle Connection");
	}
	public Connection createDbConnection() {
		// TODO Auto-generated method stub
		return new OracleConnection();
	}

}
