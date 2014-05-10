package com.liuxiangwin.DesignPattern02.Decorator.test;

public class PhotoDecorator extends AbstractPictureDecorator {
	IPicture picture;
	
	public PhotoDecorator(IPicture pic)
	{
	   this.picture=pic;	
	}
	
	
	@Override
	public String Description() {
		// TODO Auto-generated method stub
		return this.picture.Description()+"  Add Photo Decorator";
	}

}
