package com.liuxiangwin.test;

public class RemoveWhiteSpace {

	public static void removeSpace(char[] string) {
		int k=0;int index = 0;
		while(k < string.length){
			  if(string[k] == ' '){
			     if(string[index] != ' '){
			        string[index] = string[k];
			        index++;
			     }
			  } else { string[index] = string[k]; index++;}
			  k++;
			}
	}

	private static void swap(char[] string, int spacePtr, int index) {
		char tmp = string[spacePtr];
		string[spacePtr] = string[index];
		string[index] = tmp;
	}

	public static void main(String[] args) {
		/*String str = "hELLo wOrLd1";
		StringBuilder builder = new StringBuilder();
		char[] chars = str.toCharArray();

		for(int i = 0; i < chars.length; i++) {
			if(Character.isLetter(chars[i]) && Character.isLowerCase(chars[i])) {
				builder.append(String.valueOf(chars[i]).toUpperCase());
			} else {
				builder.append(String.valueOf(chars[i]).toLowerCase());
			}
		}
		
		System.out.println(builder.toString());*/
		
		
		
		String str2 = "hELLo wOrLd1";
		char []chars = str2.toCharArray();
		for(int i = 0; i < chars.length; ++i) {
			if((chars[i] >= 'a') && (chars[i] <= 'z')) {
				chars[i] -= 32;
			} else if((chars[i] >= 'A') && (chars[i] <= 'Z')) {
				chars[i] += 32;
			}
		}
		
		System.out.println(String.valueOf(chars));
	}
	
}