package com.sonnesen.dailycodingproblems.dcp3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeSerializerLevelOrderTest {

	private NodeSerializer serializer;

	@BeforeEach
	void setUp() throws Exception {
		serializer = new NodeSerializerLevelOrder();
	}

	@Test
	void test() {
		Node node = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
		assertTrue("left.left".equals(serializer.deserialize(serializer.serialize(node)).left.left.val));
	}

}
