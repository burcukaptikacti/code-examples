package com.burcuozel.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.burcuozel.algorithm.util.TreeUtil;

public class EasyUnitTest {

	@Test
	public void test_twoSum() {
		int[] nums = { 2, 7, 11, 15 };

		int[] expectedResult = { 0, 1 };
		assertArrayEquals(expectedResult, Easy.twoSum(nums, 9));
	}

	@Test
	public void test_reverseInteger() {
		assertEquals(321, Easy.reverseInteger(123));
		assertEquals(-321, Easy.reverseInteger(-123));
		assertEquals(21, Easy.reverseInteger(120));
	}

	@Test
	public void test_reverseString() {

		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		char[] expected = { 'o', 'l', 'l', 'e', 'h' };

		Easy.reverseString(s);
		assertArrayEquals(expected, s);
	}

	@Test
	public void test_maxTwoDigitNumberInString() {
		assertEquals(55, Easy.maxTwoDigitNumberInString("50552"));
		assertEquals(10, Easy.maxTwoDigitNumberInString("10101"));
		assertEquals(88, Easy.maxTwoDigitNumberInString("88"));
	}

	@Test
	public void test_maxDepth() {
		Integer[] nums = { 3, 9, 20, null, null, 15, 7 };
		TreeUtil.createTreeFromArray(nums);

	}

	@Test
	public void test_singleNumber() {
		int[] nums = { 4, 1, 2, 1, 2 };
		assertEquals(4, Easy.singleNumber(nums));

		int[] numsSingleElement = { 1 };
		assertEquals(1, Easy.singleNumber(numsSingleElement));

	}

	@Test
	public void test_reverseVowels() {

		assertEquals("holle", Easy.reverseVowels("hello"));
		assertEquals("leotcede", Easy.reverseVowels("leetcode"));
		assertEquals("oA", Easy.reverseVowels("Ao"));
	}

	@Test
	public void test_reverseStr() {
		assertEquals("bacdfeg", Easy.reverseStr("abcdefg", 2));
		assertEquals("bacd", Easy.reverseStr("abcd", 2));
	}

	@Test
	public void test_reverseWords() {
		assertEquals("s'teL ekat edoCteeL tsetnoc", Easy.reverseWords("Let's take LeetCode contest"));
		assertEquals("doG gniD", Easy.reverseWords("God Ding"));
	}

	@Test
	public void test_fizzBuzz() {

		List<String> expected = List.of("1", "2", "Fizz");
		assertEquals(true, expected.equals(Easy.fizzBuzz(3)));

		expected = List.of("1", "2", "Fizz", "4", "Buzz");
		assertEquals(true, expected.equals(Easy.fizzBuzz(5)));

		expected = List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14",
				"FizzBuzz");
		assertEquals(true, expected.equals(Easy.fizzBuzz(15)));

	}

	@Test
	public void test_majorityElement() {
		int[] nums = { 3, 2, 3 };
		assertEquals(3, Easy.majorityElement(nums));

		int[] numsSingleElement = { 2, 2, 1, 1, 1, 2, 2 };
		assertEquals(2, Easy.majorityElement(numsSingleElement));

	}

	@Test
	public void test_moveZeroes() {
		int[] nums = { 0, 1, 0, 3, 12 };

		int[] expectedResult = { 1, 3, 12, 0, 0 };
		Easy.moveZeroes(nums);
		assertArrayEquals(expectedResult, nums);

		int[] nums1 = { 0, 1, 0, 12, 4 };

		int[] expectedResult1 = { 1, 12, 4, 0, 0 };
		Easy.moveZeroes(nums1);
		assertArrayEquals(expectedResult1, nums1);

		int[] nums2 = { 2, 1 };

		int[] expectedResult2 = { 2, 1 };
		Easy.moveZeroes(nums2);
		assertArrayEquals(expectedResult2, nums2);

		int[] nums3 = { 4, 2, 4, 0, 0, 3, 0, 5, 1, 0 };

		int[] expectedResult3 = { 4, 2, 4, 3, 5, 1, 0, 0, 0, 0 };
		Easy.moveZeroes(nums3);
		assertArrayEquals(expectedResult3, nums3);

	}

	@Test
	public void test_removeElement() {

		int[] nums = { 3, 2, 2, 3 };
		assertEquals(2, Easy.removeElement(nums, 3));

		int[] nums1 = { 0, 1, 2, 2, 3, 0, 4, 2 };
		assertEquals(5, Easy.removeElement(nums1, 2));
	}

	@Test
	public void test_containsDuplicate() {

		int[] nums = { 1, 2, 3, 1 };
		assertEquals(true, Easy.containsDuplicate(nums));

		int[] nums1 = { 1, 2, 3, 4 };
		assertEquals(false, Easy.containsDuplicate(nums1));

		int[] nums2 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		assertEquals(true, Easy.containsDuplicate(nums2));
	}

	@Test
	public void test_isAnagram() {
		assertEquals(false, Easy.isAnagram("a", "b"));
		assertEquals(false, Easy.isAnagram("rat", "car"));
		assertEquals(true, Easy.isAnagram("anagram", "nagaram"));

	}

	@Test
	public void test_maxProfit() {

		int[] days = { 7, 1, 5, 3, 6, 4 };
		assertEquals(5, Easy.maxProfit(days));

		int[] days1 = { 7, 6, 4, 3, 1 };
		assertEquals(0, Easy.maxProfit(days1));

	}

	@Test
	public void test_getRowOfTriangle() {

		List<Integer> expected = List.of(1, 3, 3, 1);

		assertTrue(expected.equals(Easy.getRowOfTriangle(3)));

	}

	@Test
	public void test_isPalindrome() {
		assertTrue(Easy.isPalindrome(121));
		assertTrue(Easy.isPalindrome(1221));
		assertFalse(Easy.isPalindrome(10));
		assertFalse(Easy.isPalindrome(-121));
	}

	@Test
	public void test_isPalindrome2() {
		assertTrue(Easy.isPalindrome2(121));
		assertTrue(Easy.isPalindrome2(1221));
		assertFalse(Easy.isPalindrome2(10));
		assertFalse(Easy.isPalindrome2(-121));
	}
}