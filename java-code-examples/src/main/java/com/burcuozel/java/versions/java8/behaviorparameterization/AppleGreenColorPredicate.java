package com.burcuozel.java.versions.java8.behaviorparameterization;

public class AppleGreenColorPredicate implements ApplePredicate{

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}

}
