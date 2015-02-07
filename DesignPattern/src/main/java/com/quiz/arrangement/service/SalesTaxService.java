package com.quiz.arrangement.service;

import com.quiz.arrangement.model.ShoppingCart;
import com.quiz.arrangement.model.ShoppingCartLineItem;


public interface SalesTaxService {
	 public double calculateSaleTax(ShoppingCartLineItem item) ;
	 public double calculateTotalTaxes(ShoppingCart shoppingCart);
	 public double calculateTotalCost(ShoppingCart shoppingCart);
}
