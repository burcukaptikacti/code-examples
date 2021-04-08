package com.burcuozel.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.burcuozel.algorithm.model.ListNode;
import com.burcuozel.algorithm.model.TreeNode;

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

	/*
	 * This question can be solved with String.substring but then time complexity
	 * will be O(n2) because String.substring's time complexity is O(n)
	 * 
	 */
	public static int maxTwoDigitNumberInString(String s) {

		int max = Integer.MIN_VALUE;
		char zero = '0';
		for (int i = 0; i < s.length() - 1; i++) {

			int currentNum = ((s.charAt(i) - zero) * 10) + (s.charAt(i + 1) - zero);
			max = Math.max(max, currentNum);
		}

		return max;
	}

	public static int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left, right) + 1;

	}

	public static void deleteNode(ListNode node) {

		node.val = node.next.val;
		node = node.next.next;
	}

	public static int singleNumber(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++)
			ans = ans ^ nums[i];

		return ans;
	}

	public static String reverseVowels(String s) {

		HashSet<Character> vovelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

		int start = 0;
		int end = s.length() - 1;

		char[] str = s.toCharArray();

		while (start < end) {
			if (!vovelSet.contains(str[start])) {
				start++;
			} else if (!vovelSet.contains(str[end])) {

				end--;
			} else {
				char temp = str[start];
				str[start] = str[end];
				str[end] = temp;

				start++;
				end--;
			}
		}

		return String.valueOf(str);
	}

	public static String reverseStr(String s, int k) {

		char[] str = s.toCharArray();

		int i = 0;

		while (str.length > i) {

			if ((str.length - i) >= k) {
				swap(str, i, i + k - 1);
				i = i + (2 * k);
			} else {
				swap(str, i, str.length - 1);
				i = i + k;
			}
		}

		return String.valueOf(str);
	}

	private static void swap(char[] str, int i, int k) {
		while (i < k) {
			char temp = str[i];
			str[i] = str[k];
			str[k] = temp;
			k--;
			i++;
		}
	}

	public static String reverseWords(String s) {

		int start = 0;
		int end = 0;

		char[] str = s.toCharArray();

		while (end <= str.length) {

			if (end == str.length || str[end] == ' ') {
				swap(str, start, end - 1);
				start = end + 1;
			}
			end++;
		}
		return String.valueOf(str);
	}

}
