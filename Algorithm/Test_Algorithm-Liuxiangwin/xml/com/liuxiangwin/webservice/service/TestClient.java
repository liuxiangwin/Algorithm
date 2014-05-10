package com.liuxiangwin.webservice.service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

public class TestClient {
	
	
	public static void main(String args[]) throws MalformedURLException
	{
		URL url = new URL("http://localhost:7777/liuxiangwin?wsdl");
		QName qname = new QName("http://service.webservice.liuxiangwin.com/",
				"PlatfromServiceService");
		Service service = Service.create(url,qname);

		IService iService = service.getPort(IService.class);

		System.out.println(iService.search("liuxiangwin"));
	}
	//@Test
	public void testClient() {
		try {
			//URL url = new URL("http://localhost:8999/liuxiangwin?wsdl");
			URL url = new URL("http://localhost:7777/liuxiangwin?wsdl");
			QName qname = new QName("http://service.webservice.liuxiangwin.com/",
					"PlatfromServiceService");
			Service service = Service.create(url,qname);

			IService iService = service.getPort(IService.class);

			System.out.println(iService.search("liuxiangwin"));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
