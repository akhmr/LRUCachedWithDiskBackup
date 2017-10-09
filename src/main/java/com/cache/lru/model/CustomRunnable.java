package com.cache.lru.model;

import java.io.IOException;

import com.cache.lru.core.FileService;
import com.cache.lru.core.util.ByteUtil;

public class CustomRunnable<T> implements Runnable {

	private DoublyNode<T> node;

	private FileService fileService;

	public CustomRunnable(DoublyNode<T> node, FileService fileService) {
		this.node = node;
		this.fileService = fileService;
	}

	public void run() {
		try {
			fileService.writeBytesToFile(ByteUtil.objToByte(node), String.valueOf(node.getKey()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
