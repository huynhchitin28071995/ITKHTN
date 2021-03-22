package linkedList;

public class CircularLinkedList {
	protected Node tail;
	protected int length;
	public CircularLinkedList() {
		super();
		this.tail = null;
		this.length = 0;
	}
	
	public void add(int data) {
		addToHead(data);
	}
	
	private void addToHead(int data) {
		CLLNode temp = new CLLNode(data);
		if(tail == null) {
			tail = temp;
			tail.setNext(tail);
		} else {
			temp.setNext(tail.getNext());
			tail.setNext(temp);
		}
		length++;
	}
	
	public void addToTail(int data) {
		addToHead(data);
		tail = (CLLNode) tail.getNext();
	}
	
	public int peek() { //peek head
		return tail.getNext().getData();
	}
	
	public int peekTail() {
		return tail.getData();
	}
	
	public int removeFromHead() {
		Node temp = tail.getNext(); //head
		if (tail == tail.getNext()) {
			tail = null;
		} else {
			tail.setNext(temp.getNext());
			temp.setNext(null);
		}
		length--;
		return temp.getData();
	}
	
	public int removeFromTail() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		Node finger = tail;
		while(finger.getNext() != tail) {
			finger = finger.getNext();
		}
		//finger now points to second-to-last data
		Node temp = tail;
		if(finger == tail) {
			tail = null;
		} else {
			finger.setNext(tail.getNext());
			tail = finger;
		}
		length--;
		return temp.getData();
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public boolean contains(int data) {
		if (tail == null) {
			return false;
		}
		Node finger;
		finger = tail.getNext();
		while(finger != tail && (finger.getData()!=data)) {
			finger = finger.getNext();
		}
		return finger.getData() == data;
	}
	
	public int remove(int data) {
		if(tail == null) return Integer.MIN_VALUE;
		Node finger = tail.getNext();
		Node previous = tail;
		int compares;
		for (compares = 0; compares <= length && finger.getData()!=data; compares++) {
			previous = finger;
			finger = finger.getNext();
		}
		if(finger.getData() == data) {
			if(tail == tail.getNext()) tail = null;
			else {
				if(finger == tail) tail = previous;
				previous.setNext(previous.getNext().getNext());
			}
			finger.setNext(null);
			length--;
			return finger.getData();
		} else {
			return Integer.MIN_VALUE;
		}
	}
	
	public int size() {
		return length;
	}
	
	public int length() {
		return length;
	}
	
	public void clear() {
		length = 0;
		tail = null;
	}
	public String toString() {
		String result = "[]";
		if(length == 0) return result;
		result = "[" + tail.getData();
		Node temp = tail.getNext();
		while (temp != null) {
			result += ", " + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}
}
