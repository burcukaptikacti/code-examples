package com.burcuozel.java.versions.java8.behaviorparameterization;

public class AppleFancyFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		return "Apple size is:" + apple.getWeight();
	}

}
