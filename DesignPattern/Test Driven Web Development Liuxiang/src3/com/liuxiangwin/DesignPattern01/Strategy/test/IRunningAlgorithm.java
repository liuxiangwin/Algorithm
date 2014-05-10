package com.liuxiangwin.DesignPattern01.Strategy.test;

public interface IRunningAlgorithm {
	
	
	//Puting the  extends relationship (is a relatioship) 
	//has a relationship
	
	
	//Abstract the algorithm into somplace it could be interface
	//and the algorithm sperate into different 
	//Algorithm class only in the runtime set the implementation into it
	public void doRunning();
}
