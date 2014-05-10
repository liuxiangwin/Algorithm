package com.liuxiangwin.DesignPattern03.Factory.test;

import com.liuxiangwin.DesignPattern03.Factory.test.FactoryWithMethod.DataBase;

public class DatabaseFactory extends AbstractFactory {

	@Override
	public Connection createConnection(DataBase _dataBaseType) {
		// TODO Auto-generated method stub
		if (_dataBaseType.equals(DataBase.Mysql)) {
			return new MySQLConnection();
		} else if (_dataBaseType.equals(DataBase.Oracle)) {
			return new OracleConnection();
		}
		return null;
	}
	
	


}
