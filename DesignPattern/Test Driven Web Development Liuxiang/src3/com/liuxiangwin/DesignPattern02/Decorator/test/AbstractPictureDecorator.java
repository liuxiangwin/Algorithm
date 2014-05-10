package com.liuxiangwin.DesignPattern02.Decorator.test;

public abstract class AbstractPictureDecorator implements IPicture{
	//wrapped component
	IPicture ipicture;
	
	public void operation(){}
	
	
	public abstract String Description();

}
