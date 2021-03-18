package com.burcuozel.algorithm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.burcuozel.algorithm.util.ListNode;

public class MediumUnitTest {

	@Test
	public void test_addTwoNumbers() {
		ListNode l1 = createLinkedListFromArray(new int[] { 2, 4, 3 });
		ListNode l2 = createLinkedListFromArray(new int[] { 5, 6, 4 });

		ListNode expectedList = createLinkedListFromArray(new int[] { 7, 0, 8 });

		assertTrue(compareTwoLinkedList(expectedList, Medium.addTwoNumbers(l1, l2)));

	}

	@Test
	public void test_addTwoNumbersDifferentListSizes() {
		ListNode l1 = createLinkedListFromArray(new int[] { 9, 9, 9, 9, 9, 9, 9 });
		ListNode l2 = createLinkedListFromArray(new int[] { 9, 9, 9, 9 });

		ListNode expectedList = createLinkedListFromArray(new int[] { 8, 9, 9, 9, 0, 0, 0, 1 });

		assertTrue(compareTwoLinkedList(expectedList, Medium.addTwoNumbers(l1, l2)));

	}

	private ListNode createLinkedListFromArray(int[] nums) {
		ListNode resultNode = new ListNode(nums[0]);
		ListNode temp = resultNode;

		for (int i = 1; i < nums.length; i++) {
			temp.next = new ListNode(nums[i]);
			temp = temp.next;
		}

		return resultNode;

	}

	private boolean compareTwoLinkedList(ListNode l1, ListNode l2) {
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
