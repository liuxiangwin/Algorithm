package com.liuxiangwin.DesignPattern08.Adapter.test;

public class Adaptee {
	private String _ARMName;
	private String _ARMVersion;

	public Adaptee(String ARMName, String ARMVersion) {
		this._ARMName = ARMName;
		this._ARMVersion = ARMVersion;
	}

	public String getARM() {
		return _ARMName;
	}

	public String getARMVersion() {
		return _ARMVersion;
	}
}
