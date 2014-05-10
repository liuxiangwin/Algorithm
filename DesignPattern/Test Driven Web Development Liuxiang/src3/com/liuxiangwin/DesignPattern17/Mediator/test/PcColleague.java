package com.liuxiangwin.DesignPattern17.Mediator.test;

public class PcColleague extends Colleague{

	public PcColleague(IMediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	public void recieve(String message) {

		System.out.println("PcColleague recieve " + message);
	}
}
