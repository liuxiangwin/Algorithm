package com.liuxiangwin.DesignPattern14.State.test;

public class AdjustmentState implements IState {

	public void Adjustment(Context context) {
		context.setState(new ReconcileState());
		System.out.println("The Slot Machine is doing to Adjustment");
		
	}

	public void Drop(Context context) {
		
		System.out.println("You already did a drop");
	}

	public void ManualEntry(Context context) {
		System.out.println("You already Manual Entry ");
		
	}

	public void Reconcile(Context context) {
		System.out.println("You need Adjustment frist");
		
	}

	public void Report(Context context) {
		System.out.println("You need Reconcile frist");
		
	}



}
