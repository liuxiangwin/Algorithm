package com.liuxiangwin.DesignPattern10.Template.test;

public class IntelRoboot extends RobootTemplate {

	@Override
	public void Assemble() {
		System.out.println("Intel Roboot Assemble");

	}

	@Override
	public void Begin() {
		System.out.println("Intel Roboot Begin");
	}

	@Override
	public void Prepareration() {
		System.out.println("Intel Roboot Prepareration");

	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Test() {
		// TODO Auto-generated method stub

	}

}
