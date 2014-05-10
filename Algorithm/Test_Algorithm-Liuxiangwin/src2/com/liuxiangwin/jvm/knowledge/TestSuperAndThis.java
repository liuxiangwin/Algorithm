package com.liuxiangwin.jvm.knowledge;

public class TestSuperAndThis extends SuperAndThis{
	
	public TestSuperAndThis(String name)
	{
		//super(2);
		this();
		
		
	}
	
	private TestSuperAndThis()
	{
		super(2);
		int i=9;
		
	}
	
	private void systemExit()
	{
		try {
			int i=0;
			System.out.println("This is try block");
			Integer.parseInt("Alan");
			//System.exit(0);
			
			
		} catch (Exception e) {
			System.out.println("This is catch block");
			System.exit(1);
		}
		finally
		{
			System.out.println("This is finally block");
			
		}
	}
	public static void main(String args[])
	{
		new TestSuperAndThis("Alan_Liu").systemExit();
	}

}
class SuperAndThis
{
	SuperAndThis(int id)
	{
		
	}
}