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

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1.length == 0 && nums2.length == 0) {
			return 0;
		}

		int[] totalArray = new int[nums1.length + nums2.length];

		int i = 0;

		int indexOf1 = 0;
		int indexOf2 = 0;

		while (i < totalArray.length) {

			int num1 = indexOf1 < nums1.length ? nums1[indexOf1] : Integer.MAX_VALUE;
			int num2 = indexOf2 < nums2.length ? nums2[indexOf2] : Integer.MAX_VALUE;

			totalArray[i] = Math.min(num1, num2);

			if (num1 < num2) {
				indexOf1++;
			} else {
				indexOf2++;
			}
			i++;
		}

		if (totalArray.length % 2 == 0) {
			System.out.println((totalArray[(totalArray.length / 2) - 1] + totalArray[(totalArray.length / 2)]) / 2);

			return ((double) (totalArray[(totalArray.length / 2) - 1] + totalArray[(totalArray.length / 2)])) / 2;
		} else {
			return totalArray[totalArray.length / 2];
		}

	}
}
