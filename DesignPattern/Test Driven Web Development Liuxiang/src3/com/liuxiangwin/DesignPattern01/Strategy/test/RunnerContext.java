package com.liuxiangwin.DesignPattern01.Strategy.test;

public class RunnerContext {
    //This is the Strategy context
	//It invoke the strategy method
	
	//It should tell the context which Algorithm or Strategy
	//should use
	//It could pass by parameter or consturtor or setMethod;
	
	//The invoke determine which strategy or Algorithm should
	//be use
	
	private IRunningAlgorithm runningAlgorithm;
	
	
	
	
	public void runing() {
		runningAlgorithm.doRunning();
	}
	
}
