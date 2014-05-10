package com.liuxiangwin.DesignPattern17.Mediator.test;

public class MobileColleague extends Colleague {

	public MobileColleague(IMediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	public void recieve(String message) {

		System.out.println("MoblieColleague recieve " + message);
	}
}
