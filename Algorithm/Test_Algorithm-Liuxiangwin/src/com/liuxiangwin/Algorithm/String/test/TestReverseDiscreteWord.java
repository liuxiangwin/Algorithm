package com.liuxiangwin.Algorithm.String.test;

import java.util.Arrays;

public class TestReverseDiscreteWord {

	/**
	 * Attention this case the String array is a char array
	 */
	public static void main(String[] args) {
		char[] sentense = {'i',' ','l','o','v','e',' ','y','o','u'};
		
		System.out.println("Before reverse"+Arrays.toString(sentense));
        
		reverse(sentense,0,sentense.length-1);
        
        System.out.println("After reverse"+Arrays.toString(sentense));
        
        
        char[] testSentense2 = {'i',' ','l','o','v','e',' ','y','o','u'};

        reverseWordByBlank(testSentense2);        

        System.out.print("After reverse Word by blank "+Arrays.toString(testSentense2));
        
        char [] newTest = "the sky is blue".toCharArray();
        		
        reverseWordByBlank(newTest);
        System.out.println(Arrays.toString(newTest));
        
        lengthOfLongestSubstring();
        
        //return "blue is sky the".
        String reveseEachWord = reveseEachWord("the sky is blue");
        System.out.println("reveseEachWord "+ reveseEachWord);
	}

	private static void reverse(char[] src, int start, int end) {

		while (start < end) {
			char temp = src[start];
			src[start] = src[end];
			src[end] = temp;			
			start++;
			end--;
		}

	}
    //reverse the each word before the blank
	private static void reverseWordByBlank(char[] string) {
		int i = 0;
		int start = 0;
		while (i < string.length) {
			if (string[i] != ' ') {
				i++;
			} else {
				reverse(string, start, i);
				start = i + 1;
				System.out.println("" + Arrays.toString(string));
			}
		}

	}
	
	public static void lengthOfLongestSubstring() {
		  String str = "abcbcbd";
		  String sb = "";

		for (int i = 0; i < str.length(); i++) {

			if (sb.indexOf(str.charAt(i)) == -1) {
				sb += str.charAt(i);
			} else
				break;
		}
		System.out.println("Substring: "+sb+" Length: " + sb.length());
		}
 
	
	//1.先对每个单词进行逆转，最后再对整个字符串逆转
   public static String reveseEachWord(String string)
   {   int i=0; int j= 0;
       char[] cArray =string.toCharArray();
       while(j<string.length())
       {
    	   if(cArray[j]==' '){
    		   reverse(cArray,i,j-1);
    		   i=j+1;
    	   }
    	   if(j==string.length()-1)
    	   {
    		   reverse(cArray,i,j);
    	   }
    	   j++;
       }
      int start=0;int end= string.length()-1;
       while (start < end) {
			char temp = cArray[start];
			cArray[start] = cArray[end];
			cArray[end] = temp;			
			start++;
			end--;
		}   
       
       return String.valueOf(cArray);	   
   }
   //2.根据空格切分字符串，将切分得到的单词存到vector中，
    //然后将vector中的单词从末尾开始输出即可。
   //由于栈具有“先进后出”的性质
   
}
