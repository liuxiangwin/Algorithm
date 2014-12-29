package com.liuxiangwin.algor.leetcode.stackuse;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
		String operators = "+-*/";
		Stack<String> s = new Stack<String>();

		for (String str : tokens) {
			if (operators.contains(str)) {
				int num2 = Integer.valueOf(s.pop());
				int num1 = Integer.valueOf(s.pop());

				int index = operators.indexOf(str);
				switch (index) {
				case 0:
					s.push(String.valueOf(num1 + num2));
					break;
				case 1:
					s.push(String.valueOf(num1 - num2));
					break;
				case 2:
					s.push(String.valueOf(num1 * num2));
					break;
				case 3:
					s.push(String.valueOf(num1 / num2));
					break;
				}
			} else {
				s.push(str);
			}
		}

		return Integer.valueOf(s.pop());
    }
    
    public static void main(String args[])
    {
    	EvaluateReversePolishNotation  evalRPN = new EvaluateReversePolishNotation();
    	//((2 + 1) * 3) -> 9
    	String[] tokens = {"2", "1", "+", "3", "*"};
    	System.out.println(evalRPN.evalRPN(tokens));
    	
    }
}