package com.sonnesen.dailycodingproblems.dcp3;

import java.util.Stack;

/**
 * Solution from
 * https://www.programcreek.com/2014/05/leetcode-serialize-and-deserialize-binary-tree-java/
 */
public class NodeSerializerPreOrder implements NodeSerializer {

	public String serialize(Node node) {
		if (node == null)
			return null;

		Stack<Node> stack = new Stack<>();
		stack.push(node);

		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {
			Node branch = stack.pop();
			if (branch != null) {
				sb.append(branch.val + ",");
				stack.push(branch.right);
				stack.push(branch.left);
			} else {
				sb.append("#,");
			}
		}

		return sb.toString().substring(0, sb.length() - 1);
	}

	public Node deserialize(String data) {
		if (data == null)
			return null;

		int[] t = { 0 };
		String[] arr = data.split(",");

		return helper(arr, t);
	}

	private Node helper(String[] arr, int[] t) {
		if (arr[t[0]].equals("#"))
			return null;

		Node node = new Node(arr[t[0]]);
		t[0]++;
		node.left = helper(arr, t);
		t[0]++;
		node.right = helper(arr, t);

		return node;
	}
}
