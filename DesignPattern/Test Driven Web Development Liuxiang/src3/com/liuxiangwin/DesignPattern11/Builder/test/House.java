package com.liuxiangwin.DesignPattern11.Builder.test;

import java.util.ArrayList;

public class House {
	private String basement;

	private String structure;

	private String roof;

	private String interior;

	private ArrayList<String> _propertyList;

	public House() {
		_propertyList=new ArrayList<String>();

	}

	public void setBasement(String basement) {
		this.basement = basement;
		_propertyList.add(this.basement);
	}

	public void setStructure(String structure) {
		this.structure = structure;
		_propertyList.add(this.structure);
	}

	public void setRoof(String roof) {
		this.roof = roof;
		_propertyList.add(this.roof);
	}

	public void setInterior(String interior) {
		this.interior = interior;
		_propertyList.add(this.interior);
	}

	public String getBasement() {
		return basement;
	}

	public String getStructure() {
		return structure;
	}

	public String getRoof() {
		return roof;
	}

	public String getInterior() {
		return interior;
	}

	public ArrayList<String> get_propertyList() {
		return _propertyList;
	}

}
