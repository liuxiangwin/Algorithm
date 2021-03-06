package com.liuxiangwin.algor.leetcode.uniquepath;

import java.applet.Applet;
import java.util.Stack;

//[Example of a simple maze] At any given moment, the robot can only move 1 step in one of 4 directions. Valid moves are:

//Go North: (x,y) -> (x,y-1)
//Go East: (x,y) -> (x+1,y)
//Go South: (x,y) -> (x,y+1)
//Go West: (x,y) -> (x-1,y)




public class CreateMaze 
{
	
	public static void main(String[] args) {
        // 迷宫定义
        int[][] maze = {{1,1,1,1,1,1,1,1,1,1},
                        {1,0,1,1,1,0,1,1,1,1},
                        {1,1,0,1,0,1,1,1,1,1},
                        {1,0,1,0,0,0,0,0,1,1},
                        {1,0,1,1,1,0,1,1,1,1},
                        {1,1,0,0,1,1,0,0,0,1},
                        {1,0,1,1,0,0,1,1,0,1},
                        {1,1,1,1,1,1,1,1,1,1}};
        
        int[][] move = {{0,1},{1,1},
        				{1,0},{1,-1},
        				{0,-1},{-1,-1},
        				{-1,0},{-1,1}};
        Stack<Step> s = new Stack<Step>();
        Stack<Step> s1 = new Stack<Step>();
        int a = path(maze, move, s);
        while(!s.isEmpty()){
            Step step = s.pop();
            System.out.println(step.x+":"+step.y);
        }
    }
    public static int path(int[][] maze,int[][] move,Stack<Step> statck){
        Step step = new Step(1,1,-1); //起点
        statck.push(step);
        while(!statck.isEmpty()){
            step = statck.pop();
            int x = step.x;
            int y = step.y;
            int d = step.d+1;
            while(d<8){
                int i = x + move[d][0];
                int j = y + move[d][1];
                if(maze[i][j] == 0){    //该点可达
                    step = new Step(i,j,d); //到达新点
                    statck.push(step);
                    x = i;
                    y = j;
                    maze[x][y] = -1;  //到达新点，标志已经到达
                    if(x == 6 && y == 8){
                        return 1;  //到达出口，迷宫有路，返回1
                    }else{
                        d = 0;  //重新初始化方向
                    }
                }else{
                    d++; //改变方向
                }
            }
        }
        return 0;
    }
}
class Step{
    int x,y,d;
    public Step(int x,int y,int d) {
        this.x = x;//横坐标
        this.y = y;//纵坐标
        this.d = d;//方向
    }
}