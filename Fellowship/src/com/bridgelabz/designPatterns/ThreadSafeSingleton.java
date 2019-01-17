/******************************************************************************
 * purpose : Program to demonstrate Thread Safe Singleton.
.
 * 
 * @author Ansar
 * @version 1.2
 * @since 17/01/2018
 ******************************************************************************/ 
package com.bridgelabz.designPatterns;

public class ThreadSafeSingleton 
{
	 private static ThreadSafeSingleton instance;
	    
	    private ThreadSafeSingleton(){}
	  
	    //using synchronized so that only one thread can use this method
	    public static synchronized ThreadSafeSingleton getInstance(){
	        if(instance == null){
	            instance = new ThreadSafeSingleton();
	        }
	        return instance;
	    }
}
