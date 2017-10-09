package com.cache.lru.core;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cache.lru.model.CacheDiskBackUpStrategy;
import com.cache.lru.model.DoubleLinkedListNode;
import com.cache.lru.model.Queue;

public class LRUCache {
	private int size;
	private Map<Integer, DoubleLinkedListNode> map = new ConcurrentHashMap<Integer, DoubleLinkedListNode>();
	private Queue queue;
	private LRUBackUpService lruBackUpService;
	private CacheDiskBackUpStrategy cacheStrategy;

	public LRUCache(int size, CacheDiskBackUpStrategy cacheStrategy) {
		this.size = size;
		queue = new Queue(size);
		this.cacheStrategy = cacheStrategy;
		lruBackUpService = new LRUBackUpService(cacheStrategy);
	}

	public <T> T get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode n = map.get(key);
			queue.moveTofront(n);
			return (T) n.getValue();
		}

		return null;
	}

	public <T> void put(int key, T value) throws IOException {
		if (map.containsKey(key)) {
			DoubleLinkedListNode old = map.get(key);
			old.setValue(value);
			queue.moveTofront(old);
		} else {
			DoubleLinkedListNode created = new DoubleLinkedListNode(key, value);
			if (map.size() >= size) {
				map.remove(queue.getLastNodeKey());
				queue.removeLast();

			}
			lruBackUpService.persistance(created);
			queue.setHead(created);

			map.put(key, created);
		}
	}

}
