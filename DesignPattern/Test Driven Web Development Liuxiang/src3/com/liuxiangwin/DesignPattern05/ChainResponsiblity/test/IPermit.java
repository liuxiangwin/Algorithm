package com.liuxiangwin.DesignPattern05.ChainResponsiblity.test;

public interface IPermit {

	enum Level {
		Manager(9000), Supervisor(4000), Clerk(1000);
		private final int limit;

		Level(int limit) {
			this.limit = limit;

		}

		public int getLimit() {
			return limit;
		}

	}

	public void singnatureWithMoney(int value);

}
