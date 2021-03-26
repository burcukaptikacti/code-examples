package com.burcuozel.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
	public void test_reverseIntegersss() {
		assertEquals(1, Easy.minimumCharDeleteCount("aaaabbbb"));
		assertEquals(6, Easy.minimumCharDeleteCount("ccaaffddecee"));
		assertEquals(0, Easy.minimumCharDeleteCount("eee"));
		assertEquals(4, Easy.minimumCharDeleteCount("example"));
	}

}