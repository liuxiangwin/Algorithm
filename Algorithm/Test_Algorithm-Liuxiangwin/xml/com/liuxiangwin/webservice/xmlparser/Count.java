package com.liuxiangwin.webservice.xmlparser;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Count {
	
	public Count(String countId, String meterInfo) {
		this.countId = countId;
		this.meterInfo = meterInfo;
	}
	public Count() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String countId;

	private String meterInfo;



	public String getCountId() {
		return countId;
	}

	public void setCountId(String countId) {
		this.countId = countId;
	}

	public String getMeterInfo() {
		return meterInfo;
	}

	public void setMeterInfo(String meterInfo) {
		this.meterInfo = meterInfo;
	}

}
