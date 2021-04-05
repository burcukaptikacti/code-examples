package com.burcuozel.java.general;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {

	private final String name;
	private final int size;
	private final Map<String, Integer> fieldCounts;

	public ImmutableClass(String name, int size, Map<String, Integer> fieldCounts) {

		this.name = name;
		this.size = size;

		Map<String, Integer> tempFieldCounts = new HashMap<String, Integer>();

		for (Map.Entry<String, Integer> entry : fieldCounts.entrySet()) {
			tempFieldCounts.put(entry.getKey(), entry.getValue());
		}

		this.fieldCounts = tempFieldCounts;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public Map<String, Integer> getFieldCounts() {

		Map<String, Integer> tempFieldCounts = new HashMap<String, Integer>();

		for (Map.Entry<String, Integer> entry : fieldCounts.entrySet()) {
			tempFieldCounts.put(entry.getKey(), entry.getValue());
		}

		return tempFieldCounts;
	}

}
