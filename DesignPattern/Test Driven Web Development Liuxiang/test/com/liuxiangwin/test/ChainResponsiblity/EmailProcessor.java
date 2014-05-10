package com.liuxiangwin.test.ChainResponsiblity;

public class EmailProcessor {
	
	//maintain a reference to the previous handler 
	//so we can add the next one
		private IemailHandler prevHandler;

		public void addHandler(IemailHandler handler)
		{
			if(prevHandler != null)
			{
				prevHandler.setNext(handler);
			}
			prevHandler = handler;
		}
		
		public void handleRequest(Email email)
		{
			prevHandler.handleRequest(email);
		}


}
