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
 * �������ǻ��ÿ��С����һ���ǹ���Ȼ������ң� �����i��С���ĵȼ��ȵ�i - 1��С���ߣ� ��ô��i��С�����ǹ��������ǵ�i -
 * 1��С���ǹ������ڼ�һ�� �����Ǵ��ҵ��������i��С���ĵȼ����ڵ�i + 1��С���ģ� ͬʱ��i��С����ʱ���ǹ�����С�ڵ�i + 1��С����
 * ��ô��i��С�����ǹ��������ǵ�i + 1��С�����ǹ�������һ��
 * 
 * http://www.cnblogs.com/double-win/p/3857371.html ��Ŀ����˼��
 * ��N�������ų�һ�ţ�����ÿ�����ӷ���һ��ratingֵ���������¹���������Ƿ����ǹ���
 * 
 * ��1�� ÿ�����ӱ��������һ���ǹ���
 * 
 * ��2�����ڵĺ��Ӽ䣬���и�ratingֵ�ĺ���Ҫ���һ���ǹ���
 * 
 * 
 * 
 * ������Ŀ����˼�����Ǹ���һ�����У�
 * 
 * (1)��������
 * 
 * ����1 5 7 9
 * 
 * ���������׵õ�������ǹ�������Ϊ��1,2,3,4
 * 
 * (2)�ݼ�����
 * 
 * ����8 6 4 2
 * 
 * ����Ҳ�����׵õ�������ǹ�������Ϊ��4,3,2,1
 * 
 * (3)����������
 * 
 * ����1 3 5 7 6 4
 * 
 * ���������������У� 1,3,5,7 �Լ�7,6,4
 * 
 * ������Ӧ�����ǹ����У�1,2,3,4 �Լ�3,2,1
 * 
 * �����ڴ˹�����7,�����������ж������ˣ������������Ҫ����4���ǣ����ұ���Ҫ����3���ǣ���ô�����յ���������Ҫ������һ�ˡ�������ķ�������Ϊ��
 * 
 * ����1,2,3,4,2,1 sum= 1+2+3+4+2+1 = 13
 * 
 * ����7 5 4 3 9 10
 * 
 * ���������������У� 7,5,4,3 �Լ�3,9,10
 * 
 * �������䰴�������з��ǣ� 4,3,2,1 �Լ�1,2,3
 * 
 * ����Ĭ����С��ֵ�������ٵ��ǣ�1�š�������ķ�������Ϊ��
 * 
 * ����4,3,2,1,2,3 sum = 4+3+2+1+2+3 = 15
 * 
 * ��4���ನ��
 * 
 * ����1 2 3 9 8 7 5 2 4 6 5 3 4
 * 
 * �����������򣬵��ǿ��Էֳɶ�������͵ݼ�����
 * 
 * �����������У� ��������1 2 3 9 _ _ _ 2 4 6 _ 3 4
 * 
 * �����ݼ����У� ��������_ _ _ 9 8 7 5 2 _ 6 5 3 _
 * 
 * ���������з��䣺������1 2 3 4 _ _ _ 1 2 3 _ 1 2
 * 
 * ���������з��䣺������_ _ _ 5 4 3 2 1 _ 3 2 1 _
 * 
 * �������յķ�����:�� 1 2 3 5 4 3 2 1 2 3 2 1 2��
 * 
 * 
 * 
 * �����������������Կ����ǹ��ķ�����Էֳ��������н��з��䣬һ���Ƿ������У���һ�����ǷǼ�����
 * 
 * �ֱ����������� up �Լ�down���ֱ��¼�Ǽ����кͷ�������
 * 
 * ��1����ͷ��β����һ�Σ��ҳ���������up
 * 
 * ����array up initial with all element equals to 1
 * 
 * ����for i from ratings.begin to ratings.end
 * 
 * ����do
 * 
 * ��������if ratings[i] > ratings [i-1] then
 * 
 * ������������up[i] <- up[i-1] +1
 * 
 * ��������end if
 * 
 * ��2����β��ͷ����һ�Σ��ҳ��ݼ�����down
 * 
 * ����array down initial with all element equals to 1
 * 
 * ����for i from ratings.rbegin to ratings.rend
 * 
 * ����do
 * 
 * ��������if ratings[i] > ratings [i+1] then
 * 
 * ������������up[i] <- up[i+1] +1
 * 
 * ��������end if
 * 
 * (3) �Ƚ�up ��down ��Ӧλ�ã�ѡ��ϴ��ֵ��Ϊ���ս��
 * 
 * ����sum <- 0
 * 
 * ����for i from ratings.begin to ratings.end
 * 
 * ����do
 * 
 * ��������sum <- sum + max{up[i], down[i]}
 * 
 * ����end for
 * 
 * ����return sum
 *
 */
public class Candy {
//���������������У� 1,3,5,7 �Լ�7,6,4
	//* ������Ӧ�����ǹ����У�1,2,3,4 �Լ�3,2,1
	//���ڴ˹�����7,�����������ж������ˣ������������Ҫ����4���ǣ����ұ���Ҫ����3���ǣ�
	//��ô�����յ���������Ҫ������һ�ˡ�������ķ�������Ϊ��
	//��1,2,3,4,2,1 sum= 1+2+3+4+2+1 = 13
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