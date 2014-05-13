package com.liuxiangwin.DesignPattern02.Decorator.test;

public class ColorDecorator extends AbstractPictureDecorator {
	
	
	public ColorDecorator(IPicture pic)
	{
		this.ipicture=pic;
	}	


	public String showPicture() {
		// this ipcture maybe has been decortor by other 
		//class
		return this.ipicture.showPicture()+addColor();
	}
	
	private String addColor()
	{
		return "  Add Color Decorator";	
	}

}
