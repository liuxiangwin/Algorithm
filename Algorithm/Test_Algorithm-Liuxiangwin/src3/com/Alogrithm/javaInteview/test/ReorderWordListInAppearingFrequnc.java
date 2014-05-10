package com.Alogrithm.javaInteview.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ReorderWordListInAppearingFrequnc {
	public static void main(String[] args) {
		String[] input = { "Dog", "Amar", "Abhishek", "Abhishek", "Amar",
				"Abhishek", "Amar", "Boy", "Ball", "Dog" };

		String[] expectedOutput = { "Abhishek", "Abhishek", "Abhishek", "Amar",
				"Amar", "Amar", "Dog", "Dog", "Ball", "Boy" };
		System.out.println(Arrays.toString(doIt(input)));
		assert Arrays.equals(expectedOutput, doIt(input));
	}

	public static String[] doIt(String[] input) {

		HashMap<String, Integer> orgMap = new HashMap<String, Integer>();
		for (String word : input) {
			Integer occurrence = orgMap.get(word);
			if (occurrence == null) {
				orgMap.put(word, 1);
			} else {
				orgMap.put(word, occurrence + 1);
			}
		}

		printOrgMap(orgMap);

		TreeMap<Integer, TreeSet<String>> freqMap = new TreeMap<Integer, TreeSet<String>>();

		String[] words = new String[orgMap.size()];
        
		//iterator the original key 
		for (String word : orgMap.keySet().toArray(words)) {
			Integer freq = orgMap.get(word);
			//1.put the TreeSet in new map,tree may include same frequence word
			//2.use the max minus the high frequcecy value,then positon in the front
			TreeSet<String> treeSet = freqMap.get(Integer.MAX_VALUE-freq);
			if (treeSet == null) {
				TreeSet<String> wordSet = new TreeSet<String>();
				wordSet.add(word);
				freqMap.put(Integer.MAX_VALUE-freq, wordSet);
			} else {
				treeSet.add(word);
			}
		}

		printFreqMap(freqMap);
		

		ArrayList<String> result = new ArrayList<String>();
		Integer[] freqs = new Integer[freqMap.size()];	

		for (Integer key : freqMap.keySet().toArray(freqs)) {
			TreeSet<String> wordSet = freqMap.get(key);
			for (String word : wordSet) {
				for (int i = Integer.MAX_VALUE - key - 1; i >= 0; i--)
				{
					result.add(word);
				}
			}
		}

		return result.toArray(new String[result.size()]);
	}

	private static void printOrgMap(HashMap<String, Integer> orgMap) {
		for (Map.Entry<String, Integer> entry : orgMap.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();

			System.out.println("" + key + ":" + value);
		}
	}

	private static void printFreqMap(TreeMap<Integer, TreeSet<String>> freqMap) {
		for (Map.Entry<Integer, TreeSet<String>> entry : freqMap.entrySet()) {
			Integer key = entry.getKey();
			TreeSet<String> value = entry.getValue();

			System.out.println("freqToWordMap: " + " " + key + ":" + value);
		}
		System.out.println("freqToWordMap.size() " + freqMap.size());
	}

}
