package com.burcuozel.algorithm;

public class Hard {

	public static int minimalCostOfDividingChains(int[] A) {

		int startIndex = 1;
		int endIndex = A.length - 2;

		int weakest = Integer.MAX_VALUE;
		while (startIndex < endIndex - 1) {

			weakest = Math.min(weakest, A[startIndex] + A[endIndex]);

			if (A[startIndex] < A[endIndex]) {
				endIndex--;
			} else {
				startIndex++;
			}
		}

		return weakest;
	}
}
