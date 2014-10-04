package com.liuxiangwin.jvm.knowledge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestPracticeMapUtil {
    
	public static void main(String args[])
	{
		HashMap<String,String> hashMap = new HashMap<String,String>();
	       hashMap.put("Alan","good guy");
	       hashMap.put("Jack","Movie guy");
	       hashMap.put("Alan","Adobe guy");
	       
	       Iterator iter = hashMap.keySet().iterator();
	       while (iter.hasNext()) {
	    	   	String key = (String)iter.next();
	    	   	String val = hashMap.get(key);
	    	   	System.out.println("Key is "+key+" --Value is-- "+val);     
	       
		 }
	     System.out.println(7%10);
	}
	
	private static void iteratorMap(Map<String, Integer> map) {
		//static int  i=20;//Complie error
		//static final int k=99; //Complie error		
		int i=16;
		Iterator<String> keyIterator = map.keySet().iterator();
		while (keyIterator.hasNext()) {
			String aKey = keyIterator.next();
			Integer aValue = map.get(aKey);
		}

		Iterator<Integer> valueIterator = map.values().iterator();
		while (valueIterator.hasNext()) {
			Integer aInteger = valueIterator.next();
		}

	}

	private void iteratorMapByForLoop(Map<String, Integer> map) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
		}

		for (String aKey : map.keySet()) {
			Integer aValue = map.get(aKey);
			System.out.println("" + aKey + ":" + aValue);
		}

		for (Integer aValue : map.values()) {
			System.out.println(aValue);
		}
	}

}
