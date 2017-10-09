package com.cache.lru.core;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cache.lru.core.util.ByteUtil;
import com.cache.lru.model.CacheDiskBackUpStrategy;
import com.cache.lru.model.CustomRunnable;
import com.cache.lru.model.DoubleLinkedListNode;

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

	public <T> boolean writeToDiskcAsAsyn(DoubleLinkedListNode<T> node) {
		try {
			CustomRunnable customRunnable = new CustomRunnable(node, fileService);
			executor.submit(customRunnable);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean persistance(DoubleLinkedListNode node) throws IOException {
		if (cacheStrategy.equals(CacheDiskBackUpStrategy.Sync)) {
			return writeToDisk(ByteUtil.objToByte(node), String.valueOf(node.getValue()));
		} else {
			return writeToDiskcAsAsyn(node);
		}

	}

}
