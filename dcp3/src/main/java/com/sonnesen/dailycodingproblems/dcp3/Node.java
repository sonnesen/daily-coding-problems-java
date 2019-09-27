package com.sonnesen.dailycodingproblems.dcp3;

public class Node {

	protected String val;
	protected Node left;
	protected Node right;

	public Node(String val) {
		this.val = val;
	}

	public Node(String val, Node left, Node right) {
		this(val);
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

}
