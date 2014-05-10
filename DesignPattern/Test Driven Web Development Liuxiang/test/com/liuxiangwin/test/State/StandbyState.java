package com.liuxiangwin.test.State;

public class StandbyState implements IState {

	public void pressPlay(MP3PlayerContext context) {
		context.setState(new PlayingState());
	}

}
