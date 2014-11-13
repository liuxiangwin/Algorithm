package com.liuxiangwin.DesignPattern06.Singleton.test;

public class DataBase {	
	private static DataBase _instance;
	
	private String _dataBaseName;
	//private static DataBase _instance = new DataBase();

	private DataBase(String name) {
		this._dataBaseName = name;
	}

	public static synchronized DataBase getInstance(String name) {
		synchronized (_instance) {
			if (_instance == null) {
				_instance = new DataBase(name);
				return _instance;
			}
			return _instance;
		}

	}

	public String get_dataBaseName() {
		return _dataBaseName;
	}
}
