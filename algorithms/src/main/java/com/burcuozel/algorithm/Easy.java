package com.burcuozel.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Easy {

	public static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> hash = new HashMap<>();

		int[] results = new int[2];
		for (int i = 0; i < nums.length; i++) {

			int diffirence = target - nums[i];
			if (hash.containsKey(diffirence)) {
				results[0] = hash.get(diffirence);
				results[1] = i;
				break;
			}
			hash.put(nums[i], i);

		}
		return results;
	}
}
