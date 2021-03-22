package linkedList;

public class DoublyLinkedList {
	private DLLNode head;
	private DLLNode tail;
	private int length;

	public DoublyLinkedList() {
		head = new DLLNode(Integer.MIN_VALUE, null, null);
		tail = new DLLNode(Integer.MIN_VALUE, null, null);
		head.setNext(tail);
		length = 0;
	}

	public int get(int position) {
		return Integer.MIN_VALUE;
	}

	public int getPosition(int data) {
		DLLNode temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data)
				return pos;
			pos++;
			temp = (DLLNode) temp.getNext();
		}
		return Integer.MIN_VALUE;
	}

	public int length() {
		return length;
	}

	// new value to the front of the list
	public void insert(int newValue) {
		DLLNode newNode = new DLLNode(newValue, null, (DLLNode) head.getNext());
		newNode.getNext().setPrev(newNode);
		head = newNode;
		length++;
	}

	public void insert(int data, int position) {
		// fix the position
		if (position < 0)
			position = 0;
		if (position >= length)
			position = length;
		if (head == null) {
			head = new DLLNode(data);
			tail = head;
		} else if (position == 0) {
			insert(data);
		} else {
			DLLNode temp = new DLLNode(data);
			for (int i = 0; i < position; i++) {
				temp = (DLLNode) temp.getNext();
			}
			DLLNode newNode = new DLLNode(data, temp, (DLLNode) temp.getNext());
			newNode.getNext().setPrev(newNode);
			temp.setNext(newNode);
		}
		length++;
	}

	public void insertTail(int newValue) {
		DLLNode newNode = new DLLNode(newValue, (DLLNode) tail.getPrev(), tail);
		newNode.getPrev().setNext(newNode);
		tail.setPrev(newNode);
		length++;
	}
	
	public void remove(int position) {
		if(position < 0) position = 0;
		if(position >= length) position = length - 1;
		if(head == null) return;
		if(position == 0) {
			head = (DLLNode) head.getNext();
			if(head == null) tail = null;
		} else {
			DLLNode temp = head;
			for(int i = 1; i < position; i++) {
				temp = (DLLNode) temp.getNext();
			}
			temp.getNext().setPrev(temp.getPrev());
			temp.getPrev().setNext(temp.getNext());
		}
		length--;
	}
	
	public synchronized void removeMatched(DLLNode node) {
		if(head == null) return;
		
		if(node.equals(head)) {
			remove(0);
		}
		DLLNode temp = head;
		while(temp!=null) {
			temp = (DLLNode) temp.getNext();
			if(node.equals(temp)) {
				temp.getNext().setPrev(temp.getPrev());
				temp.getPrev().setNext(temp.getNext());
				return;
			}
		}
	}
	
	public int removeHead() {
		int save = head.getData();
		if(length==0) return Integer.MIN_VALUE;
		remove(0);
		return save;
	}
	
	public int removeTail() {
		DLLNode save = tail;
		if(length == 0) return Integer.MIN_VALUE;
		tail.setPrev(save.getPrev());
		save.getPrev().setNext(tail);
		length--;
		return save.getData();
	}
	
	public String toString() {
		String result = "[]";
		if(length == 0) return result;
		result = "[" + head.getNext().getData();
		DLLNode temp = (DLLNode) head.getNext().getNext();
		while (temp != null) {
			result += ", " + temp.getData();
			temp = (DLLNode) temp.getNext();
		}
		return result + "]";
	}
	
	public void clearList() {
		head = tail = null;
		length = 0;
	}
}