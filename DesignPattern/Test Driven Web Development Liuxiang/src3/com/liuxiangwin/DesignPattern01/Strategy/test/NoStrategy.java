package com.liuxiangwin.DesignPattern01.Strategy.test;

public class NoStrategy {
	
	
    public void doRunning()
    {
    	//do somthing
    }

}

class SlowerRunner1 extends NoStrategy
{

	@Override
	public void doRunning() {
		//slower running
	}

}


class FastRunner extends NoStrategy
{
	@Override
	public void doRunning() {
		//FastRunner running
	}
}


class MiddlerRunner extends NoStrategy
{
	@Override
	public void doRunning() {
		//MiddlerRunner running
	}
}