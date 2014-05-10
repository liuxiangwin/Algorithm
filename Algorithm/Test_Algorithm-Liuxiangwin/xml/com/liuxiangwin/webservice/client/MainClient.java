package com.liuxiangwin.webservice.client;
import java.util.HashMap;
public class MainClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PlatfromServiceService platService=new PlatfromServiceService();
		IService iservice =platService.getPlatfromServicePort();
		System.out.println(iservice.search("Alan"));
		
		System.out.println(iservice.entry("Alan_Liu"));
	}

}
