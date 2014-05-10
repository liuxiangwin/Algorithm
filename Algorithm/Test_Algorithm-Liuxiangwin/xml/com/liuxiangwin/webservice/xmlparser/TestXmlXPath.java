package com.liuxiangwin.webservice.xmlparser;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TestXmlXPath {

	private XPath xpath;

	private Document document;
	
	private static final String xmlPath="./com/liuxiangwin/webservice/xmlparser/Books.xml";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		InputStream is = TestXmlXPath.class.getClassLoader().getResourceAsStream(xmlPath);
		// 创建文档处理对象
		DocumentBuilder db = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		// 通过DocumentBuilder创建doc的文档对象
		document = db.parse(is);
		// 创建XPath
		xpath = XPathFactory.newInstance().newXPath();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testXpath() throws XPathExpressionException {

		// 第一个参数就是xpath,第二参数就是文档
		NodeList list = (NodeList) xpath.evaluate("//book[@category='WEB']",
				document, XPathConstants.NODESET);
		for (int i = 0; i < list.getLength(); i++) {
			// 遍历输出相应的结果
			Element e = (Element) list.item(i);
			System.out.println(e.getElementsByTagName("title").item(0)
					.getTextContent());
		}
	}
}
