package com.liuxiangwin.test.springMVC;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CountController extends MultiActionController {

	private CountService _countSerivce;

	@SuppressWarnings("unchecked")
	public ModelAndView queryDropDate(HttpServletRequest request,
			HttpServletResponse response) {

		_countSerivce = new CountService();

		// Get The Data from DataBase;
		List<Date> dropList = _countSerivce.GetDropDate();
		// Return the model to render or anything
		Map<String, List<Date>> model = new HashMap<String, List<Date>>();

		model.put("dropDateModel", dropList);

		return new ModelAndView("dropDateView", model);   

		
	}

	public ModelAndView querySoftCountAmount(HttpServletRequest request,
			HttpServletResponse response) {

		_countSerivce = new CountService();

		// Get The Data from DataBase;
		List<Double> softCountList = _countSerivce.GetSoftCountAmount();
		// Return the model to render or anything
		Map<String, List<Double>> model = new HashMap<String, List<Double>>();

		model.put("softCountModel", softCountList);
		
		
		return new ModelAndView("softCountAmountView",model);
	}

}
