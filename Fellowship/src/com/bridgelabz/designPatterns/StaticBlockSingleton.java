/******************************************************************************
 * purpose : Program to demonstrate Static block initialization.
 * 
 * @author Ansar
 * @version 1.2
 * @since 16/01/2018
 ******************************************************************************/ 
package com.bridgelabz.designPatterns;

public class StaticBlockSingleton 
{
	//it is similar to eager instance
	//but it instance of class is created in the static block
	//that provides option for exception handling.
	 
	private static StaticBlockSingleton instance;
	    
	    private StaticBlockSingleton(){}
	    
	    //static block initialization for exception handling
	    static
	    {
	        try{
	            instance = new StaticBlockSingleton();
	        }
	        catch(Exception e){
	            throw new RuntimeException("Exception occured in creating singleton instance");
	        }
	    }
	    public StaticBlockSingleton getStaticBlockInstance() 
	    {
	    	return instance;
	    }
}
