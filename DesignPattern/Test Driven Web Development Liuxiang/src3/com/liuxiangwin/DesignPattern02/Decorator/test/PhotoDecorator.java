package com.liuxiangwin.DesignPattern02.Decorator.test;

public class PhotoDecorator extends AbstractPictureDecorator {
	
	public PhotoDecorator(IPicture pic)
	{
	   this.ipicture=pic;	
	}	
	
	public String showPicture() {
		// this ipcture maybe has been decortor by other 
		//class
		return this.ipicture.showPicture()+addPhoto();
	}
	
	private String addPhoto()
	{
		return " Add Photo Decorator";	
	}

}
