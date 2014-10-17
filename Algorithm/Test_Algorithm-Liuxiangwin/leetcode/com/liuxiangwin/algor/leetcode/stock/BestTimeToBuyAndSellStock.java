package com.liuxiangwin.algor.leetcode.stock;

public class BestTimeToBuyAndSellStock {
    // The alogithem is DP
	//Say you have an array for which the ith element is the price of
	//a given stock on day i.
	//	If you were only permitted to complete at most one transaction 
	//(ie, buy one and sell one share of the stock), design an algorithm
	//to find the maximum profit.


	//��¼֮ǰ�Ĺ�Ʊ���ֵ���жϽ��յĹ�Ʊֵ-֮ǰ�����ֵ�Ƿ������������
	//�������ֵ��
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
	 * �����ǰֵ��������ֵ����ô��������ͬʱ�������Ĺ�Ʊ��
		�����ǰֵ��������ֵ����ô�ͷ���֮ǰ�Ĺ�Ʊ��ͬʱ�������Ĺ�Ʊ��
		������
		1 3 9 7 8
		��1�죬����1��
		��2�죬3>1������������2��������3��
		��3�죬9>3������������6��������9��
		��4�죬7<9������9������7��
		��5�죬8>7������������1��������
		�ܻ�����2+6+1 = 9��
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
