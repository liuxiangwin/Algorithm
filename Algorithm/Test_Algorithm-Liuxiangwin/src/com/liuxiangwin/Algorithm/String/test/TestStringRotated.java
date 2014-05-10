package com.liuxiangwin.Algorithm.String.test;

import java.util.Arrays;

public class TestStringRotated {

	public static void main(String[] args) {
		String string1 = "StackOverFlow";
		String string2 = "ackOverFlowSt";
		System.out.println("isRotation " + isRotation(string1, string2));
		
		System.out.println("hello shift to  lohel ::" + checkRotateNumber("hello","lohel"));
		
		
		System.out.println("hello shift to  elloh ::" + checkRotateNumber("hello","elloh"));

	}

	private static boolean isRotation(String s1, String s2) {
		/**
		 * indexOf(String str)
			����ָ������Ԫ���ڴ���Ԫ���е�һ�γ��F̎��������
			���s1=+s1 indexOf û�з���-1֤�����Ӵ�
		 */
		return (s1.length() == s2.length())
				&& 
				((s1 + s1).indexOf(s2) != -1);
	}

	
	private static  int checkRotateNumber(String src,String rotatedString) {
		int rotateNumber=0;
		String combine = rotatedString + rotatedString;

		for (int i = 0; i < combine.length(); i++) {
			int j=0;
			for ( j = 0; j < src.length(); j++) {

				if (combine.charAt(i + j) != src.charAt(j))
					break;
			}
            if(j==src.length())
            {
            	rotateNumber=i;
            	//return  rotateNumber;
            	return  src.length()-rotateNumber;
            }
		}
       return -1;
	}
	
	private boolean checkContainSubString(String combine,String toCheck)
	{
	  return combine.contains(toCheck);
	}
}
