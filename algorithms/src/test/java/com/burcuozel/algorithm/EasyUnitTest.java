package com.burcuozel.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
}