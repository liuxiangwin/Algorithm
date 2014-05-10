package com.liuxiangwin.DesignPattern12.Iterator.test;

public class Collection {
	private String _name;
	
	
	private Count[] _countArray=new Count[100];
	
	private int _arrayNumber=0;

	public Collection(String name) {
		this._name = name;

	}
   public void add(Count count)
   {
	   _countArray[_arrayNumber++]=count;
   }
   
   public CollectionIterator iterator()
   {
	  return new CollectionIterator(_countArray);
   }
}
