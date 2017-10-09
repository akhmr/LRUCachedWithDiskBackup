package com.cache.lru.model;

import java.io.IOException;

import com.cache.lru.core.util.ByteUtil;

public class LRUCachetest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String str = "abc";
		Node node = new Node(1, str);
		System.out.println("Node1 " + node.toString());

		byte[] objBytes = ByteUtil.objToByte(node);

		Node node2 = (Node) ByteUtil.byteToObj(objBytes);
		System.out.println("Node 2" + node2.toString());
		;
	}

}
