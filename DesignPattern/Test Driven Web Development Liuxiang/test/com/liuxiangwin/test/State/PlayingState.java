package com.liuxiangwin.test.State;

public class PlayingState implements IState {
	public void pressPlay(MP3PlayerContext context) {
		context.setState(new StandbyState());
	}

}
