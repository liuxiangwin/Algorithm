package com.liuxiangwin.DesignPattern02.Decorator.test;

public class PeopleDecorator extends AbstractPictureDecorator {

	IPicture picture;

	public PeopleDecorator(IPicture pic) {
		this.picture = pic;
	}

	@Override
	public String Description() {
		// TODO Auto-generated method stub
		return this.picture.Description() + "  Add People Decorator it";
	}

}
