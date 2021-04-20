package com.burcuozel.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

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

	@Test
	public void test_countOfDeletedChars() {
		assertEquals(1, Medium.countOfDeletedChars("aaaabbbb"));
		assertEquals(6, Medium.countOfDeletedChars("ccaaffddecee"));
		assertEquals(0, Medium.countOfDeletedChars("eee"));
		assertEquals(4, Medium.countOfDeletedChars("example"));
	}

	@Test
	public void test_majorityElement() {
		int[] nums = { 3, 2, 3 };
		List<Integer> expected = List.of(3);
		assertEquals(true, expected.equals(Medium.majorityElement(nums)));

		int[] nums1 = { 1 };
		expected = List.of(1);
		assertEquals(true, expected.equals(Medium.majorityElement(nums1)));

		int[] nums2 = { 1, 2 };
		expected = List.of(1, 2);
		assertEquals(true, expected.equals(Medium.majorityElement(nums2)));

		int[] nums3 = { 2, 1, 1, 3, 1, 4, 5, 6 };
		expected = List.of(1);
		assertEquals(true, expected.equals(Medium.majorityElement(nums3)));
	}

	@Test
	public void test_findAnagrams() {
		assertEquals(3, Medium.findAnagrams("abab", "ab"));
	}

	@Test
	public void test_evalRPN() {
		String[] expression = { "2", "1", "+", "3", "*" };
		assertEquals(9, Medium.evalRPN(expression));

		String[] expression1 = { "4", "13", "5", "/", "+" };
		assertEquals(6, Medium.evalRPN(expression1));

		String[] expression2 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		assertEquals(22, Medium.evalRPN(expression2));

	}

	@Test
	public void test_longestPalindrome() {
		assertEquals("bab", Medium.longestPalindrome("babad"));
	}
}
