package com.liuxiangwin.DesignPattern14.State.test;

public class Context {
	/*public enum AccountStatus {
		
		Drop("drop"), ManualEntry("manualEntry"), 
		Adjustment("adjustment"), Reconcile("reconcile");
		private String _accountingStatus;
		AccountStatus(String accountingStatus)
		{
		   this._accountingStatus=accountingStatus;
		}
	}*/
	public enum AccountStatus {
		
		Drop, ManualEntry, Adjustment, Reconcile;

	}
	private IState state;

	public void request(String requestOperation) {
		AccountStatus accountStatus=AccountStatus.valueOf(requestOperation);
		switch(accountStatus)
		{
			case Drop:
				state.Drop(this);
			break;
			case ManualEntry:
				state.ManualEntry(this);
			break;
			case Adjustment:
				state.Adjustment(this);
			break;
			case Reconcile:
				state.Reconcile(this);
			break;	
		
		}
//		if (requestOperation.equals() {
//			state.Drop(this);
//			
//		} else if (requestOperation.equals(AccountStatus.ManualEntry)) {
//			state.ManualEntry(this);
//			
//		} else if (requestOperation.equals(AccountStatus.Adjustment)) {
//			state.Adjustment(this);
//			
//		} else if (requestOperation.equals(AccountStatus.Reconcile)) {
//			state.Reconcile(this);
//		}
	}

	public IState getState() {
		return state;
	}

	public void setState(IState state) {
		this.state = state;
	}

}
