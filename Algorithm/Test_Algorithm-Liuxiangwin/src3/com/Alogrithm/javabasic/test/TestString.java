package com.Alogrithm.javabasic.test;

public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   String s1="AlanLiu";
	   
	   String s2="AlanLiu";
	   
	   String s3="Alan"+"Liu";
	   
	   System.out.println(s1==s2);//true 
	   
	   System.out.println(s2==s3);//true
	   
	   System.out.println("===============================");
	   String test1="abc";
	    
	   String test2="a";
	   
	   String test3=test2+"bc";
	   //if use the reference to contact the String in  pool not equals
	   System.out.println(test1==test3);//false
	   
	   
	   System.out.println("===============================");
	   
	   String check1="liuxiangwin";
	   
	   String check2=new String("liuxiangwin");
	   //Returns the memory address in the String pool 
	   String check3=check2.intern();
	   
	   System.out.println(check1==check3);//true
	   
	   System.out.println("===============================");
	   
	   print(check1);//true
	   
	   print(check2);//false
	   
	   print(check3);//true
	   
	   
	   
	}
     private static void print(String s)
     {
    	 String param="liuxiangwin";
    	 System.out.println(s==param);
     }
}
