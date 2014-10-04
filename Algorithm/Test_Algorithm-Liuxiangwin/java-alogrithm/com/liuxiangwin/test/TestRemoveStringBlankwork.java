package com.liuxiangwin.test;

import java.util.HashMap;
import java.util.Iterator;

public class TestRemoveStringBlankwork {
	
	/**
	 * 
\w = Anything that is a word character

\W = Anything that isn't a word character (including punctuation etc)

\s = Anything that is a space character (including space, tab characters etc)

\S = Anything that isn't a space character (including both letters and numbers, as well as punctuation etc)
	 * @param args
	 */

	public static void main(String[] args) {
       String testString =" Adobe RD ";
       System.out.println(testString.replaceAll("\\s", ""));
       System.out.println(testString.replaceAll("\\s", "¿Õ¸ñ")); 
	}
}
