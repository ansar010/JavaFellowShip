/******************************************************************************
 * purpose : Program to demonstrate Eager initialization.
 * 
 * @author Ansar
 * @version 1.2
 * @since 16/01/2018
 ******************************************************************************/ 
package com.bridgelabz.designPatterns;

public class SingletonEagerInitialization 
{
	// instance is created even though client application might not be using it.
	private static SingletonEagerInitialization instance = new SingletonEagerInitialization();

	private SingletonEagerInitialization() {
		System.out.println("instance creating...");
	}

	public SingletonEagerInitialization getSingltonEager()
	{
		return instance;
	}
}
