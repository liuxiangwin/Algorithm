package com.liuxiangwin.DesignPattern01.Strategy.test;

public class SlowerRunner extends WithStrategy{
	public SlowerRunner()
	{
		//The invoker tell the caller which Algorithm should use
		
		//This is like the Client
		this.setRunningAlgorithm(new SlowRunnerAlgorithm());
	}
	

}
