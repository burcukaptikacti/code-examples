package com.burcuozel.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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

	public static int reverseInteger(int x) {

		if (x > Integer.MAX_VALUE)
			return 0;
		int tempX = x < 0 ? x * (-1) : x;

		ArrayList<Integer> numbers = new ArrayList<>();
		while (tempX > 0) {
			int mod = tempX % 10;
			numbers.add(mod);
			tempX = tempX - mod;
			tempX = tempX / 10;

		}
		int reverseNumber = 0;
		int multiplyValue = 1;
		for (int i = numbers.size() - 1; i >= 0; i--) {
			reverseNumber += (numbers.get(i) * multiplyValue);
			multiplyValue *= 10;
		}
		return x < 0 ? reverseNumber * (-1) : reverseNumber;
	}

	public static int minimumCharDeleteCount(String x) {
		int[] frequences = new int[26];

		for (int i = 0; i < x.length(); i++) {
			frequences[x.charAt(i) - 'a']++;
		}

		Arrays.sort(frequences);

		int removedCount = 0;

		HashSet<Integer> seenFrequences = new HashSet<>();
		for (int i = 0; i < frequences.length; i++) {
			if (frequences[i] == 0)
				continue;

			if (seenFrequences.contains(frequences[i])) {
				int nextFrequencesCount = frequences[i] - 1;
				while (nextFrequencesCount != 0) {
					if (seenFrequences.contains(nextFrequencesCount)) {
						nextFrequencesCount--;
					} else {
						seenFrequences.add(nextFrequencesCount);
						break;
					}
				}
				removedCount += frequences[i] - nextFrequencesCount;

			} else {
				seenFrequences.add(frequences[i]);
			}
		}

		return removedCount;
	}
}
