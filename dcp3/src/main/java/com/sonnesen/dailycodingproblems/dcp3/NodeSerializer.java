package com.sonnesen.dailycodingproblems.dcp3;

public interface NodeSerializer {

	String serialize(Node node);

	Node deserialize(String data);

}