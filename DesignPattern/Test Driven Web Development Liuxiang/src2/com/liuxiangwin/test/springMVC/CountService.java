package com.liuxiangwin.test.springMVC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CountService {

	private CountDAO _countDAO;

	public List GetDropDate() {
		List<Date> dropList = new ArrayList<Date>();
		_countDAO = new CountDAO();
		dropList = _countDAO.GetDropDate();
		return dropList;
	}

	public List<Double> GetSoftCountAmount() {
		List<Double> softAmountList = new ArrayList<Double>();
		_countDAO = new CountDAO();
		softAmountList = _countDAO.GetSoftCountAmount();
		return softAmountList;
	}

}
