package com.liuxiangwin.DesignPattern11.Builder.test;

public class Diretor {
	// Build up the sequence of the Builder object
	private IHouseBuilder _houseBuilder;

	public Diretor(IHouseBuilder houseBuilder) {
		this._houseBuilder = houseBuilder;
	}
	
	//The build process is concrete
	public void constructHouse() {
		this._houseBuilder.buildBasement();
		this._houseBuilder.buildInterior();
		this._houseBuilder.buildStructure();
		this._houseBuilder.bulidRoof();

	}
}
