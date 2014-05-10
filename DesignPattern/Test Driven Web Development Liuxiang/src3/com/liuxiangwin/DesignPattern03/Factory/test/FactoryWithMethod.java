package com.liuxiangwin.DesignPattern03.Factory.test;

public class FactoryWithMethod {

	// public FactoryWithConstructor.DataBase getDatabaseType()
	// {
	// return FactoryWithConstructor.DataBase;
	// }


	public enum DataBase {
		Mysql, Oracle, MSSQl, DB2

	}

	public FactoryWithMethod() {
		
	}

	public Connection createConnection(DataBase _dataBaseType) {
		if (_dataBaseType.equals(DataBase.Mysql)) {
			return new MySQLConnection();
		} else if (_dataBaseType.equals(DataBase.Oracle)) {
			return new OracleConnection();
		}
		return null;
	}

	public static void main(String args[]) {
		FactoryWithMethod factory=	new FactoryWithMethod();
		factory.createConnection(DataBase.Mysql);
	}
}
