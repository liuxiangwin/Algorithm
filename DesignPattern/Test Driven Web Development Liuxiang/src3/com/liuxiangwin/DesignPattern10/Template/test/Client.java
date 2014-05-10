package com.liuxiangwin.DesignPattern10.Template.test;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobootTemplate template=new AMDRoboot();
		template.robootManaufacture();
		template=new IntelRoboot();
		template.robootManaufacture();
	}

}
