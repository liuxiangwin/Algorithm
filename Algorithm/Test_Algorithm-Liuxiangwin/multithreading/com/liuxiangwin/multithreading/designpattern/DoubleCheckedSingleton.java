package com.liuxiangwin.multithreading.designpattern;

public class DoubleCheckedSingleton {
    /**
     * The code above is not thread-safe. 
     * Although it checks the value of instance once 
     * again within the synchronized block (for performance reasons), 
     * the JIT compiler can rearrange the bytecode in a way
     *  that the reference to instance is set before the constructor
     *   has finished its execution. 
     *   This means the method getInstance() 
     *   returns an object that may not have been initialized completely.
     *    To make the code thread-safe, 
     *    the keyword volatile can be used since Java 5 for the instance variable.
     *     Variables that are marked as volatile get only visible to 
     *     other threads 
     *  once the constructor of the object has finished its execution completely.

     */
	private static DoubleCheckedSingleton instance = null;

	public DoubleCheckedSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckedSingleton();
				}
			}
		}
		return instance;
	}

}


 class ThreadSafeSingleton {
	 
    private static ThreadSafeSingleton instance;
     
    private ThreadSafeSingleton(){}
     
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
     
    
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
