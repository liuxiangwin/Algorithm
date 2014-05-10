package com.liuxiangwin.DesignPattern11.Builder.test;

public interface IHouseBuilder {

	public void buildBasement();

	public void buildStructure();

	public void bulidRoof();

	public void buildInterior();

	public House getHouse();
	
	

}
