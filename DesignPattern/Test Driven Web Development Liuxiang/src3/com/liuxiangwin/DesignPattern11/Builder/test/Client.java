package com.liuxiangwin.DesignPattern11.Builder.test;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IHouseBuilder builder = new ChinaHouseBuilder();

		Diretor director = new Diretor(builder);
        //The build process is concreate
		director.constructHouse();

		House house = builder.getHouse();

		for (String property : house.get_propertyList()) {
			System.out.println(property);
		}

	}

}
