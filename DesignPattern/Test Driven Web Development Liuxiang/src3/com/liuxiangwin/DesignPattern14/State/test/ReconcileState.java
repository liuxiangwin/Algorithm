package com.liuxiangwin.DesignPattern14.State.test;

public class ReconcileState implements IState {

	public void Adjustment(Context context) {
		// TODO Auto-generated method stub
		System.out.println("You already did a Adjustment");
	}

	public void Drop(Context context) {
		// TODO Auto-generated method stub
		System.out.println("You already did a Drop");
	}

	public void ManualEntry(Context context) {
		System.out.println("You already did a ManualEntry");
		
	}

	public void Reconcile(Context context) {
		System.out.println("The Slot Machine is processing Reconcile");
		
	}

	public void Report(Context context) {
		// TODO Auto-generated method stub
		
	}


}
