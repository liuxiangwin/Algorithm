package DesignPattern.Learn.Singleton;

public class SingletonStatic {
	//it would cost much  effort when start the thread
	private static SingletonStatic uniqueInstance = new SingletonStatic();
 
	private SingletonStatic() {}
 
	public static SingletonStatic getInstance() {
		return uniqueInstance;
	}
	
	// other useful methods here
	public String getDescription() {
		return "I'm a statically initialized Singleton!";
	}
}
