package com.skillstorm;

/*
 * In order to create Lambdas, I first need a functional interface
 * 
 * A functional interface is an Interface that only has one and ONLY one abstract method
 * 
 * A best practice is to annotate our interfaces with @FunctionalInterface to enforce this behavior
 * 
 * This works the same was @Override
 */
@FunctionalInterface
public interface Action {

	// change return type to void for FunctionalInterfacePractice
	int act(int num);
}
