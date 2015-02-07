package com.quiz.arrangement.service;

import com.quiz.arrangement.model.TaxRate;

import java.util.Set;


public interface TaxRateService {
	public Set<TaxRate> getTaxRates(String description);
}
