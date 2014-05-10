package com.liuxiangwin.DesignPattern14.State.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Client {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("---------------------------------------");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_AccountingProcess_Correct() {
		Context context = new Context();
		context.setState(new DropState());
		context.request("Drop");
		context.request("ManualEntry");
		context.request("Adjustment");
		context.request("Reconcile");

	}

	@Test
	public void test_AccountingProcess_NotCorrect() {
		Context context = new Context();
		context.setState(new DropState());
		context.request("ManualEntry");
		context.request("Adjustment");
		context.request("Reconcile");
	}

	@Test
	public void test_AccountingProcess_NotCorrect_Scenario2() {
		Context context = new Context();
		context.setState(new AdjustmentState());
		context.request("ManualEntry");
		context.request("Adjustment");
		context.request("Reconcile");
	}
}
