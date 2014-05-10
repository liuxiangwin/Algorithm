package com.liuxiangwin.webservice.xmlparser;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SlotMachine {
	private String id;
	private String site;
	private Date date;
	// @XmlElement
	private Count count;

	public SlotMachine(String id, String site, Date date) {
		this.id = id;
		this.site = site;
		this.date = date;
	}

	public SlotMachine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void meterCheck(String name, String... strings) {
		Meter meter = new Meter();
		meter.meterEntry(name);
	}

	// public void dropOperation(int ... params,int id)
	public void dropOperation(int id, int... params) {
		for (int value : params) {
			System.out.println(value);
		}
		byte condition=1;
		final byte caseCon=2;
		switch(condition)
		{
		case caseCon:
			System.out.println("This is good");
		}
	}

	public Count getCount() {
		return count;
	}

	public void setCount(Count count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

interface drop1{}
interface count1{}
interface softCount1 extends drop1,count1{}