package com.burcuozel.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.burcuozel.algorithm.model.ListNode;
import com.burcuozel.algorithm.model.Node;
import com.burcuozel.algorithm.model.TreeNode;

public class Easy {

	public static List<List<Integer>> generateTriangle(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();

		if (numRows == 0)
			return triangle;

		List<Integer> row = new ArrayList<>();
		row.add(1);
		triangle.add(row);

		for (int i = 1; i < numRows; i++) {
			List<Integer> prevRow = triangle.get(i - 1);
			List<Integer> currentRow = new ArrayList<>();

			currentRow.add(1);

			for (int j = 1; j < i; j++) {
				currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
			}

			currentRow.add(1);
			triangle.add(currentRow);
		}

		return triangle;

	}

	public static List<Integer> getRowOfTriangle(int rowIndex) {
		List<List<Integer>> triangle = new ArrayList<>();

		List<Integer> row = new ArrayList<>();
		row.add(1);
		triangle.add(row);

		for (int i = 1; i < rowIndex + 1; i++) {
			List<Integer> prevRow = triangle.get(i - 1);
			List<Integer> currentRow = new ArrayList<>();

			currentRow.add(1);

			for (int j = 1; j < i; j++) {
				currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
			}

			currentRow.add(1);
			triangle.add(currentRow);
		}

		return triangle.get(rowIndex);
	}

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

	public static List<String> fizzBuzz(int n) {
		List<String> results = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				results.add("FizzBuzz");
			} else if (i % 5 == 0) {
				results.add("Buzz");
			} else if (i % 3 == 0) {
				results.add("Fizz");
			} else {
				results.add(String.valueOf(i));
			}

		}

		return results;
	}

	public static int majorityElement(int[] nums) {

		int majorElement = nums[0];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				majorElement = nums[i];
				count++;
			} else if (majorElement == nums[i]) {
				count++;
			} else {
				count--;
			}
		}

		return majorElement;
	}

	public static int minDepth(TreeNode root) {

		if (root == null)
			return 0;

		int left = minDepth(root.left);
		int right = minDepth(root.right);

		if (left == 0 || right == 0) {
			return Math.max(left, right) + 1;
		} else {

			return Math.min(left, right) + 1;
		}
	}

	private static boolean isBalanced = true;

	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		height(root);

		return isBalanced;
	}

	public static int height(TreeNode root) {
		if (root == null)
			return -1;

		int left = height(root.left);
		int right = height(root.right);

		if (Math.abs(left - right) > 1)
			isBalanced = false;

		return Math.max(left, right) + 1;

	}

	public int maxDepthNAryTreeNode(Node root) {
		if (root == null)
			return 0;

		int max = -1;
		for (Node node : root.children) {
			max = Math.max(max, maxDepthNAryTreeNode(node));
		}

		return max + 1;

	}

	public static void moveZeroes(int[] nums) {

		int i = 0;
		int j = 0;
		while (i < nums.length && j < nums.length) {
			if (nums[i] == 0) {
				if (nums[j] != 0) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					i++;
				}
			} else {
				i++;
			}
			j++;
		}

	}

	public static int removeElement(int[] nums, int val) {
		int m = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				int temp = nums[m];
				nums[m] = nums[i];
				nums[i] = temp;
				m++;
			}
		}
		return m;
	}

	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}

			set.add(nums[i]);
		}
		return false;

	}

	public static boolean isAnagram(String s, String t) {

		if (s == null && t == null) {
			return true;
		}
		if ((s == null && t != null) || (s != null && t == null)) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}

		int[] frequences = new int[26];

		for (int i = 0; i < s.length(); i++) {
			frequences[s.charAt(i) - 'a']++;
			frequences[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (frequences[i] != 0) {
				return false;
			}
		}

		return true;
	}

	// Input: strs = ["eat","tea","tan","ate","nat","bat"]
	// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		HashMap<String, List<String>> grouppedStr = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String str = String.valueOf(temp);

			if (grouppedStr.containsKey(str)) {
				grouppedStr.get(str).add(strs[i]);
			} else {
				List<String> strList = new ArrayList<>();
				strList.add(strs[i]);
				grouppedStr.put(str, strList);
			}
		}

		return new ArrayList<List<String>>(grouppedStr.values());
	}

	public static int maxProfit(int[] prices) {

		int bIndex = 0;
		int sIndex = 0;
		int maxProfit = 0;
		while (bIndex < prices.length && sIndex < prices.length) {
			maxProfit = Math.max(maxProfit, prices[sIndex] - prices[bIndex]);

			if (prices[sIndex] - prices[bIndex] < 0) {
				bIndex++;
			} else {
				sIndex++;
			}
		}
		return maxProfit;
	}

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		String s = String.valueOf(x);

		int start = 0;
		int end = s.length() - 1;

		while (end > start) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}

		return true;

	}

	public static boolean isPalindrome2(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;
		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return (x == rev || x == rev / 10);
	}

}
