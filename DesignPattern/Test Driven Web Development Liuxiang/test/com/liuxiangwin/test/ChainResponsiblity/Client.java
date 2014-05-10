package com.liuxiangwin.test.ChainResponsiblity;

//email client 

public class Client
{
	private EmailProcessor processor; 
	
	public Client()
	{
	   createProcessor();
	
	}

	private void createProcessor()
	{
		processor = new EmailProcessor();
		processor.addHandler(new BusinessMailHandler());
		processor.addHandler(new GMailHandler());
		//processor.addHandler(new PersonalMailHandler());
		
		
	}
	
			
	public void addRule(IemailHandler handler)
	{
	   processor.addHandler(handler);
	}

	public void emailReceived(Email email)
	{
		processor.handleRequest(email);
	}
	

	public static void main(String[] args)
	{
		
		Client client = new Client();
	
	}

}
