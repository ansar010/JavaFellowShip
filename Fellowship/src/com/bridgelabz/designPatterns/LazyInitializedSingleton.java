/******************************************************************************
 * purpose : Program to demonstrate Lazy Initialization
.
 * 
 * @author Ansar
 * @version 1.2
 * @since 17/01/2018
 ******************************************************************************/ 
package com.bridgelabz.designPatterns;
//It creates instance when user call the method 
public class LazyInitializedSingleton 
{
	private LazyInitializedSingleton instance ;

	private LazyInitializedSingleton()
	{}

	public LazyInitializedSingleton getLazyInstance()
	{
		if(instance==null)
		{
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
	
	//DrawBack:it can cause issues if multiple threads are inside
	//the if condition at the same time
}
