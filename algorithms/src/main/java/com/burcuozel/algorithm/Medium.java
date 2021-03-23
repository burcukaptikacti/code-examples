package com.burcuozel.algorithm;

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

		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			int tempLength = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					break;
				}
				tempLength++;
			}
			length = Math.max(length, tempLength);
		}
		return length;

	}

}
