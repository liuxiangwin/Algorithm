package com.liuxiangwin.DesignPattern01.Strategy.test;

public class WithStrategy {
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
