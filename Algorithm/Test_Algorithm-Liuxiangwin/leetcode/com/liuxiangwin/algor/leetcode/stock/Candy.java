package com.liuxiangwin.algor.leetcode.stock;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value. You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 */
/**
 * 首先我们会给每个小朋友一颗糖果，然后从左到右， 假设第i个小孩的等级比第i - 1个小孩高， 那么第i的小孩的糖果数量就是第i -
 * 1个小孩糖果数量在加一。 再我们从右到左，如果第i个小孩的等级大于第i + 1个小孩的， 同时第i个小孩此时的糖果数量小于第i + 1的小孩，
 * 那么第i个小孩的糖果数量就是第i + 1个小孩的糖果数量加一。
 * 
 * http://www.cnblogs.com/double-win/p/3857371.html 题目的意思是
 * 有N个孩子排成一排，并给每个孩子分配一个rating值。按照如下规则给孩子们分配糖果：
 * 
 * （1） 每个孩子必须分至少一个糖果。
 * 
 * （2）相邻的孩子间，具有高rating值的孩子要多得一个糖果。
 * 
 * 
 * 
 * 按照题目的意思，我们给定一个序列：
 * 
 * (1)递增序列
 * 
 * 　　1 5 7 9
 * 
 * 　　很容易得到分配的糖果数依次为：1,2,3,4
 * 
 * (2)递减序列
 * 
 * 　　8 6 4 2
 * 
 * 　　也很容易得到分配的糖果数依次为：4,3,2,1
 * 
 * (3)单波形序列
 * 
 * 　　1 3 5 7 6 4
 * 
 * 　　有两个子序列： 1,3,5,7 以及7,6,4
 * 
 * 　　对应分配糖果序列：1,2,3,4 以及3,2,1
 * 
 * 　　在此过程中7,在两个序列中都出现了，但是在左边需要分配4颗糖，在右边则要分配3颗糖，那么在最终的序列中需要分配多的一端。因此最后的分配序列为：
 * 
 * 　　1,2,3,4,2,1 sum= 1+2+3+4+2+1 = 13
 * 
 * 　　7 5 4 3 9 10
 * 
 * 　　有两个子序列： 7,5,4,3 以及3,9,10
 * 
 * 　　分配按照子序列发糖： 4,3,2,1 以及1,2,3
 * 
 * 　　默认最小的值分配最少的糖，1颗。因此最后的分配序列为：
 * 
 * 　　4,3,2,1,2,3 sum = 4+3+2+1+2+3 = 15
 * 
 * （4）多波形
 * 
 * 　　1 2 3 9 8 7 5 2 4 6 5 3 4
 * 
 * 　　看似无序，但是可以分成多个递增和递减序列
 * 
 * 　　递增序列： 　　　　1 2 3 9 _ _ _ 2 4 6 _ 3 4
 * 
 * 　　递减序列： 　　　　_ _ _ 9 8 7 5 2 _ 6 5 3 _
 * 
 * 　　增序列分配：　　　1 2 3 4 _ _ _ 1 2 3 _ 1 2
 * 
 * 　　减序列分配：　　　_ _ _ 5 4 3 2 1 _ 3 2 1 _
 * 
 * 　　最终的分配结果:　 1 2 3 5 4 3 2 1 2 3 2 1 2　
 * 
 * 
 * 
 * 经过上述分析，可以看出糖果的分配可以分成两种序列进行分配，一种是非增序列，另一中则是非减序列
 * 
 * 分别定义两个序列 up 以及down，分别记录非减序列和非增序列
 * 
 * （1）从头至尾遍历一次，找出递增序列up
 * 
 * 　　array up initial with all element equals to 1
 * 
 * 　　for i from ratings.begin to ratings.end
 * 
 * 　　do
 * 
 * 　　　　if ratings[i] > ratings [i-1] then
 * 
 * 　　　　　　up[i] <- up[i-1] +1
 * 
 * 　　　　end if
 * 
 * （2）从尾向头遍历一次，找出递减序列down
 * 
 * 　　array down initial with all element equals to 1
 * 
 * 　　for i from ratings.rbegin to ratings.rend
 * 
 * 　　do
 * 
 * 　　　　if ratings[i] > ratings [i+1] then
 * 
 * 　　　　　　up[i] <- up[i+1] +1
 * 
 * 　　　　end if
 * 
 * (3) 比较up 和down 相应位置，选择较大的值作为最终结果
 * 
 * 　　sum <- 0
 * 
 * 　　for i from ratings.begin to ratings.end
 * 
 * 　　do
 * 
 * 　　　　sum <- sum + max{up[i], down[i]}
 * 
 * 　　end for
 * 
 * 　　return sum
 *
 */
public class Candy {
//　　有两个子序列： 1,3,5,7 以及7,6,4
	//* 　　对应分配糖果序列：1,2,3,4 以及3,2,1
	//　在此过程中7,在两个序列中都出现了，但是在左边需要分配4颗糖，在右边则要分配3颗糖，
	//那么在最终的序列中需要分配多的一端。因此最后的分配序列为：
	//　1,2,3,4,2,1 sum= 1+2+3+4+2+1 = 13
	public int candy(int[] ratings) {
		if (ratings.length == 0)
			return 0;
		int[] candies = new int[ratings.length];
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				candies[i] = candies[i - 1] + 1;
			//candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : 1;
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
		}
		int ret = ratings.length;
		for (int i : candies) {
			ret += i;
		}
		return ret;
	}

	
	public int candy2(int[] ratings) {
		int[] candy = new int[ratings.length];
		candy[0] = 1;
		// Find the up
		for (int i = 1; i < ratings.length; i++) {
			candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
		}
		int totalCandy = candy[ratings.length - 1];
		// Find the down
		for (int i = ratings.length - 2; i >= 0; i--) {
			candy[i] = (ratings[i] > ratings[i + 1] 
					   && candy[i + 1] + 1 > candy[i]) 
					   ? candy[i + 1] + 1	: candy[i];
			totalCandy += candy[i];
		}
		return totalCandy;
	}

	public static void main(String args[]) {
		int piority[] = { 1, 2, 3, 9, 8, 7, 5, 2, 4, 6, 5, 3, 4 };
		System.out.println(new Candy().candy(piority));

		int piority2[] = { 1, 2, 3, 9, 8, 7, 5, 2, 4, 6, 5, 3, 4 };
		System.out.println(new Candy().candy2(piority2));

	}
}