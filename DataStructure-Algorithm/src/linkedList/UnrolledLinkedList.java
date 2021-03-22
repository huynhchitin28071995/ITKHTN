package linkedList;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;

public class UnrolledLinkedList<E> extends AbstractList<E> implements java.util.List<E>, Serializable {
	
	private int nodeCapacity;
	private int size;
	private ListNode firstNode, lastNode;
	
	public UnrolledLinkedList(int nodeCapacity) {
		if(nodeCapacity < 8) throw new IllegalArgumentException("nodeCapacity < 8");
		this.nodeCapacity = nodeCapacity;
		firstNode = new ListNode();
		lastNode = firstNode;
	}
	
	public UnrolledLinkedList() {
		this(16);
	}
	

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}
	
	public Iterator<E> iterator() {
		return new ULLIterator(firstNode, 0, 0);
	}
	
	public boolean add(E e) {
		insertIntoNode(lastNode, lastNode.numElements, e);
	}
	
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

}
