package com.liuxiangwin.web.test;

public class TestThreadPoolManager {

	ThreadPoolManager tpm = ThreadPoolManager.newInstance();

	public void sendMsg(String msg)

	{
		tpm.addLogMsg(msg + "��¼һ����־ ");
	}

	public static void main(String[] args)

	{
		for (int i = 0; i < 2000; i++) {
			new TestThreadPoolManager().sendMsg(Integer.toString(i));
		}

	}
}
