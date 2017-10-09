package com.cache.lru.model;

public class Queue {

	private Node head = null;
	private Node end = null;

	private int size;

	public Queue(int size) {
		this.size = size;
	}

	public synchronized void  setHead(Node node) {
		node.setNext(head);
		node.setPre(null);

		if (head != null) {
			head.setPre(node);
		}

		head = node;

		if (end == null)
			end = head;
	}

	private synchronized void remove(Node node) {
		if (node.getPre() != null) {
			node.getPre().setNext(node.getNext());
		} else {
			head = node.getNext();
		}

		if (node.getNext() != null) {
			node.getNext().setPre(node.getPre());
		} else {
			end = node.getPre();
		}
	}

	public synchronized void moveTofront(Node node) {
		remove(node);
		setHead(node);
	}

	public void removeLast() {
		remove(end);

	}

	public int getLastNodeKey() {
		return end.getKey();
	}

}
