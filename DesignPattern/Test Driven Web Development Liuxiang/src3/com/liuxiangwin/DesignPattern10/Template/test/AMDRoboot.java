package com.liuxiangwin.DesignPattern10.Template.test;

public class AMDRoboot extends RobootTemplate {

	@Override
	public void Assemble() {
		System.out.println("AMD Roboot Assemble");

	}

	@Override
	public void Begin() {
		System.out.println("AMD Roboot Begin");

	}

	@Override
	public void Prepareration() {
		System.out.println("AMD Roboot Preparerationble");
	}

	@Override
	public void Test() {
		System.out.println("AMD Roboot Test");

	}

	@Override
	public void Stop() {
		System.out.println("AMD Roboot Stop");
	}

}
