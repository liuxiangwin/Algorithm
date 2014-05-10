package com.liuxiangwin.DesignPattern04.Observer.test;

public interface ISubject {
	
	
	public  void registerObserver(IObserver observer);
	
	
	public  void removeObserver(IObserver observer);
	
	
	public void notifyObservers();
	
	
	
	public void editRecord(String operation, String record);

}
