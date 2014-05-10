package com.liuxiangwin.test.Command;
//Concrete Command
public class LightOnCommand implements ICommand {
	// reference to the light
	Light light;

	public LightOnCommand(Light light)
	{
		this.light = light;
	}

	public void execute()	{
		light.switchOn();
	}

}
