package com.liuxiangwin.DesignPattern17.Mediator.test;

public interface IMediator {
	
	
	public void addColleague(Colleague colleague) ;

    public void send(String message,Colleague colleague);
}
