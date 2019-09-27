package com.sonnesen.dailycodingproblems.dcp3;

import java.util.HashMap;
import java.util.Map;

public class Tree {

	private StringBuilder sb;

	public Tree() {
		this.sb = new StringBuilder();
	}

	public String serialize(Node root) {
		if (root.left != null)
			serialize(root.left);
		sb.append(root.val).append(" ");
		if (root.right != null)
			serialize(root.right);
		return sb.toString().trim();
	}

	public Node deserialize(String data) {
		String[] tokens = data.split(" ");
		Map<String, Node> map = new HashMap<>();

		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			Node node = map.get(token);
			if (node == null) {
				node = new Node(token);

				String parent = "root";
				String branch = token;

				int lastIndexOf = token.lastIndexOf('.');

				if (lastIndexOf > 0) {
					parent = token.substring(0, lastIndexOf);
					branch = token.substring(lastIndexOf + 1);
				}

				Node parentNode = map.get(parent);
				if (parentNode == null) {
					parentNode = new Node(parent);
					map.put(parent, parentNode);
				}

				if ("left".equals(branch))
					parentNode.left = node;
				else
					parentNode.right = node;

				map.put(token, node);
			}
		}

		Node root = map.get("root");
		root.left = map.get("left");
		root.right = map.get("right");

		return root;
	}

}
