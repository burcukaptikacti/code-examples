package com.burcuozel.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class HardUnitTest {

	@Test
	public void test_minimalCostOfDividingChains() {

		int[] A = { 5, 2, 4, 6, 3, 7 };

		assertEquals(5, Hard.minimalCostOfDividingChains(A));
	}

	@Test
	public void test_findMedianSortedArrays() {

		int[] A = { 1, 2 };
		int[] B = { 3, 4 };

		assertTrue(2.5 == Hard.findMedianSortedArrays(A, B));
	}

}
