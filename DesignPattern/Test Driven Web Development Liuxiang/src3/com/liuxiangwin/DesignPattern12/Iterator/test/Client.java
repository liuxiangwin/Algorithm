package com.liuxiangwin.DesignPattern12.Iterator.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Client {

	/**
	 * 
	 * The Iterator pattern defines a fundamental separation 
	 * between the iteration process and the enumeration process.
	 */

	private Collection creatCollection() throws ParseException {
		Collection collection = new Collection("Casino");

		collection.add(new Count(1, formatter.parse("2010-04-21 10:09:28")));

		collection.add(new Count(2, formatter.parse("2010-05-25 14:49:28")));

		collection.add(new Count(3, formatter.parse("2010-07-12 20:00:18")));

		collection.add(new Count(4, formatter.parse("2010-07-20 17:08:28")));

		return collection;
	}

	public static void main(String[] args) throws ParseException {
		Client main = new Client();
		Collection collection = main.creatCollection();
		for (CollectionIterator iter = collection.iterator(); iter.hasNext();) {
			Count count = (Count) iter.next();
			System.out.println(count.toString());
		}

	}

	private static SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

}
