package com.liuxiangwin.algor.leetcode.uniquepath;

// Source:   http://oj.leetcode.com/problems/unique-paths/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19771225

// A robot is located at the top-left corner of a m x n grid.
// The robot can only move either down 
//or right at any point in time. 
// The robot is trying to reach the bottom-right corner of the grid.
// How many possible unique paths are there?
  
/**
 *         |   j-1  j     
	------------------------------------------------
          | 1   1   1   1   1  
  ------------------------------------------
     i-1  | 1   2   *
  ------------------------------------------
      i   | 1   *   (i,j)
  ------------------------------------------
          | 1   
  ------------------------------------------
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 *
 */

//������
//ʹ�ö�ά������ʵ�֡�����Ϊ���˵�һ�к͵�һ��ȫΪ1�⣬
//�������·����Ϊ����һ�����һ��ĺ͡�
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int j = 1; j < n; j++) {
			dp[0][j] = 1;
		}

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}

		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		UniquePaths slt = new UniquePaths();
		int uPath = slt.uniquePaths(3, 7);
		System.out.println(uPath);
	}
}