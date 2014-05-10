package com.liuxiangwin.DesignPattern12.Iterator.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Count {

	private double _softCount;
	private double _hardCount;
	private int _slotId;
	private Date _dropDate;

	public Count(int slotId, Date dropDate) {
		this._slotId = slotId;
		this._dropDate = dropDate;
		// TODO Auto-generated constructor stub
	}

	public double get_softCount() {
		return _softCount;
	}

	public void set_softCount(double softCount) {
		_softCount = softCount;
	}

	public double get_hardCount() {
		return _hardCount;
	}

	public void set_hardCount(double hardCount) {
		_hardCount = hardCount;
	}

	public int get_slotId() {
		return _slotId;
	}

	public void set_slotId(int slotId) {
		_slotId = slotId;
	}

	public Date get_dropDate() {
		return _dropDate;
	}

	public void set_dropDate(Date dropDate) {
		_dropDate = dropDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The Count is " + this._dropDate + this._slotId
				+ " and Count is " + this._softCount + this._hardCount;
	}



}
