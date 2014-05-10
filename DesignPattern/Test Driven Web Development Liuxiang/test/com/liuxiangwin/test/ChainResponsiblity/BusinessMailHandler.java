package com.liuxiangwin.test.ChainResponsiblity;

public class BusinessMailHandler implements IemailHandler {
	private IemailHandler next;
    
	//Set next Handler or it could set by construtor
	public void setNext(IemailHandler handler) {
		next = handler;
	}

	public void handleRequest(Email email)
    {
		if(!email.getFrom().endsWith("@businessaddress.com"))
		{
		    next.handleRequest(email);
		}
		else
		{
		    //handle request (move to correct folder)
		}

	}}
