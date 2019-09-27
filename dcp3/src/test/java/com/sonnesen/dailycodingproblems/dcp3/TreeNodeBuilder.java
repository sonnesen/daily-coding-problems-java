package com.sonnesen.dailycodingproblems.dcp3;

import java.util.HashMap;
import java.util.Map;

public class TreeNodeBuilder {

	private Node root;
	
	public TreeNodeBuilder() {
	}
	
	public TreeNodeBuilder whithChildren(String children) {
		String[] tokens = children.split(" ");

		Map<String, Node> map = new HashMap<>();

		for (int i = 0; i < tokens.length; i = i + 3) {
			String n1 = tokens[i];
			String n2 = tokens[i + 1];
			char lr = tokens[i + 2].charAt(0);

			Node parent = map.get(n1);
			if (parent == null) {
				parent = new Node(n1);
				map.put(n1, parent);
				if (root == null)
					root = parent;
			}

			Node child = new Node(n2);
			if (lr == 'L')
				parent.left = child;
			else
				parent.right = child;

			map.put(n2, child);
		}

		return this;
	}

	public Node build() {
		return root;
	}

}
