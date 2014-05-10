package com.Alogrithm.Microsoft.Inteview.test;

import java.util.HashMap;
import java.util.Map;

public class TestStringSimilarRecursive {

	/** */
	/**
	 * @param args
	 */
	
	public static final Map<String, String> DISTANCE_CACHE = new HashMap<String, String>();
	public static void main(String[] args) {
		float i = TestStringSimilarRecursive.similarity("jackbllog", "jackblog");
		System.out.println(i);
	}
	private static int caculateStringDistance(char[] firstStr, int firstBegin,
			int firstEnd, char[] secondStr, int secondBegin, int secondEnd) {
		String key = makeKey(firstStr, firstBegin, secondStr, secondBegin);
		if (DISTANCE_CACHE.get(key) != null) {
			return Integer.parseInt(DISTANCE_CACHE.get(key));
		} else {
			if (firstBegin >= firstEnd) {
				if (secondBegin >= secondEnd) {
					return 0;
				} else {
					return secondEnd - secondBegin + 1;
				}
			}
			if (secondBegin >= secondEnd) {
				if (firstBegin >= firstEnd) {
					return 0;
				} else {
					return firstEnd - firstBegin + 1;
				}
			}
			if (firstStr[firstBegin] == secondStr[secondBegin]) {
				return caculateStringDistance(firstStr, firstBegin + 1,
						firstEnd, secondStr, secondBegin + 1, secondEnd);
			} else {
				int oneValue = caculateStringDistance(firstStr, firstBegin + 1,
						firstEnd, secondStr, secondBegin + 2, secondEnd);
				int twoValue = caculateStringDistance(firstStr, firstBegin + 2,
						firstEnd, secondStr, secondBegin + 1, secondEnd);
				int threeValue = caculateStringDistance(firstStr,
						firstBegin + 2, firstEnd, secondStr, secondBegin + 2,
						secondEnd);
				DISTANCE_CACHE
						.put(key, String.valueOf(min(oneValue, twoValue,
								threeValue) + 1));
				return min(oneValue, twoValue, threeValue) + 1;
			}
		}
	}

	public static float similarity(String stringOne, String stringTwo) {
	/*	return 1f / (caculateStringDistance(stringOne.getBytes(), 0,
				stringOne.getBytes().length - 1, stringTwo.getBytes(), 0,
				stringOne.getBytes().length - 1) + 1);*/
	   return (caculateStringDistance(stringOne.toCharArray(), 0,
				stringOne.getBytes().length - 1, stringTwo.toCharArray(), 0,
				stringOne.getBytes().length - 1));
	}

	private static int min(int oneValue, int twoValue, int threeValue) {
		return oneValue > twoValue ? twoValue
				: oneValue > threeValue ? threeValue : oneValue;
	}

	private static String makeKey(char[] firstStr, int firstBegin,
			char[] secondStr, int secondBegin) {
		StringBuffer sb = new StringBuffer();
		return sb.append(firstStr).append(firstBegin).append(secondStr)
				.append(secondBegin).toString();
	}


}
