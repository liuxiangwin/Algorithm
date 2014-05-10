package com.liuxiangwin.DesignPattern14.State.test;

public class DropState implements IState {

	public void Adjustment(Context context) {
		System.out.println("You need Drop frist");
		
	}

	public void Drop(Context context) {
		// TODO Auto-generated method stub
		context.setState(new ManualEntryState());
		System.out.println("The Slot Machine is start a Drop");
	}

	public void ManualEntry(Context context) {
		System.out.println("You need Drop frist");
		
	}

	public void Reconcile(Context context) {
		System.out.println("You need Drop frist");
		
	}

	public void Report(Context context) {
		// TODO Auto-generated method stub
		
	}

	
}
