package com.liuxiangwin.test.ChainResponsiblity;

//Handler
public interface IemailHandler
{
	//reference to the next handler in the chain
	public void setNext(IemailHandler handler);
		
	//handle request
	public void handleRequest(Email email);
}

