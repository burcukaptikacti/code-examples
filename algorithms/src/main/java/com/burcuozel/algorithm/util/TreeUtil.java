package com.burcuozel.algorithm.util;

import com.burcuozel.algorithm.model.TreeNode;

public class TreeUtil {

	public static TreeNode createTreeFromArray(Integer[] nums) {

		if (nums.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(nums[0]);
		int i = 0;

		getTreeNode(root, nums, (i * 2) + 1, (i * 2) + 2);

		printTree(root);

		return root;
	}

	private static void getTreeNode(TreeNode root, Integer[] nums, int leftIndex, int rightIndex) {
		if (leftIndex >= nums.length)
			return;

		if (nums[leftIndex] != null) {
			root.left = new TreeNode(nums[leftIndex]);
			getTreeNode(root.left, nums, (leftIndex * 2) + 1, (leftIndex * 2) + 2);
		}

		if (rightIndex >= nums.length)
			return;

		if (nums[rightIndex] != null) {
			root.left = new TreeNode(nums[rightIndex]);
			getTreeNode(root.left, nums, (rightIndex * 2) + 1, (rightIndex * 2) + 2);
		}

		return;
	}

	public static void printTree(TreeNode node) {
		if (node == null) {
			return;
		}

		StringBuilder builder = new StringBuilder(node.val);
		printTreeChildren(node.left, builder);
		printTreeChildren(node.right, builder);
		
		System.out.println(builder.toString());

	}

	public static void printTreeChildren(TreeNode node, StringBuilder builder) {
		if (node == null) {
			return;
		}
		builder.append("\n");
		builder.append("-");
		builder.append(node.val);
		printTreeChildren(node.left, builder);
		printTreeChildren(node.right, builder);
	}

}
