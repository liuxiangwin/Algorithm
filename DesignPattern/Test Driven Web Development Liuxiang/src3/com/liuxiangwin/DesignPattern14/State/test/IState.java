package com.liuxiangwin.DesignPattern14.State.test;

public interface IState {
	public void Drop(Context context);

	public void ManualEntry(Context context);

	public void Adjustment(Context context);

	public void Reconcile(Context context);

	public void Report(Context context);

}
