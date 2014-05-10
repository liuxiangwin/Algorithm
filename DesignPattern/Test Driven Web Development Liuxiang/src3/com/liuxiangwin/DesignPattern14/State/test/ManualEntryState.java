package com.liuxiangwin.DesignPattern14.State.test;

public class ManualEntryState implements IState {

	public void Adjustment(Context context) {
		System.out.println("You need Manual Entry frist");
		
	}

	public void Drop(Context context) {
		System.out.println("You already did a drop");
		
	}

	public void ManualEntry(Context context) {
		context.setState(new AdjustmentState());
		System.out.println("The Slot Machine is doing to Manual Entry");
		
	}

	public void Reconcile(Context context) {
		System.out.println("You need Manual Entry frist");
		
	}

	public void Report(Context context) {
		// TODO Auto-generated method stub
		
	}



}
