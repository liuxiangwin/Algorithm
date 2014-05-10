package com.liuxiangwin.DesignPattern17.Mediator.test;

public abstract class Colleague {
	private IMediator mediator;

	public Colleague(IMediator mediator) {
		this.mediator = mediator;
	}

	public void send(String message) {
		mediator.send(message, this);
	}

	protected abstract void recieve(String message);

}
