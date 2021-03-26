package com.burcuozel.algorithm;

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

		int tempNumber = x < 0 ? x * (-1) : x;
		int reversedNumber = 0;

		while (tempNumber != 0) {

			int mod = tempNumber % 10;

			if (reversedNumber > (Integer.MAX_VALUE - mod) / 10)
				return 0;

			reversedNumber = (reversedNumber * 10) + mod;
			tempNumber = tempNumber / 10;
		}

		return x < 0 ? reversedNumber * (-1) : reversedNumber;
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

	public static void reverseString(char[] s) {

		int startIndex = 0;
		int endIndex = s.length - 1;

		while (startIndex < endIndex) {

			char temp = s[startIndex];
			s[startIndex] = s[endIndex];

			s[endIndex] = temp;

			startIndex++;
			endIndex--;
		}

	}
}
