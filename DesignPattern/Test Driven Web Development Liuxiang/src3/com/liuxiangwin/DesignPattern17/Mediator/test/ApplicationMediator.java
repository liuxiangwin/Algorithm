package com.liuxiangwin.DesignPattern17.Mediator.test;

import java.util.ArrayList;

public class ApplicationMediator implements IMediator {
	private ArrayList<Colleague> colleagueList;

	public ApplicationMediator() {
		this.colleagueList = new ArrayList<Colleague>();

	}

	public void addColleague(Colleague colleague) {
		colleagueList.add(colleague);

	}

	public void send(String message, Colleague orignal) {
		// TODO Auto-generated method stub
		for (Colleague colleague : colleagueList) {
			if (colleague != orignal) {
				colleague.recieve(message);
			}
		}

	}

}
