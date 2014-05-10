package com.liuxiangwin.DesignPattern10.Template.test;

public abstract class RobootTemplate {
	public final void robootManaufacture() {
		this.Begin();
		this.Prepareration();
		this.Assemble();
		this.Test();
		this.Stop();

	}

	public abstract void Begin();

	public abstract void Prepareration();

	public abstract void Assemble();

	public abstract void Test();

	public abstract void Stop();
}
