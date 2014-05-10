package com.liuxiangwin.test.Hibernate;

import java.util.Date;

public class SlotDetailMeter {
	private int slot_detail_meter_id;
	private double _softCount;

	private double _hardCount;

	private Date _dropDate;
	
	
	public SlotDetailMeter()
	{
		//Need  a default construtor
		
	}
	
	public SlotDetailMeter(double softCount,double hardCount,Date dropDate)
	{
		this._softCount=softCount;
		this._hardCount=hardCount;
		this._dropDate=dropDate;
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

	public Date get_dropDate() {
		return _dropDate;
	}

	public void set_dropDate(Date dropDate) {
		_dropDate = dropDate;
	}

	public int getSlot_detail_meter_id() {
		return slot_detail_meter_id;
	}

	public void setSlot_detail_meter_id(int slotDetailMeterId) {
		slot_detail_meter_id = slotDetailMeterId;
	}

	
}
