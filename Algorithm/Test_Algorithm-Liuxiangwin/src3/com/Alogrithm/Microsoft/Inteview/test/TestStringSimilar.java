package com.Alogrithm.Microsoft.Inteview.test;



public class TestStringSimilar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String stringA = "abdd";
		String stringB = "aebdd";
		System.out.println(calculateStringDistance(stringA, stringB, 0,
				stringA.length() - 1, 0, stringB.length() - 1));

		String stringC = "AlaLi";
		String stringD = "AlanLiu";
		System.out.println(calculateStringDistance(stringC, stringD, 0,
				stringC.length() - 1, 0, stringD.length() - 1));
		
		String stringE ="jackbllog";//"jacklovvedyou";
		String stringF ="jackblog";//"jacklodveyou";
		System.out.println("jacklovvedyou and jacklodveyou similar is "
				+calculateStringDistance(stringE, stringF, 0,
				stringE.length() - 1, 0, stringF.length() - 1));
	}
	
	


	private static int calculateStringDistance(
			String stringA, String stringB,
			int aBegin, int aEnd, int bBegin, int bEnd) {
		char strA[] = stringA.toCharArray();
		char strB[] = stringB.toCharArray();
		if (aBegin > aEnd) {
			if (bBegin > bEnd)
				return 0;
			else
				return bEnd - bBegin + 1;
		}

		if (bBegin > bEnd) {
			if (aBegin > aEnd)
				return 0;
			else
				return aEnd - aBegin + 1;

		}

		if (strA[aBegin] == strB[bBegin]) {
			return calculateStringDistance(String.valueOf(strA),
					String.valueOf(strB), aBegin + 1, aEnd, bBegin + 1,
					bEnd);
		} else {
			int t1 = calculateStringDistance(String.valueOf(strA),
					String.valueOf(strB), aBegin, aEnd, bBegin + 1, bEnd);
			int t2 = calculateStringDistance(String.valueOf(strA),
					String.valueOf(strB), aBegin + 1, aEnd, bBegin, bEnd);
			int t3 = calculateStringDistance(String.valueOf(strA),
					String.valueOf(strB), aBegin + 1, aEnd, bBegin + 1,
					bEnd);
			return Math.min(t1, Math.min(t2, t3)) + 1;
		}
	}


	
	

}
