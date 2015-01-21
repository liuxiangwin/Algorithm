package com.Alogrithm.javabasic.test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class TestString implements Serializable{
	private String name;
	public TestString(String name){
		this.name = name;
	}

	/**
	 * @param args
	 */
	private String dirctorName ="Ning";
	private static String vpName ="Didbyy";
	
	public static void main(String[] args) {
		String s1 = "AlanLiu";

		String s2 = "AlanLiu";

		String s3 = "Alan" + "Liu";

		System.out.println(s1 == s2);// true

		System.out.println(s2 == s3);// true

		System.out.println("===============================");
		String test1 = "abc";

		String test2 = "a";

		String test3 = test2 + "bc";
		// if use the reference to contact the String in pool not equals
		System.out.println(test1 == test3);// false

		System.out.println("===============================");

		String check1 = "liuxiangwin";

		String check2 = new String("liuxiangwin");
		// Returns the memory address in the String pool
		String check3 = check2.intern();

		System.out.println(check1 == check3);// true

		System.out.println("===============================");

		print(check1);// true

		print(check2);// false

		print(check3);// true
		
		new TestString.adobe().adobecount();
		
	    HashSet<TestString> hash = new HashSet<TestString>();
	    hash.add(new TestString("Jack"));
	    hash.add(new TestString("Kate"));
	    hash.add(new TestString("Jack"));
	    hash.add(new TestString("Tracy"));
	    hash.add(new TestString("Kate"));
	    System.out.println("hashset size "+hash.size());
	    
	    HashMap<String,String> hm = new HashMap<String,String>();
	    hm.put("Jack","");
	    hm.put("Kate","");
	    hm.put("Jack1","");
	    hm.put("Tracy","");
	    hm.put("Kate1","");
	    System.out.println("hashmap size "+hm.size());
	    
	    
	}

	private static void print(String s) {
		String param = "liuxiangwin";
		System.out.println(s == param);
	}

	private static class adobe {
		private void adobecount() {	
			
		}
		public void adobepantry(String employee) {
			
		}
	}

	protected class google {
		private void googlecount() {		}
		public void googlepantry(String employee) {
			String out = vpName;
		}
	}

	@Override
	public int hashCode() {
		return this.name.length()>>>1;
		//int hashcode = this.name.hashCode();
		//return hashcode;
		//return super.hashCode();//认为是同一个对象
	}

	@Override
	public boolean equals(Object o) {
		TestString other = (TestString)o;  
		 return other != null &&
				other instanceof TestString && 
				other.name == this.name;
	}
}

class outGolbalCompany {	


}