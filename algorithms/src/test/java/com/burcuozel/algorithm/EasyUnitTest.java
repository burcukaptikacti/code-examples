package com.burcuozel.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class EasyUnitTest {

	@Test
	public void test_TwoSum() {
		int[] nums = { 2, 7, 11, 15 };

		int[] expectedResult = { 0, 1 };
		assertArrayEquals(expectedResult, Easy.twoSum(nums, 9));
	}
	
	
}