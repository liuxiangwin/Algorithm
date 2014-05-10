package com.liuxiangwin.DesignPattern01.Strategy.test;

public class FasterRunner extends WithStrategy{
	public FasterRunner()
	{
		//The invoker tell the caller which Algorithm should use
		this.setRunningAlgorithm(new FastRunnerAlgorithm());
	}

}
