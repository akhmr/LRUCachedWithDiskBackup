package com.cache.lru.model;

import java.io.Serializable;


public class DoubleLinkedListNode<T> implements Serializable {

	private int key;
	private T value;
	private transient DoubleLinkedListNode pre;
	private transient DoubleLinkedListNode next;
	
	public DoubleLinkedListNode(T value) {
		this.value=value;
	}

	public DoubleLinkedListNode(int key, T value) {
		this.key=key;
		this.value=value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public DoubleLinkedListNode getPre() {
		return pre;
	}

	public void setPre(DoubleLinkedListNode pre) {
		this.pre = pre;
	}

	public DoubleLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoubleLinkedListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + ", pre=" + pre + ", next=" + next + "]";
	}

}
