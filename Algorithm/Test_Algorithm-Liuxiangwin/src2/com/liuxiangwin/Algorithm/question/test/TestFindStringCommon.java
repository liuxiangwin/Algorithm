package com.liuxiangwin.Algorithm.question.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestFindStringCommon {

	public static void main(String[] args) {
		String[] A = { "apple", "banana", "mango", "potato", "apple", "potato" };
		String[] B = { "apple", "brinjal", "mango", "Raadish", "onion",
				"banana", "apple" };
		String[] C = getIntersection(A, B);
		for (String s : C)
			System.out.println(s);
		
		System.out.println(Thread.currentThread().getName());
	}

	public static String[] getIntersection(String[] A, String[] B) {
		int len= A.length > B.length ? A.length : B.length; // get the upper bound
															// of length
		
		//The two if keep the i not  index out of the length
		
		Map<Mark, Integer> map = new HashMap<Mark, Integer>();
		for (int i = 0; i < len; i++) {
			if (i < A.length) {
				if (map.containsKey(new Mark(A[i], 1))) // if map has entry with
														// same string from B
														// add one to it
					map.put(new Mark(A[i], 1), (map.get(new Mark(A[i], 1)) + 1));
				else if (!map.containsKey(new Mark(A[i], 0))) // else add the
																// string as A's
																// entry
					map.put(new Mark(A[i], 0), 1);
			}
			if (i < B.length) {
				if (map.containsKey(new Mark(B[i], 0))) // if map has entry with
														// same string from A
														// add one to it
					map.put(new Mark(B[i], 0), (map.get(new Mark(B[i], 0)) + 1));
				else if (!map.containsKey(new Mark(B[i], 1))) // else add the
																// string as A's
																// entry
					map.put(new Mark(B[i], 1), 1);
			}
		}
		ArrayList<String> arr = new ArrayList<String>();
		for (Mark m : map.keySet()) {
			if (map.get(m) > 1)
				arr.add(m.s); // add in arraylist as we are not sure how much
								// strings are there, creating bigger array may
								// be a bad idea
		}
		String[] strarr = new String[arr.size()];
		arr.toArray(strarr);
		return strarr;
	}

}

// class Mark used as key in map, No fancy error checking, no optimization done
// for hashcode.
class Mark {
	String s;
	int flag;

	Mark(String s1, int b) {
		s = s1;
		flag = b; // Here flag=1 represents String B arrays entry and flag=0
					// represents String A arrays entry
	}

	public boolean equals(Object o) {
		Mark m = (Mark) o;
		return (this.s).equals(m.s) && this.flag == m.flag;
	}

	public int hashCode() {
		return 5;
	}
}
