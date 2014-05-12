package com.liuxiangwin.DesignPattern01.Strategy.test;

public class WithStrategy {
	//This is more like contex class to determine the 
	//Strategy class or strategy class trigger method
	
	//It like ShoppingCart is the context class
	//it would trigger the pay method, the pay class
	//could be CreditCard or  Paypal etc
	public enum RunnerType {

		SlowerRunner, FastRuner, MiddleRunner;
	}

	private IRunningAlgorithm runningAlgorithm;

	public WithStrategy() {
		// TODO Auto-generated constructor stub
	}

	public void setRunningAlgorithm(IRunningAlgorithm runningAlgorithm) {
		this.runningAlgorithm = runningAlgorithm;
	}
    
	
	/**
	 * 
	 */
	public void runing() {
		runningAlgorithm.doRunning();
	}

	// If the invoker in the base class it could use
	// if else or swith case to determine the Algorithm
	public void invokeTheStategy(RunnerType runnerType) {
		switch (runnerType) {
		case FastRuner:
			setRunningAlgorithm(new FastRunnerAlgorithm());
			break;
		case SlowerRunner:
			setRunningAlgorithm(new SlowRunnerAlgorithm());
			break;
		}

	}

}
