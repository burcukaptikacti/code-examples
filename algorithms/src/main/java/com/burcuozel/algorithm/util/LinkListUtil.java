package com.burcuozel.algorithm.util;

import com.burcuozel.algorithm.model.ListNode;

public class LinkListUtil {

	public static ListNode createLinkedListFromArray(int[] nums) {
		ListNode resultNode = new ListNode(nums[0]);
		ListNode temp = resultNode;

		for (int i = 1; i < nums.length; i++) {
			temp.next = new ListNode(nums[i]);
			temp = temp.next;
		}

		return resultNode;

	}

	public static boolean compareTwoLinkedList(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return true;

		if (l1 == null || l2 == null)
			return false;

		while (l1 != null && l2 != null) {
			if (l1.val != l2.val)
				return false;

			l1 = l1.next;
			l2 = l2.next;

		}

		return (l1 == null && l2 == null);
	}

}
