package com.liuxiangwin.webservice.service;

import java.util.Date;

public class Meter {
	
	public String getMachineId() {
		return machineId;
	}


	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}


	public String getMeterName() {
		return meterName;
	}


	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}


	public Date getAdjustTime() {
		return adjustTime;
	}


	public void setAdjustTime(Date adjustTime) {
		this.adjustTime = adjustTime;
	}


	private  String machineId;
	
	private String meterName;
	
	
	private  Date adjustTime;

}
