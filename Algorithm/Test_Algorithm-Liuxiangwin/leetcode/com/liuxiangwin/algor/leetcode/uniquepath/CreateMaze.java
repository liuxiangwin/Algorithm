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
        // �Թ�����
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
        Step step = new Step(1,1,-1); //���
        statck.push(step);
        while(!statck.isEmpty()){
            step = statck.pop();
            int x = step.x;
            int y = step.y;
            int d = step.d+1;
            while(d<8){
                int i = x + move[d][0];
                int j = y + move[d][1];
                if(maze[i][j] == 0){    //�õ�ɴ�
                    step = new Step(i,j,d); //�����µ�
                    statck.push(step);
                    x = i;
                    y = j;
                    maze[x][y] = -1;  //�����µ㣬��־�Ѿ�����
                    if(x == 6 && y == 8){
                        return 1;  //������ڣ��Թ���·������1
                    }else{
                        d = 0;  //���³�ʼ������
                    }
                }else{
                    d++; //�ı䷽��
                }
            }
        }
        return 0;
    }
}
class Step{
    int x,y,d;
    public Step(int x,int y,int d) {
        this.x = x;//������
        this.y = y;//������
        this.d = d;//����
    }
}