package com.sonnesen.dailycodingproblems.dcp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeTest {

	private Tree tree;

	@BeforeEach
	void setUp() throws Exception {
		tree = new Tree();
	}
	
	@Test
	void testSerializeWithOneBranch() {
		Node root = new TreeNodeBuilder().whithChildren("root left L").build();
		String data = tree.serialize(root);
		assertTrue("left root".equals(data));
	}

	@Test
	void testDeserializeWithOneBranch() {
		Node root = new TreeNodeBuilder().whithChildren("root left L").build();
		String data = tree.serialize(root);
		Node node = tree.deserialize(data);
		assertTrue("left".equals(node.left.val));
		assertNull(node.right);
	}

	@Test
	void testSerializeWithTwoBranches() {
		Node root = new TreeNodeBuilder().whithChildren("root left L root right R").build();
		String data = tree.serialize(root);
		assertTrue("left root right".equals(data));
	}

	@Test
	void testDeserializeWithTwoBranches() {
		Node root = new TreeNodeBuilder().whithChildren("root left L root right R").build();
		String data = tree.serialize(root);
		Node node = tree.deserialize(data);
		assertTrue("left".equals(node.left.val));
		assertTrue("right".equals(node.right.val));
	}

	@Test
	void testSerializeWithThreeBranches() {
		Node root = new TreeNodeBuilder().whithChildren("root left L left left.right R root right R").build();
		String data = tree.serialize(root);
		assertTrue("left left.right root right".equals(data));
	}

	@Test
	void testDeserializeWithThreeBranches() {
		Node root = new TreeNodeBuilder().whithChildren("root left L left left.right R root right R").build();
		String data = tree.serialize(root);
		Node node = tree.deserialize(data);
		assertTrue("left.right".equals(node.left.right.val));
	}

	@Test
	void testSerializeWithFourBranches() {
		Node root = new TreeNodeBuilder().whithChildren("root left L left left.left L left left.right R root right R")
				.build();
		String data = tree.serialize(root);
		assertTrue("left.left left left.right root right".equals(data));
	}

	@Test
	void testDeserializeWithFourBranches() {
		Node root = new TreeNodeBuilder().whithChildren("root left L left left.left L left left.right R root right R")
				.build();
		String data = tree.serialize(root);
		Node node = tree.deserialize(data);
		assertTrue("left.left".equals(node.left.left.val));
	}

}
