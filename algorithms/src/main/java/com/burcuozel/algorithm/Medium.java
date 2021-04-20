package com.burcuozel.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import com.burcuozel.algorithm.model.ListNode;

public class Medium {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode head = new ListNode();
		ListNode tempNode = head;

		int carry = 0;

		while (l1 != null || l2 != null || carry > 0) {
			int sum = carry;

			sum += l1 == null ? 0 : l1.val;
			sum += l2 == null ? 0 : l2.val;

			tempNode.next = new ListNode(sum % 10);
			tempNode = tempNode.next;
			carry = sum / 10;

			l1 = l1 != null ? l1.next : l1;
			l2 = l2 != null ? l2.next : l2;

		}

		return head.next;
	}

	public static int lengthOfLongestSubstring(String s) {

		int i = 0;
		int j = 0;
		int max = 0;

		HashSet<Character> charSet = new HashSet<Character>();
		while (j < s.length()) {
			if (!charSet.contains(s.charAt(j))) {
				charSet.add(s.charAt(j));
				max = Math.max(max, charSet.size());
				j++;

			} else {
				charSet.remove(s.charAt(i));
				i++;
			}
		}

		return max;
	}

	public static int countOfDeletedChars(String s) {

		int[] frequences = new int[26];

		for (int i = 0; i < s.length(); i++) {
			frequences[s.charAt(i) - 'a']++;
		}

		HashSet<Integer> occurrences = new HashSet<Integer>();

		int totalDeletedChars = 0;
		for (int i = 0; i < frequences.length; i++) {
			if (frequences[i] == 0) {
				continue;
			}

			if (occurrences.contains(frequences[i])) {

				int currentValue = frequences[i] - 1;
				while (currentValue > 0) {
					if (occurrences.contains(currentValue)) {
						currentValue--;
					} else {
						occurrences.add(currentValue);
						break;
					}
				}
				totalDeletedChars += frequences[i] - currentValue;

			} else {
				occurrences.add(frequences[i]);

			}
		}

		return totalDeletedChars;
	}

	public static List<Integer> majorityElement(int[] nums) {

		int majorElement1 = 0;
		int majorElement2 = 0;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (majorElement1 == nums[i]) {
				count1++;
			} else if (majorElement2 == nums[i]) {
				count2++;
			} else if (count1 == 0) {
				count1++;
				majorElement1 = nums[i];
			} else if (count2 == 0) {
				count2++;
				majorElement2 = nums[i];
			} else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;
		for (

				int i = 0; i < nums.length; i++) {
			if (majorElement1 == nums[i]) {
				count1++;
			} else if (majorElement2 == nums[i]) {
				count2++;
			}
		}

		List<Integer> results = new ArrayList<>();
		if (count1 > nums.length / 3) {
			results.add(majorElement1);
		}
		if (count2 > nums.length / 3) {
			results.add(majorElement2);
		}

		return results;
	}

	// TODO: Solve again
	public static int findAnagrams(String s, String p) {

		int index = 0;

		List<Integer> results = new ArrayList<>();
		while (index <= s.length() - p.length()) {
			String temp = s.substring(index, index + p.length());
			if (isAnagram(temp, p)) {
				results.add(index);
			}
			index++;
		}

		return results.size();
	}

	private static boolean isAnagram(String s, String t) {

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

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				int num1 = stack.pop();
				int num2 = stack.pop();

				stack.add(num2 + num1);

			} else if (tokens[i].equals("-")) {
				int num1 = stack.pop();
				int num2 = stack.pop();

				stack.add(num2 - num1);

			} else if (tokens[i].equals("*")) {
				int num1 = stack.pop();
				int num2 = stack.pop();

				stack.add(num1 * num2);

			} else if (tokens[i].equals("/")) {
				int num1 = stack.pop();
				int num2 = stack.pop();

				stack.add(num2 / num1);

			} else {
				stack.add(Integer.valueOf(tokens[i]));
			}

		}
		

		return stack.pop();
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

}
