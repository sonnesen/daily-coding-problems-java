package com.sonnesen.dailycodingproblems.dcp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution from
 * https://www.programcreek.com/2014/05/leetcode-serialize-and-deserialize-binary-tree-java/
 */
public class NodeSerializerLevelOrder implements NodeSerializer {

	@Override
	public String serialize(Node node) {
		List<String> result = new ArrayList<>();
		serializeHelper(node, result);
		return result.toString();
	}

	private void serializeHelper(Node node, List<String> result) {
		if (node == null) {
			result.add(null);
			return;
		}

		result.add(node.val);
		serializeHelper(node.left, result);
		serializeHelper(node.right, result);
	}

	@Override
	public Node deserialize(String data) {
		String[] tokens = data.substring(1, data.length() - 1).split(", ");
		Deque<String> list = new LinkedList<>(Arrays.asList(tokens));
		return deserializeHelper(list);
	}

	private Node deserializeHelper(Deque<String> list) {
		if (list.isEmpty())
			return null;
		String str = list.pop();
		if (str.equals("null"))
			return null;
		Node currentNode = new Node(str);
		currentNode.left = deserializeHelper(list);
		currentNode.right = deserializeHelper(list);
		return currentNode;
	}

}
