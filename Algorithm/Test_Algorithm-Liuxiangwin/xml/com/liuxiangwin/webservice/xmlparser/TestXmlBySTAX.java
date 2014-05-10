package com.liuxiangwin.webservice.xmlparser;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TestXmlBySTAX {

	private XMLStreamReader reader;

	private XMLEventReader eventReader;

	private XMLEventReader filterEventReader;

	private static final String xmlPath = "./com/liuxiangwin/webservice/xmlparser/Books.xml";

	@Before
	public void setUp() throws Exception {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream stream = TestXmlBySTAX.class.getClassLoader()
				.getResourceAsStream(xmlPath);
		reader = factory.createXMLStreamReader(stream);

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("------------Each test down-------------");
	}

	@Test
	public void testStaxByIndex() throws XMLStreamException {
		while (reader.hasNext()) {
			int type = reader.next();
			if (type == XMLStreamConstants.START_ELEMENT) {
				if (reader.getName().toString().equals("book")) {
					System.out.println(reader.getAttributeName(0) + ":"
							+ reader.getAttributeValue(0));
				}
				if (reader.getName().toString().equals("price")) {
					System.out.println(reader.getElementText());
				}

			} else if (type == XMLStreamConstants.CHARACTERS) {
				// System.out.println(reader.getText().trim());
			} else if (type == XMLStreamConstants.END_ELEMENT) {
				// System.out.println("/"+reader.getName());
			}

		}
	}

	@Test
	public void testStaxByEvent() throws XMLStreamException {
		createEventReader();
		int num = 0;
		while (eventReader.hasNext()) {
			// 基于迭代模型的操作方式
			// 通过XMLEvent来获取是否是某种节点类型
			XMLEvent event = eventReader.nextEvent();
			if (event.isStartElement()) {
				// 通过event.asxxx转换节点
				String name = event.asStartElement().getName().toString();
				if (name.equals("title")) {

					System.out.println(eventReader.getProperty("lang") + " "
							+ eventReader.getElementText() + ":");
				}

			}
			num++;
		}
		System.out.println("The iterator times is " + num);
	}

	@Test
	public void testStaxByFilerEvent() throws XMLStreamException {
		createEvenFiltertReader();
		int num = 0;
		while (filterEventReader.hasNext()) {
			XMLEvent event = filterEventReader.nextEvent();

			if (event.isStartElement()) {
				String name = event.asStartElement().getName().toString();
				if (name.equals("title")) {

					System.out
							.println(filterEventReader.getElementText() + ":");
				}

			}
			num++;
		}
		System.out.println("The iterator times is " + num);
	}

	@Test
	public void testStax_WriteXml() throws XMLStreamException {
		XMLOutputFactory factory = XMLOutputFactory.newInstance();

		XMLStreamWriter xsw = factory.createXMLStreamWriter(System.out);

		xsw.writeStartDocument("GBK", "1.0");
		xsw.writeEndDocument();
		String ns = "http://11:dd";
		xsw.writeStartElement("nsadfsadf", "person", ns);
		xsw.writeStartElement(ns, "id");
		xsw.writeCharacters("1");
		xsw.writeEndElement();
		xsw.writeEndElement();
		xsw.flush();
		xsw.close();

	}

	@Test
	public void testStax_ModifyXml() throws Exception {
		InputStream is = TestXmlBySTAX.class.getClassLoader()
				.getResourceAsStream(xmlPath);
		// 创建文档处理对象
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		// 通过DocumentBuilder创建doc的文档对象
		Document doc = docBuilder.parse(is);
		// 创建XPath
		XPath xpath = XPathFactory.newInstance().newXPath();
		Transformer tran = TransformerFactory.newInstance().newTransformer();
		tran.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tran.setOutputProperty(OutputKeys.INDENT, "yes");
		// 第一个参数就是xpath,第二参数就是文档
		NodeList list = (NodeList) xpath.evaluate(
				"//book[title='Learning XML']", doc, XPathConstants.NODESET);
		// 获取price节点
		
		Element element = (Element) (( (Element)list.item(0))
				.getElementsByTagName("price").item(0));
		element.setTextContent("2008");
		Result result = new StreamResult(System.out);
		// 通过tranformer修改节点
		tran.transform(new DOMSource(doc), result);

	}

	private void createEventReader() throws XMLStreamException {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream stream = null;

		stream = TestXmlBySTAX.class.getClassLoader().getResourceAsStream(
				xmlPath);
		eventReader = factory.createXMLEventReader(stream);
	}

	private void createEvenFiltertReader() throws XMLStreamException {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream stream = null;

		stream = TestXmlBySTAX.class.getClassLoader().getResourceAsStream(
				xmlPath);
		filterEventReader = factory.createFilteredReader(
				factory.createXMLEventReader(stream), new EventFilter() {
					@Override
					public boolean accept(XMLEvent event) {
						// 返回true表示会显示，返回false表示不显示
						if (event.isStartElement()) {
							String name = event.asStartElement().getName()
									.toString();
							if (name.equals("title") || name.equals("price"))
								return true;
						}
						return false;
					}
				});
	}

}
