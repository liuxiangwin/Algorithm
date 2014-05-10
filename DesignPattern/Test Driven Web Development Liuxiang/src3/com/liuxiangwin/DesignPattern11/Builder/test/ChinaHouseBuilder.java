package com.liuxiangwin.DesignPattern11.Builder.test;

public class ChinaHouseBuilder implements IHouseBuilder {
	private House _house;

	// The Product and entity should construct in the builder class
	public ChinaHouseBuilder() {
		this._house = new House();
	}

	public void buildBasement() {
		_house.setBasement("Wooden Poles");

	}

	public void buildInterior() {
		_house.setInterior("Fire Wood");

	}

	public void buildStructure() {
		_house.setStructure("Wood and Ice");

	}

	public void bulidRoof() {
		_house.setRoof("Wood, caribou and seal skins");

	}

	public House getHouse() {

		return this._house;
	}

}
