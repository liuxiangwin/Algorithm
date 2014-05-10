package com.liuxiangwin.DesignPattern09.Facade.test;

public class SubsystemA {
	public String A1() {
		System.out.println("Subsystem A, Method A1\n");
		return "Subsystem A, Method A1\n";
	}

	public String AtoA() {
		System.out.println("Subsystem AtoA, Method AtoA\n");
		return "Subsystem AtoA, Method AtoA\n";
	}

}
