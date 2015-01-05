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
	/**
	给一个数prices[]，prices[i]代表股票在第i天的售价，求出只做一次交易(一次买入和卖出)能得到的最大收益。

	只需要找出最大的差值即可，即 max(prices[j] – prices[i]) ，i < j。一次遍历即可，
	 在遍历的时间用遍历low记录 prices[o....i] 中的最小值，就是当前为止的最低售价，时间复杂度为 O(n)。
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
	 * 此题和上面一题的不同之处在于不限制交易次数。
	 * 也是一次遍历即可，只要可以赚就做交易
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
		第三题必须要读清题，题目说是最多可以完成两笔交易，就是说买入2次卖出2次，
		并且买第2次之前必须卖掉第一次买的（我一开始还想复杂了，忽略了这个条件）。 
		既然买入第二次之前必须卖掉第一次买的，那么实际上问题就变成了我需要找到一个i，
		使得0到i天内那笔交易的最大收益与i到n-1天内那笔交易的最大收益之和最大。
		这样的话每个单独区间的最大收益在问题I中就已经解决了。接下来就需要考虑效率问题，
		这里有个神奇的地方是参考别人来的(Link)。 我第一遍的代码特别蛋疼，是O(n^2)的，
		而这个神奇的方法是O(n)。 这里需要扫三遍：
		
		第一遍从前往后扫，得出在第i天之前进行的那笔交易一共能赚多少
		第二遍从后往前扫，注意第i天到第n天最多能赚多少，反过来就是从第n天倒回去到第i天最多能亏多少
		第三遍扫之前存下的俩数组，得出最大利润
	 * @param prices
	 * @return
	 */
	public int maxProfit_question3(int[] prices) {
		if (prices.length == 0)
			return 0;
		int ans = 0;
		

		// 正向遍历，opt[i]表示 prices[0...i]内做一次交易的最大收益.
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

		// 逆向遍历, opt[i]表示 prices[i...n-1]内做一次交易的最大收益.
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

		// 再进行划分，分别计算两个部分
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
		

		// 正向遍历，opt[i]表示 prices[0...i]内做一次交易的最大收益.
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

		// 逆向遍历, opt[i]表示 prices[i...n-1]内做一次交易的最大收益.
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

		//分别计算三段的最大值
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
