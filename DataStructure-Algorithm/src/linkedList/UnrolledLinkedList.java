package linkedList;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

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
		return true;
	}
	
	private void insertIntoNode(ListNode node, int ptr, E element) {
		//if node is full, create a new node
		if(node.numElements == nodeCapacity) {
			ListNode newNode = new ListNode();
			//move 1/2 of the elements to new node
			int elementsToMove = nodeCapacity/2;
			int startIndex = nodeCapacity - elementsToMove;
			for(int i = 0; i < elementsToMove; i++) {
				newNode.elements[i] = node.elements[startIndex + i];
				node.elements[startIndex+1] = null;
			}
			node.numElements-=elementsToMove;
		}
	}

	public boolean remove(Object o) {
		int index = 0;
		ListNode node = firstNode;
		if (o == null) {
			while (node != null) {
				for (int ptr = 0; ptr < node.numElements; ptr++) {
					if (Objects.isNull(node.elements[ptr])) {						
						removeFromNode(node, ptr);
						return true;
					}
				}
				index += node.numElements;
				node = node.next;
			}
		} else {
			while (node!=null) {
				while (node != null) {
					for (int ptr = 0; ptr < node.numElements; ptr++) {
						if (o.equals(node.elements[ptr])) {
							removeFromNode(node, ptr);
							return true;
						}
					}
					index += node.numElements;
					node = node.next;
			}
		}
	}
		return false;
	}	
	
	private void removeFromNode(ListNode node, int ptr) {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		ListNode node = firstNode.next;
		while (node!= null) {
			ListNode next = node.next;
			node.next = null;
			node.previous = null;
			node.elements = null;
			node = next;
		}
		lastNode = firstNode;
		for(int ptr = 0; ptr < firstNode.numElements; ptr++) {
			firstNode.elements[ptr] = null;
		}
		firstNode.numElements = 0;
		firstNode.next = null;
		size = 0;
	}
		
	@Override
	public E get(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		ListNode node;
		int p = 0;
		if(size-index>index) {
			node = firstNode;
			while (p<=index-node.numElements) {
				p += node.numElements;
				node = node.next;
			}
		} else {
			node = lastNode;
			p = size;
			while((p -= node.numElements) > index) {
				node = node.previous;
			}
		}
		return (E)node.elements[index-p];
	} 
	
	public E set (int index, E element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E el = null;
		ListNode node;
		int p = 0;
		if(size - index > index) {
			node = firstNode;
			while(p<=index-node.numElements) {
				p+=node.numElements;
				node = node.next;
			}
		} else {
			node = lastNode;
			p = size;
			while((p-=node.numElements)>index) 
				node = node.previous;
			
		}
		el = (E)(Integer)node.elements[index-p];
		node.elements[index-p] = (int) element;
		return el;
	}
	
	public void add(int index, E element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E el = null;
		ListNode node;
		int p = 0;
		if(size - index > index) {
			node = firstNode;
			while(p<=index-node.numElements) {
				p+=node.numElements;
				node = node.next;
			}
		} else {
			node = lastNode;
			p = size;
			while((p-=node.numElements)>index) 
				node = node.previous;
			
		}
		insertIntoNode(node, index - p, element);
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E el = null;
		ListNode node;
		int p = 0;
		if(size - index > index) {
			node = firstNode;
			while(p<=index-node.numElements) {
				p+=node.numElements;
				node = node.next;
			}
		} else {
			node = lastNode;
			p = size;
			while((p-=node.numElements)>index) 
				node = node.previous;
			
		}
		el = (E)(Integer)node.elements[index-p];
		removeFromNode(node, index - p);
		return el;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	private static final long serialVersionUID = -674052309103045211L;
	private class ListNode {
		ListNode next, previous;
		int numElements = 0;
		Object[] elements;
		ListNode(){
			elements = new Object[nodeCapacity];
		}
	}
	
	private class ULLIterator implements ListIterator<E>{
		ListNode currentNode;
		int ptr;
		int index;
		private int expectedModCount = modCount;
		
		public ULLIterator(UnrolledLinkedList<E>.ListNode currentNode, int ptr, int index) {
			this.currentNode = currentNode;
			this.ptr = ptr;
			this.index = index;
		}

		@Override
		public boolean hasNext() {
			return index < size - 1;
		}

		@Override
		public E next() {
			ptr++;
			if(ptr>=currentNode.numElements) {
				if(currentNode.next != null) {
					currentNode = currentNode.next;
					ptr = 0;
				} else {
					throw new NoSuchElementException();
				}
			}
			index++;
			checkForModification();
			return (E)currentNode.elements[ptr];
		}

		@Override
		public boolean hasPrevious() {
			return index > 0;
		}

		@Override
		public E previous() {
			ptr--;
			if(ptr<0) {
				if(currentNode.previous != null) {
					currentNode = currentNode.previous;
					ptr = currentNode.numElements - 1;
				} else {
					throw new NoSuchElementException();
				}
			}
			index--;
			checkForModification();
			return (E)currentNode.elements[ptr];
		}

		@Override
		public int nextIndex() {
			return index + 1;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return index - 1;
		}

		@Override
		public void remove() {
			checkForModification();
			removeFromNode(currentNode, ptr);
		}

		private void checkForModification() {
			if(modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
		}

		@Override
		public void set(E e) {
			checkForModification();
			insertIntoNode(currentNode, ptr + 1, e);
		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
