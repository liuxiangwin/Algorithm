package com.liuxiangwin.algor.leetcode.stock;

public class BestTimeToBuyAndSellStock {
    // The alogithem is DP
	//Say you have an array for which the ith element is the price of
	//a given stock on day i.
	//	If you were only permitted to complete at most one transaction 
	//(ie, buy one and sell one share of the stock), design an algorithm
	//to find the maximum profit.


	//记录之前的股票最低值，判断今日的股票值-之前的最低值是否大于最大的利润。
	//更新最低值。
	public int maxProfit(int[] prices) {
	        // Start typing your C/C++ solution below
	        // DO NOT write int main() function 
	        if (prices.length == 0) {
	            return 0;
	        }
	        int min = prices[0], profit = 0;
	        for (int i = 1; i < prices.length; i++) {
	            profit = prices[i] - min > profit ?
	            	prices[i] - min : profit;
	            min = prices[i] < min ? prices[i] : min;
	        }
	        return profit;
	    }
	
	/**
	 * 如果当前值高于买入值，那么就卖出，同时买入今天的股票。
		如果当前值低于买入值，那么就放弃之前的股票，同时买入今天的股票。
		举例：
		1 3 9 7 8
		第1天，买入1；
		第2天，3>1，卖出，获利2，并买入3；
		第3天，9>3，卖出，获利6，并买入9；
		第4天，7<9，放弃9，买入7；
		第5天，8>7，卖出，获利1，结束。
		总获利：2+6+1 = 9。
	 * 
	 * 
	 */
	
	public int maxProfit2(int[] prices) {
	        // Start typing your C/C++ solution below
	        // DO NOT write int main() function        
	        int profit = 0, value = 0;        
	        if (prices.length == 0) {
	            return profit;
	        }
	        value = prices[0];
	        for (int i = 1; i < prices.length; i++) {
	            if (prices[i] < value) {
	                value = prices[i];
	            }
	            else {
	                profit += prices[i] - value;    
	                value = prices[i];
	            }            
	        } 
	        return profit;
	    }
	
	public	 int maxProfit3(int[] prices) {
	        // Start typing your C/C++ solution below
	        // DO NOT write int main() function
	        int profit = 0, n = prices.length;
	        if (n == 0) {
	            return 0;
	        }
	        int l[n], r[n];
	        memset(l, 0, sizeof(int) * n);
	        memset(r, 0, sizeof(int) * n);
	        int min = prices[0];
	        for (int i = 1; i < n; i++) {
	            l[i] = prices[i] - min > l[i - 1] ? prices[i] - min : l[i - 1];        
	            min = prices[i] < min ? prices[i] : min;
	        }
	        int max = prices[n - 1];
	        for (int i = n - 2; i >= 0; i--) {
	            r[i] = max - prices[i] > r[i + 1] ? max - prices[i] : r[i + 1];
	            max = prices[i] > max ? prices[i] : max;
	        }
	        for (int i = 0; i < n; i++) {
	            profit = l[i] + r[i] > profit ? l[i] + r[i] : profit;
	        }
	        return profit;      
	    }
}
