package queue;

import linkedList.ListNode;

public class LinkedQueue {
	private int length;
	private ListNode front, rear;

	public LinkedQueue() {
		length = 0;
		front = rear = null;
	}

	public void enQueue(int data) {
		ListNode node = new ListNode(data);
		if (isEmpty())
			front = node;
		else
			rear.setNext(node);
		rear = node;
		length++;
	}

	public int deQueue() throws Exception {
		if (isEmpty())
			throw new Exception("Empty queue!");
		int result = front.getData();
		front = front.getNext();
		length--;
		if (isEmpty())
			rear = null;
		return result;
	}

	public int first() throws Exception {
		if (isEmpty())
			throw new Exception("Empty queue!");
		return front.getData();
	}

	private boolean isEmpty() {
		return length == 0;
	}

	public int size() {
		return length;
	}

	public String toString() {
		String result = "[";
		ListNode current = front;
		while (current != null) {
			result += current.toString() + "\n";
			current = current.getNext();
		}
		return result;
	}
}
