package com.liuxiangwin.Algorithm.question.test;

import java.util.Stack;

public class TestStockPrice {

	private void maxProfit(int stockPrice[], int N) {
		int buyPrice = stockPrice[0];
		int sellPrice = -1;
		int profit = 0;
		for (int i = 1; i < N; i++) {
			int price = stockPrice[i];
			if (price - buyPrice > profit) {
				profit = price - buyPrice;
				sellPrice = price;
			}
			buyPrice = Math.min(buyPrice, price);
		}
	}

	// public int maximize(Integer[] stockPrice){
	// int maxProfit=0;
	//
	// Stack<Integer> stack = new Stack<Integer>();
	// stack.push(stockPrice[0]);
	// for(int i=1; i<stockPrice.length; i++){
	// if( (stockPrice[i] - stack.min()) > maxProfit ) {
	// maxProfit = stockPrice[i] - stack.min();
	// } // stack.min() will return the minimum element from 0 to i-1
	// stack.push(stockPrice[i]); }
	// return maxProfit; }}
	// }
	// }

}
