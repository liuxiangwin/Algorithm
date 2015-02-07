package com.quiz.arrangement.service.impl;

import com.quiz.arrangement.model.PurchaseReport;
import com.quiz.arrangement.model.ShoppingCart;
import com.quiz.arrangement.service.ReportService;
import com.quiz.arrangement.service.SalesTaxService;
import com.quiz.arrangement.service.ShoppingCartService;
import com.quiz.arrangement.util.NumberUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
	Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);
	@Autowired
	ShoppingCartService shoppingCartService;

	@Autowired
	SalesTaxService salesTaxService;

	public PurchaseReport generatePurchaseReport() {
		PurchaseReport report = new PurchaseReport();
		ShoppingCart shoppingCart = shoppingCartService.getShoppingCart();


		double salesTax = salesTaxService.calculateTotalTaxes(shoppingCart);
		double total = salesTaxService.calculateTotalCost(shoppingCart);

		logger.debug("Shopping cart cantains %s items", shoppingCart.getLineItems().size());
		logger.debug("Sales Tax :"+salesTax);
		logger.debug("Total :"+total);

		report.setLineItems(shoppingCart.getLineItems());
		report.setSalesTax(NumberUtils.toBigDecimal(salesTax));
		report.setTotal(NumberUtils.toBigDecimal(total));

		return report;
	}
}
