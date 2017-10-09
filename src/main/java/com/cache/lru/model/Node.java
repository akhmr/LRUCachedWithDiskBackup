package com.cache.lru.model;

import java.io.Serializable;

public class Node<T> implements Serializable {

	int key;
	T value;
	Node pre;
	Node next;
	
	public Node(T value) {
		this.value=value;
	}

	public Node(int key, T value) {
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

	public Node getPre() {
		return pre;
	}

	public void setPre(Node pre) {
		this.pre = pre;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + ", pre=" + pre + ", next=" + next + "]";
	}

}
