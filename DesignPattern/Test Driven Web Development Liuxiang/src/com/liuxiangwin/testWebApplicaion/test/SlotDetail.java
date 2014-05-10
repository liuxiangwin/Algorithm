package com.liuxiangwin.testWebApplicaion.test;

import java.util.Date;

public class SlotDetail {
	
	private String _tranCode;
	
	private double _tranAmount;
	
	private Date _dropDate;

	public String get_tranCode() {
		return _tranCode;
	}

	public void set_tranCode(String tranCode) {
		_tranCode = tranCode;
	}

	public double get_tranAmount() {
		return _tranAmount;
	}

	public void set_tranAmount(double tranAmount) {
		_tranAmount = tranAmount;
	}

	public Date get_dropDate() {
		return _dropDate;
	}

	public void set_dropDate(Date dropDate) {
		_dropDate = dropDate;
	}

}
