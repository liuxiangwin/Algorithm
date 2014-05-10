package com.liuxiangwin.jvm.knowledge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Description: <br/>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> <br/>
 * Copyright (C), 2001-2010, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class StaticBase {
	// 定义一个count类变量
	static int count = 20;
}

public class StaticSub {
	private static int gobalId = 36000;

	private int age;
	private String name;

	static {
		StaticSub.gobalId = 36500;

	}
	{
		this.age = 2010;

	}

	private StaticSub() {
		this.name = "2011";

	}

	// 子类再定义一个count类变量
	static int count = 200;

	public void info() {
		System.out.println("访问本类的count类变量:" + count);
		System.out.println("访问父类的count类变量:" + StaticBase.count);
	}

	public static void main(String[] args) {

		System.out.println(StaticSub.gobalId);
		System.out.println(new StaticSub().age);
		System.out.println(new StaticSub().name);

		StaticSub sb = new StaticSub();
		sb.info();

		HashSet<Object> hashSet = new HashSet<Object>();
		ArrayList<Integer> arryList = new ArrayList<Integer>();
		arryList.add(1982);
		arryList.add(1997);
		arryList.add(2012);
		System.out.println(arryList);
		arryList.add(2, 2008);
		System.out.println(arryList);
		
		int array[] ={1920,1930,1950};
		
		add(2,array,1945);
		
		System.out.println(Arrays.toString(array));
	}

	public static void add(int index, int[] array, int element) {
		int orgSize=array.length;
		
		array = Arrays.copyOf(array, array.length+1);
		
		
		System.arraycopy(array, index, array, index+1, orgSize-index);

		//System.arraycopy(array, index, array, index + 1, array.length - index);
		array[index] = element;
		// size++;
	}
}
