package com.burcuozel.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.burcuozel.algorithm.model.ListNode;
import com.burcuozel.algorithm.util.LinkListUtil;

public class MediumUnitTest {

	@Test
	public void test_addTwoNumbers() {
		ListNode l1 = LinkListUtil.createLinkedListFromArray(new int[] { 2, 4, 3 });
		ListNode l2 = LinkListUtil.createLinkedListFromArray(new int[] { 5, 6, 4 });

		ListNode expectedList = LinkListUtil.createLinkedListFromArray(new int[] { 7, 0, 8 });

		assertTrue(LinkListUtil.compareTwoLinkedList(expectedList, Medium.addTwoNumbers(l1, l2)));

	}

	@Test
	public void test_addTwoNumbersDifferentListSizes() {
		ListNode l1 = LinkListUtil.createLinkedListFromArray(new int[] { 9, 9, 9, 9, 9, 9, 9 });
		ListNode l2 = LinkListUtil.createLinkedListFromArray(new int[] { 9, 9, 9, 9 });

		ListNode expectedList = LinkListUtil.createLinkedListFromArray(new int[] { 8, 9, 9, 9, 0, 0, 0, 1 });

		assertTrue(LinkListUtil.compareTwoLinkedList(expectedList, Medium.addTwoNumbers(l1, l2)));
	}

	@Test
	public void test_lengthOfLongestSubstring() {
		assertEquals(3, Medium.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, Medium.lengthOfLongestSubstring("bbbbb"));
		assertEquals(0, Medium.lengthOfLongestSubstring(""));
	}

}
