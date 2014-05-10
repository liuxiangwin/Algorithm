package com.liuxiangwin.test.Command;

public class Client {
	public static void main(String[] args) {
		RemoteControl control = new RemoteControl();

		Light light = new Light();

		ICommand lightsOn = new LightOnCommand(light);

		ICommand lightsOff = new LightOffCommand(light);

		// switch on

		control.setCommand(lightsOn);

		control.pressButton();

		// switch off

		control.setCommand(lightsOff);

		control.pressButton();

	}

}
