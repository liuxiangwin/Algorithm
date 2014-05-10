package com.liuxiangwin.testWebApplicaion.test;

import java.sql.Time;
import java.util.Date;

public class SlotDetailMeter {

	private Date _dropDate;

	private double _softCount;

	private double _harCount;

	private String _dropType;

	private boolean _softCountFlag;

	private boolean _hardCountFlag;

	public double get_softCount() {
		return _softCount;
	}

	public void set_softCount(double softCount) {
		_softCount = softCount;
	}

	public double get_harCount() {
		return _harCount;
	}

	public void set_harCount(double harCount) {
		_harCount = harCount;
	}

	public Date get_dropDate() {
		return _dropDate;
	}

	public void set_dropDate(Date dropDate) {
		_dropDate = dropDate;
	}

	public String get_dropType() {
		return _dropType;
	}

	public void set_dropType(String dropType) {
		_dropType = dropType;
	}

	public boolean is_softCountFlag() {
		return _softCountFlag;
	}

	public void set_softCountFlag(boolean softCountFlag) {
		_softCountFlag = softCountFlag;
	}

	public boolean is_hardCountFlag() {
		return _hardCountFlag;
	}

	public void set_hardCountFlag(boolean hardCountFlag) {
		_hardCountFlag = hardCountFlag;
	}

}
