package com.liuxiangwin.DesignPattern05.ChainResponsiblity.test;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DefaultFinainace defaultfin = new DefaultFinainace();
		
		int money []=new int[]{9000,1000,4000,12000};
		Clerk clerk = new Clerk(defaultfin);

		Supervisor supervisor = new Supervisor(clerk);

		Manger manager = new Manger(supervisor);
		
		for(int i=0;i<money.length;i++)
			{
			manager.singnatureWithMoney(money[i]);
			}
		
	}

}
