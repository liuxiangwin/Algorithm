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
	/**
	��һ����prices[]��prices[i]�����Ʊ�ڵ�i����ۼۣ����ֻ��һ�ν���(һ�����������)�ܵõ���������档

	ֻ��Ҫ�ҳ����Ĳ�ֵ���ɣ��� max(prices[j] �C prices[i]) ��i < j��һ�α������ɣ�
	 �ڱ�����ʱ���ñ���low��¼ prices[o....i] �е���Сֵ�����ǵ�ǰΪֹ������ۼۣ�ʱ�临�Ӷ�Ϊ O(n)��
	 * @param stockPrice
	 * @return
	 */

	public int maxProfit_quesiton1(int[] stockPrice) {
	        // Start typing your C/C++ solution below
	        // DO NOT write int main() function 
	        if (stockPrice.length == 0) {
	            return 0;
	        }
	        int minPrice = stockPrice[0], maxProfit=0, curProfit;
	        for (int i = 1; i < stockPrice.length; i++) {
	        	
	        	if(stockPrice[i]<minPrice)
	        	{
	        		minPrice=stockPrice[i];
	        	}        		
	            curProfit=stockPrice[i]-minPrice;
	            if(curProfit>maxProfit)
	            {
	            	maxProfit=curProfit;
	            }           	
	        }
	        return maxProfit;
	    }
	
	/**
	 * ���������һ��Ĳ�֮ͬ�����ڲ����ƽ��״�����
	 * Ҳ��һ�α������ɣ�ֻҪ����׬��������
	 */
	public int maxProfit_question2(int[] prices) {
	      if(prices.length == 0) return 0;
	      int ans = 0;
	      for(int i=1; i<prices.length; i++){
	          if(prices[i] > prices[i-1]){
	        	  ans += prices[i]-prices[i-1];  
	          }            
	      }
	      return ans;
	 }

	/**
	 * III: You may complete at most two transactions, but you may not engage in multiple 
	 * transactions at the same time (ie, you must sell the stock before you buy again).
		���������Ҫ�����⣬��Ŀ˵��������������ʽ��ף�����˵����2������2�Σ�
		�������2��֮ǰ����������һ����ģ���һ��ʼ���븴���ˣ������������������ 
		��Ȼ����ڶ���֮ǰ����������һ����ģ���ôʵ��������ͱ��������Ҫ�ҵ�һ��i��
		ʹ��0��i�����Ǳʽ��׵����������i��n-1�����Ǳʽ��׵��������֮�����
		�����Ļ�ÿ������������������������I�о��Ѿ�����ˡ�����������Ҫ����Ч�����⣬
		�����и�����ĵط��ǲο���������(Link)�� �ҵ�һ��Ĵ����ر��ۣ���O(n^2)�ģ�
		���������ķ�����O(n)�� ������Ҫɨ���飺
		
		��һ���ǰ����ɨ���ó��ڵ�i��֮ǰ���е��Ǳʽ���һ����׬����
		�ڶ���Ӻ���ǰɨ��ע���i�쵽��n�������׬���٣����������Ǵӵ�n�쵹��ȥ����i������ܿ�����
		������ɨ֮ǰ���µ������飬�ó��������
	 * @param prices
	 * @return
	 */
	public int maxProfit_question3(int[] prices) {
		if (prices.length == 0)
			return 0;
		int ans = 0;
		

		// ���������opt[i]��ʾ prices[0...i]����һ�ν��׵��������.
		int opt[] = new int[prices.length];
		opt[0] = 0;
		int low = prices[0];
		int curAns = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < low)
				low = prices[i];
			else if (curAns < prices[i] - low)
				curAns = prices[i] - low;
			opt[i] = curAns;
		}

		// �������, opt[i]��ʾ prices[i...n-1]����һ�ν��׵��������.
		int optReverse[] = new int[prices.length];
		optReverse[prices.length - 1] = 0;
		curAns = 0;
		int high = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > high)
				high = prices[i];
			else if (curAns < high - prices[i])
				curAns = high - prices[i];
			optReverse[i] = curAns;
		}

		// �ٽ��л��֣��ֱ������������
		for (int i = 0; i < prices.length; i++) {
			int tmp = opt[i] + optReverse[i];
			if (ans < tmp)
				ans = tmp;
		}
		return ans;
	}
	
	
	
	public int maxProfit_question4(int[] prices) {
		if (prices.length == 0)
			return 0;
		int ans = 0;
		

		// ���������opt[i]��ʾ prices[0...i]����һ�ν��׵��������.
		int opt[] = new int[prices.length];
		opt[0] = 0;
		int low = prices[0];
		int curAns = 0;
		for (int i = 1; i < (prices.length/2)-1; i++) {
			if (prices[i] < low)
				low = prices[i];
			else if (curAns < prices[i] - low)
				curAns = prices[i] - low;
			opt[i] = curAns;
		}

		// �������, opt[i]��ʾ prices[i...n-1]����һ�ν��׵��������.
		int optReverse[] = new int[prices.length];
		optReverse[prices.length - 1] = 0;
		curAns = 0;
		int high = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= (prices.length/2)+1; i--) {
			if (prices[i] > high)
				high = prices[i];
			else if (curAns < high - prices[i])
				curAns = high - prices[i];
			optReverse[i] = curAns;
		}
		
		
		int mid[] = new int[prices.length];
		mid[0] = 0;
		int lowMid = prices[(prices.length/2)-1];
		int curAnsMid = 0;
		for (int i = (prices.length/2); i <=(prices.length/2)+1; i++) {
			if (prices[i] < lowMid)
				lowMid = prices[i];
			else if (curAnsMid < prices[i] - lowMid)
				curAnsMid = prices[i] - lowMid;
			mid[i] = curAnsMid;
		}

		//�ֱ�������ε����ֵ
		int optMax,midMax,revMax;
		optMax =midMax= revMax =0;
		for (int i = 0; i < prices.length-1; i++) {
			optMax = Math.max(optMax,Math.max(opt[i],opt[i+1])) ;
			midMax =  Math.max(midMax,Math.max(mid[i],mid[i+1]));
				
			revMax = Math.max(revMax,Math.max(optReverse[i],optReverse[i+1]));
		
		}

		ans = optMax+ midMax +revMax;
	
		return ans;
	}
	
	
	
	
	public static void main(String[] args) {
	
		BestTimeToBuyAndSellStock bsStock = new BestTimeToBuyAndSellStock();
		
		//int[] stockPrice= { 9, 2, 6, 7, 8};
		
		int[] stockPrice = {1,1,2,1,4,1,5,1,2};
		System.out.println(bsStock.maxProfit_quesiton1(stockPrice));
		
		System.out.println(bsStock.maxProfit_question2(stockPrice));
		
		System.out.println(bsStock.maxProfit_question3(stockPrice));
		
		System.out.println(bsStock.maxProfit_question4(stockPrice));
		
		int[] stockPrice2 = {1,3,2,6,2,7,5,1,2};
		
		System.out.println(bsStock.maxProfit_question4(stockPrice2));
		
	}
}
