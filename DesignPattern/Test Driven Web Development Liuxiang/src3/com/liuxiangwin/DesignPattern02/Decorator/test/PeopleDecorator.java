package com.liuxiangwin.DesignPattern02.Decorator.test;

public class PeopleDecorator extends AbstractPictureDecorator {

	public PeopleDecorator(IPicture pic) {
		this.ipicture = pic;
	}	

	
	public String showPicture() {
		// this ipcture maybe has been decortor by other 
		//class
		return this.ipicture.showPicture()+addPeople();
	}
	
	private String addPeople()
	{
		return "  Add People Decorator it";	
	}

}
