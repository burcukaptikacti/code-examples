package com.burcuozel.algorithm;

import java.util.HashSet;

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

}
