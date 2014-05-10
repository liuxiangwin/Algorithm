package com.liuxiangwin.test.State;

public class MP3PlayerContext {
	private IState iState;
	
	
	

	private MP3PlayerContext(IState state) {
		this.iState = state;
	}

	public void play() {
		iState.pressPlay(this);
	}

	public void setState(IState state) {
		this.iState = state;
	}

	public IState getState() {
		return iState;
	}

}
