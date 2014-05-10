package com.liuxiangwin.webservice.service;

import java.util.HashMap;

import javax.jws.WebService;
import javax.xml.ws.WebServiceProvider;

@WebService(endpointInterface = "com.liuxiangwin.webservice.service.IService")
public class PlatfromService implements IService {

	@Override
	public String search(String searhCondition) {
		String result = "The query by " + searhCondition + " result is";

		return result;

	}

	@Override
	public String entry(String name) {
		String response = name + " entry success";
		return response;
	}

	@Override
	public Meter adjustment(String machineId) {
		Meter meter = new Meter();

		meter.setMachineId(machineId);
		if (machineId.equals("beijing")) {
			meter.setMeterName("SoftCount");
		} else {
			meter.setMeterName("HardCount");
		}
		meter.setMeterName("slotMachine_Meters");

		return meter;
	}

}
