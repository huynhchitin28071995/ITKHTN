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
			temp = temp.getNext();
		}
		return Integer.MIN_VALUE;
	}

	public int length() {
		return length;
	}

	// new value to the front of the list
	public void insert(int newValue) {
		DLLNode newNode = new DLLNode(newValue, null, head.getNext());
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
				temp = temp.getNext();
			}
			DLLNode newNode = new DLLNode(data, temp, temp.getNext());
			newNode.getNext().setPrev(newNode);
			temp.setNext(newNode);
		}
		length++;
	}

	public void insertTail(int newValue) {
		DLLNode newNode = new DLLNode(newValue, tail.getPrev(), tail);
	}
}
