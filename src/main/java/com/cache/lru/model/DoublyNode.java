package com.cache.lru.model;

import java.io.Serializable;


public class DoublyNode<T> implements Serializable {

	private int key;
	private T value;
	private transient DoublyNode pre;
	private transient DoublyNode next;
	
	public DoublyNode(T value) {
		this.value=value;
	}

	public DoublyNode(int key, T value) {
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

	public DoublyNode getPre() {
		return pre;
	}

	public void setPre(DoublyNode pre) {
		this.pre = pre;
	}

	public DoublyNode getNext() {
		return next;
	}

	public void setNext(DoublyNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + ", pre=" + pre + ", next=" + next + "]";
	}

}
