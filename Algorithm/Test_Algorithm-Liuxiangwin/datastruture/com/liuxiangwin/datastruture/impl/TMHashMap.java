package com.liuxiangwin.datastruture.impl;

public class TMHashMap {
	// for simplicity size is taken as 2^4
	private static final int SIZE = 16;
	private Entry entryTable[] = new Entry[SIZE];

	/**
	 * User defined simple Map data structure with key and value. This is also
	 * used as linked list in case multiple key-value pairs lead to the same
	 * bucket with same hashcodes and different keys (collisions) using pointer
	 * 'next'.
	 *
	 * @author ntallapa
	 */
	class Entry {
		final String key;
		String value;
		Entry next;

		Entry(String k, String v) {
			key = k;
			value = v;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getKey() {
			return key;
		}
	}

	/**
	 * Returns the entry associated with the specified key in the HashMap.
	 * Returns null if the HashMap contains no mapping for the key.
	 */
	public Entry get(String key) {
		int hash = key.hashCode() % SIZE;
		Entry element = entryTable[hash];

		// if bucket is found then traverse through the linked list and
		// see if element is present
		while (element != null) {
			if (element.key.equals(key)) {
				return element;
			}
			element = element.next;
		}
		return null;
	}

	/**
	 * Associates the specified value with the specified key in this map. If the
	 * map previously contained a mapping for the key, the old value is
	 * replaced.
	 */
	public void put(String key, String v) {
		int hash = key.hashCode() % SIZE;
		Entry element = entryTable[hash];
		if (element != null) {
			// it means we are trying to insert duplicate
			// key-value pair, hence overwrite the current
			// pair with the old pair
			if (element.key.equals(key)) {
				element.value = v;
			} else {
				// traverse to the end of the list and insert new element
				// in the same bucket
				while (element.next != null) {
					element = element.next;
				}
				Entry entryInOldBucket = new Entry(key, v);
				element.next = entryInOldBucket;
			}
		} else {
			// new element in the map, hence creating new bucket
			Entry entryInNewBucket = new Entry(key, v);
			entryTable[hash] = entryInNewBucket;
		}
	}

	// for testing our own map
	public static void main(String[] args) {
		TMHashMap tmhm = new TMHashMap();

		tmhm.put("Niranjan", "SMTS");
		tmhm.put("Ananth", "SSE");
		tmhm.put("Niranjan", "SMTS1");
		tmhm.put("Chandu", "SSE");

		Entry e = tmhm.get("Niranjan");
		System.out.println("" + e.getValue());
	}
}