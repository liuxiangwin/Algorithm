package com.liuxiangwin.test.Command;

//Concrete Command
public class LightOffCommand implements ICommand{
	// the Command should hold a receiver 
	Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.switchOff();
		
	}
    


}
