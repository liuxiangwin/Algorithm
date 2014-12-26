package shortName;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 */

public class LongestValidParentheses {
	public int longestValidParentheses(String string) {
		int length = string.length();
		if (length == 0)
			return 0;
		int left = 0;
		Stack<Integer> indexs = new Stack<Integer>();
		boolean[] record = new boolean[length];
		for (int i = 0; i < length; i++) {
			if (string.charAt(i) == '(') {
				left++;
				indexs.push(i);
			} else if (left > 0) {
				int idx = indexs.pop();
				record[idx] = true;
				record[i] = true;
				left--;
			}
		}
		int ret = 0;
		int current = 0;
		for (int k = 0; k < length; k++) {
			if (record[k]) {
				current++;
			} else {
				ret = current > ret ? current : ret;
				current = 0;
			}
		}
		return ret > current ? ret : current;
	}

	public int longestValidParentheses2(String string) {
		int result ,lastleft;
		result =lastleft =0;
		if (string.length() < 2)
			return result;
		
		Stack<Integer> sta = new Stack<Integer>();		
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '(') {
				sta.push(i);
			} else {
				if (!sta.empty()) {
					sta.pop();
					if (!sta.empty())
						result = Math.max(result, i - sta.pop().intValue());
					else
						result = Math.max(result, i - lastleft + 1);

				} else {
					lastleft = i + 1;
				}
			}
		}
		return result;
	}
	public static void main(String args[])
	{
		LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
	    String input = ")()())";
		int result = longestValidParentheses.longestValidParentheses2(input);
		System.out.println(result);
	}

}