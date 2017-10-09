package com.cache.lru.core;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cache.lru.core.util.ByteUtil;
import com.cache.lru.model.CacheDiskBackUpStrategy;
import com.cache.lru.model.DoublyNode;

public class LRUBackUpService {
	private CacheDiskBackUpStrategy cacheStrategy;

	private ExecutorService executor;

	private FileService fileService;

	public LRUBackUpService(CacheDiskBackUpStrategy cacheStrategy) {
		this.cacheStrategy = cacheStrategy;
		fileService = new FileService(null);
		executor = Executors.newCachedThreadPool();// defualt
	}

	private boolean writeToDisk(byte[] byteArray, String key) {
		synchronized (key) {
			return fileService.writeBytesToFile(byteArray, key);
		}
	}

	public <T> boolean writeToDiskcAsAsyn(DoublyNode<T> node) {
		executor.submit(() -> {
			try {
				fileService.writeBytesToFile(ByteUtil.objToByte(node), String.valueOf(node.getKey()));
			} catch (Exception ioe) {	
				ioe.printStackTrace();
			}
		});

		return true;

	}

	public boolean persistance(DoublyNode node) throws IOException {
		if (cacheStrategy.equals(CacheDiskBackUpStrategy.Sync)) {
			return writeToDisk(ByteUtil.objToByte(node), String.valueOf(node.getValue()));
		} else {
			return writeToDiskcAsAsyn(node);
		}

	}

}
