package com.cache.lru;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cache.lru.core.LRUCache;
import com.cache.lru.model.CacheDiskBackUpStrategy;

public class TestLrCache {

	
	
	
	public  static int getRandomNumber(int min,int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
	@Test()
	public void testPutMethoed() throws IOException{
		LRUCache cache = new LRUCache(30,CacheDiskBackUpStrategy.Sync);
		int array[] = new int[100];
		
		for(int i=0; i< 100; i++){
			array[i]=getRandomNumber(0,100);
			cache.put(i, array[i]);
			System.out.println(""+cache.get(i));
			Assert.assertEquals((int)array[i], (int)cache.get(i));
			//System.out.println(cache.get(i));
			//Assert.assertEquals(array[i], cache.get(i));

		}
		
		
		
	}
}
