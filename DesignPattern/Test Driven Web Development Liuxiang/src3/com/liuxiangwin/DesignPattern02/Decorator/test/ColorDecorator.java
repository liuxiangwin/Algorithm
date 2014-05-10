package com.liuxiangwin.DesignPattern02.Decorator.test;

public class ColorDecorator extends AbstractPictureDecorator {
	
	IPicture picture;
	
	public ColorDecorator(IPicture pic)
	{
	   this.picture=pic;
	   super.ipicture=pic;
	}
	
	
	@Override
	public String Description() {
		// TODO Auto-generated method stub
		return this.picture.Description()+"  Add Color Decorator";
	}

}
