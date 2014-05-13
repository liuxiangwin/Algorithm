package com.liuxiangwin.DesignPattern02.Decorator.test;

public class Picture implements IPicture {
    //This is the ConcreteComponent extends or means extend
	//then predefine interface.
	
	//This is the Component class implement IComponet interface
	
	
	public Picture() {
	}	

	public String showPicture() {
		return "This is a Painting";
	}
}
