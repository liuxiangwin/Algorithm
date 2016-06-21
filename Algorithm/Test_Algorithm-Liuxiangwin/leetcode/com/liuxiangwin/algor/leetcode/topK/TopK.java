package com.liuxiangwin.algor.leetcode.topK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopK {

	/**
	 * Bucket Sort Java O(n) Solution O(n)
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int value : nums) {
			frequencyMap
					.put(value,
							frequencyMap.containsKey(value) ? frequencyMap
									.get(value) + 1 : 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<Integer>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<Integer>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}

	/*
	 * O(n*log(n-k))
	 */
	public List<Integer> topKFrequentQueue(int[] numbers, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : numbers) {
			map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
		}

		PriorityQueue<Integer> pque = new PriorityQueue<Integer>(
				numbers.length, new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						return o1.intValue() - o2.intValue();
					}
				});
		// PriorityQueue<Map.Entry<Integer, Integer>> pque =
		// new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) ->
		// o2.getValue() - o1.getValue());
		//pque.addAll(map.entrySet());
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			ret.add(pque.poll().intValue());
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
