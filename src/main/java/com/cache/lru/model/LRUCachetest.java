package com.cache.lru.model;

import java.io.IOException;

import com.cache.lru.core.LRUCache;

public class LRUCachetest {

	public  static int getRandomNumber(int min,int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		LRUCache cache = new LRUCache(30,CacheDiskBackUpStrategy.Sync);
		int array[] = new int[100];
		
		for(int i=0; i< 100; i++){
			array[i]=getRandomNumber(0,100);
			cache.put(i, array[i]);
		}
		
		
		
	
	}

}
