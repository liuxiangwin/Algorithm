package com.liuxiangwin.algor.leetcode.matrix;

import java.util.ArrayList;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.'. 
 * You may assume that there will be only one unique solution.
 * @author liuxiangwin
 *
 *判断目前数独是否合法，需要满足3个条件：
1）每行中只含有数字1..9，且只出现一次；
2）每列中只含有数字1..9，且只出现一次；
3）每个3*3小格只含有数字1..9，且只出现一次。

只需要用一个set<int>存储现有数字，并判断是否有重复即可
 *
 *
 */
public class ValidSudoku {
	//http://www.cnblogs.com/zhaolizhen/p/Sudoku.html
	public boolean isValidSudoku_simple(char[][] board){
        boolean [][] rows=new boolean[9][9];
        boolean [][] cols=new boolean[9][9];
        boolean [][] blocks=new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                rows[i][j]=false;
                cols[i][j]=false;
                blocks[i][j]=false;
            }
        }
        for (int i = 0; i < 9; ++i) {  
            for (int j = 0; j < 9; ++j) {
                int c = board[i][j] - '1';
                if (board[i][j] == '.') continue;  
                if (rows[i][c] || cols[j][c] || blocks[i - i % 3 + j / 3][c])  
                    return false;  
                rows[i][c] = cols[j][c] = blocks[i - i % 3 + j / 3][c] = true;  
            }  
        }  
        return true;  
    }
	
	
	
	
	   //http://rleetcode.blogspot.com/2014/02/valid-sudoku-java.html
	  public boolean isValidSudoku(char[][] board) {
	        if (board==null|| board.length!=9 || board[0].length!=9){
	            return false;
	        }
	        
	       // initialize the Checkers
	       ArrayList<boolean[]> rowChecker=new ArrayList<boolean[]>();
	       ArrayList<boolean[]> colChecker=new ArrayList<boolean[]>();
	       ArrayList<boolean[]> blockChecker=new ArrayList<boolean[]>();
	       
	       for (int i=0; i<9; i++){
	           rowChecker.add(new boolean[9]);
	           colChecker.add(new boolean[9]);
	           blockChecker.add(new boolean[9]);
	           
	       }
	       
	       
	       for (int i=0; i<9; i++){
	           for (int j=0; j<9; j++){
	               if (board[i][j]=='.'){
	                   continue;
	               }
	              // current value, there should be a positin represented of c at each checkers
	              // pay attention to the indice of block checker
	              
	              int c= board[i][j]-'1' ;
	              if (rowChecker.get(j)[c]==true || colChecker.get(i)[c]==true || blockChecker.get(i/3*3+j/3)[c]==true){
	                  return false;
	              }
	              else{
	                  
	                  rowChecker.get(j)[c]=true;
	                  colChecker.get(i)[c]=true;
	                  blockChecker.get(i/3*3+j/3)[c]=true;
	              }
	               
	           }
	       }
	       
	       return true;
	        
	    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
