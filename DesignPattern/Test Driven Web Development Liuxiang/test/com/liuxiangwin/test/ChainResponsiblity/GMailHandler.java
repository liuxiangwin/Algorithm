package com.liuxiangwin.test.ChainResponsiblity;

public class GMailHandler implements IemailHandler
{
	private IemailHandler next;

	public void setNext(IemailHandler handler)
	{
	    next = handler;
	}
	
	public void handleRequest(Email email)
    {
		if(!email.getFrom().endsWith("@gmail.com"))
		{
		    next.handleRequest(email);
		}
		else
		{
		    //handle request (move to correct folder)
		}

	}	

}
