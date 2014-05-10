package com.liuxiangwin.DesignPattern03.Factory.test;

public class FactoryWithConstructor {

	// public FactoryWithConstructor.DataBase getDatabaseType()
	// {
	// return FactoryWithConstructor.DataBase;
	// }
	private DataBase _dataBaseType;

	public enum DataBase {
		Mysql, Oracle, MSSQl, DB2

	}

	public FactoryWithConstructor(DataBase type) {
		_dataBaseType = type;

	}

	public Connection createConnection() {
		if (_dataBaseType.equals(DataBase.Mysql)) {
			return new MySQLConnection();
		} else if (_dataBaseType.equals(DataBase.Oracle)) {
			return new OracleConnection();
		}
		return null;
	}

	public static void main(String args[]) {
		FactoryWithConstructor factory=	new FactoryWithConstructor(DataBase.Mysql);
		factory.createConnection();
	}
}
