package com.liuxiangwin.webservice.service;

import java.util.HashMap;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface IService {
	@WebResult(name = "searchResult")
	public String search(@WebParam(name = "seCondition") String searhCondition);

	public String entry(String name);

	@WebResult(name = "adjustResult")
	public Meter adjustment(@WebParam(name = "machineId") String machineId);

}
