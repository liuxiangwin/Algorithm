package com.liuxiangwin.webservice.service;

import javax.xml.ws.Endpoint;

public class PublicServer {

	public static void main(String args[]) {
		String address = "http://localhost:8999/liuxiangwin";

		Object implement = new PlatfromService();

		Endpoint.publish(address, implement);
	}

}
