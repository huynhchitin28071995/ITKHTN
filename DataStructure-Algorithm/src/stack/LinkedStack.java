package stack;

import java.util.EmptyStackException;

import linkedList.ListNode;

public class LinkedStack extends Stack {
	private int length;
	private ListNode top;

	public LinkedStack() {
		length = 0;
		top = null;
	}

	@Override
	public void push(int data) throws Exception {
		ListNode temp = new ListNode(data);
		temp.setNext(top);// points to the old top
		top = temp;
		length++;
	}

	public int peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getData();
	}

	@Override
	public int pop() throws Exception {
		int data = peek();
		top = top.getNext();
		length--;
		return data;
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public int size() {
		return length;
	}

	public String toString() {
		String s = "";
		ListNode current = top;
		while (current != null) {
			s += current.toString() + "\n";
			current = current.getNext();
		}
		return s;
	}
}
