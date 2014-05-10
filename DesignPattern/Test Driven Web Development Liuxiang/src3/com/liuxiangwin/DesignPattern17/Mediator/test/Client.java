package com.liuxiangwin.DesignPattern17.Mediator.test;

public class Client {

	/**
	 * The Mediator pattern is used in many modern systems that reflect a
	 * send/receive protocol,
	 * 
	 * Advantage:the Mediator pattern has an important role to play as a means
	 * of centralizing interconnections between objects.
	 * 
	 * Disadvantage: The Mediator pattern can have a performance impact on a
	 * system. Because all communication must go through the mediator, it can
	 * become a bottleneck.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IMediator iMeidator = new ApplicationMediator();

		Colleague mobileColleague = new MobileColleague(iMeidator);

		Colleague pcColleague = new PcColleague(iMeidator);
		iMeidator.addColleague(mobileColleague);
		iMeidator.addColleague(pcColleague);

		pcColleague.send("Hi Pc is changing now");

	}

}
