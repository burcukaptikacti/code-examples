package com.burcuozel.java.versions.java8.behaviorparameterization;

import java.util.ArrayList;
import java.util.List;

public class BehaviorParameterization {

	public static void main(String[] args) {

		List<Apple> inventory = new ArrayList<>();
		List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor());
			}
		});

		redApples = filterApples(inventory,(Apple apple) -> "red".equals(apple.getColor()));

	}

	public static List<Apple> filterGreenApples(List<Apple> inventory) {

		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {

		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {

		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {

		for (Apple apple : inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}

}
