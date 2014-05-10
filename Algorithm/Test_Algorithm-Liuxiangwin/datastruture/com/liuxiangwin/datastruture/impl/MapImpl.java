package com.liuxiangwin.datastruture.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;

public class MapImpl<K, V> {

	private int size;
	private int DEFAULT_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private MapEntry<K, V>[] values = new MapEntry[DEFAULT_CAPACITY];
	
	private void ensureCapa() {
		if (size == values.length) {
			int newSize = values.length * 2;
			values = Arrays.copyOf(values, newSize);
		}
	}
	
	public void put(K key, V value) {
		boolean insert = true;
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i].setValue(value);
				insert = false;
			}
		}
		if (insert) {
			ensureCapa();
			values[size++] = new MapEntry<K, V>(key, value);
		}
	}


	public synchronized V get(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i] != null) {
				if (values[i].getKey().equals(key)) {
					return values[i].getValue();
				}
			}
		}
		return null;
	}

	
	public void remove(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i] = null;
				size--;
				condenseArray(i);
			}
		}
	}

	public int size() {
		return size;
	}	

	private void condenseArray(int start) {
		for (int i = start; i < size; i++) {
			values[i] = values[i + 1];
		}
	}

	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for (int i = 0; i < size; i++) {
			set.add(values[i].getKey());
		}
		return set;
	}
	
	public static void main(String args[])
	{
		MapImpl<Integer,String> map=new MapImpl<Integer,String>();
		map.put(1, "Alan");
		System.out.println(map.get(1));
		
	}


}

class MapEntry<K, V> {
	private final K key;
	private V value;

	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}
