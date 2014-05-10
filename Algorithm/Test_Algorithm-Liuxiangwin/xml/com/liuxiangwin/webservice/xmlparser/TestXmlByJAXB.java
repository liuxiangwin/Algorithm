package com.liuxiangwin.webservice.xmlparser;

import java.io.StringReader;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class TestXmlByJAXB {

	@Test
	public void testJavaToXml_Marshaller() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(SlotMachine.class);
		Marshaller marshaller = context.createMarshaller();

		SlotMachine slotMachine = new SlotMachine("Beijing", "CRDC", new Date(
				2012));
		Count count = new Count("countId", "softCount");

		slotMachine.setCount(count);

		marshaller.marshal(slotMachine, System.out);

	}
	
	@Test
	public void testXmlToJava_UnMarshaller() throws JAXBException {
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><slotMachine><count><countId>countId</countId><meterInfo>softCount</meterInfo></count><date>1970-01-01T08:00:02.012+08:00</date><id>Beijing</id><site>CRDC</site></slotMachine>";
		JAXBContext context = JAXBContext.newInstance(SlotMachine.class);
		Unmarshaller unMarshaller = context.createUnmarshaller();

		SlotMachine slotMachine = (SlotMachine)unMarshaller.unmarshal(new StringReader(xml));
		
		System.out.println("The id is :"+slotMachine.getId());
		System.out.println("The site is :"+slotMachine.getSite());
		System.out.println("The count id is : "+slotMachine.getCount().getCountId());
		System.out.println("The Meter info is : "+slotMachine.getCount().getMeterInfo());
		

	}
}
