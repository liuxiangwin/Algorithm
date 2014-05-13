package com.liuxiangwin.DesignPattern02.Decorator.test;

public abstract class AbstractPictureDecorator implements IPicture {
	// wrapped component the interfaca variable declare protected
	// And the interface serized could pass int by the construtor
	protected IPicture ipicture;
	
	// public abstract String Description();

	public String Description(){
		return this.ipicture.showPicture();
	}

}
