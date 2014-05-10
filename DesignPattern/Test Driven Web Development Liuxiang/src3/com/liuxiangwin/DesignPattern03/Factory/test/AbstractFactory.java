package com.liuxiangwin.DesignPattern03.Factory.test;

import com.liuxiangwin.DesignPattern03.Factory.test.FactoryWithMethod.DataBase;

public abstract class AbstractFactory {

	public AbstractFactory() {
		// TODO Auto-generated constructor stub
	}
    public abstract Connection createConnection(DataBase _dataBaseType);
}
