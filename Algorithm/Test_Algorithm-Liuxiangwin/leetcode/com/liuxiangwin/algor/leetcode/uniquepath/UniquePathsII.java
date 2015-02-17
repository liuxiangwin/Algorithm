package com.liuxiangwin.algor.leetcode.uniquepath;

// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/unique-paths-ii/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19931301

// Follow up for "Unique Paths":
// Now consider if some obstacles are added to the grids. 
// How many unique paths would there be?
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.
//  [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.
// Note: m and n will be at most 100.

public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{ 
		//在dp数组中1是通路，在obstacleGrid中0是阻塞
		int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];        

        //下面初始dp的时候需要根据obstacleGrid的值来确定
        dp[0][0] = (obstacleGrid[0][0] == 0 ? 1 : 0);

        //我们需要注意m x 1以及1 x n的初始化
        for(int i = 1; i < m; i++) {
            dp[i][0] = ((dp[i - 1][0] == 1 && obstacleGrid[i][0] == 0) ? 1 : 0);
        }

        for(int j = 1; j < n; j++) {
            dp[0][j] = ((dp[0][j - 1] == 1 && obstacleGrid[0][j] == 0) ? 1 : 0);
        }


        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];	
	}

	public static void main(String[] args) {
		int[][] obstacle = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		UniquePathsII slt = new UniquePathsII();
		int result = slt.uniquePathsWithObstacles(obstacle);
		System.out.println(result);
	}
}