package com.liuxiangwin.Algorithm.question.test;

public class TestFindNoRepeatedNumber {
	public static void main(String a[]) {
		int[] ar = { 3, 4, 3, 4, 4, 3, 2, 4, 1, 9, 8 };
		int[] a1 = new int[100];
		int i, c = 1, j, f = 0, m = 0, k = 0;
		for (i = 0; i < 11; i++) {
			c = 1;
			for (j = i + 1; j < 11; j++) {
				for (k = 0; k < 11; k++) {
					if (ar[i] == ar[j] && ar[j] != a1[k]) {
						c++;
						k++;
					}
				}
				if (c != 1)
					a1[k] = ar[i];
				System.out.println("the c is" + c);
				System.out.println("the no is" + a1[k]);
				if (c == 1)
					f++;
				if (f == 2)
					m = ar[i];
			}
			System.out.println("the 2nd no is" + m);
		}

	}
}
