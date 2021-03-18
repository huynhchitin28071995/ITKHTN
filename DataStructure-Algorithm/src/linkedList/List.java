package linkedList;

public class List {
	private ListNode head, tail, pointer; // if there is no pointer, headNode will be altered everytime we iterate the
											// list. Just create a current node.
	private int countNode = 0;

	public List() {
		head = tail = null;
	}

	public int length() {
		return countNode;
	}

	public void addFirst(ListNode listNode) {
		System.out.println(listNode.toString());
		if (countNode == 0) {
			head = listNode;
			tail = listNode;
			tail.setNext(null);
			head.setNext(tail);
		} else {
//			head.setNext(head.getNext());
			listNode.setNext(head);
			head = listNode;
		}
		countNode++;
	}

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public ListNode getTail() {
		return tail;
	}

	public void setTail(ListNode tail) {
		this.tail = tail;
	}

	public int getCountNode() {
		return countNode;
	}

	public void setCountNode(int countNode) {
		this.countNode = countNode;
	}

	public ListNode getPointerAtHead() {
		pointer = head;
		return pointer;
	}

	public ListNode getPointer() {
		return pointer;
	}

	public void setPointer(ListNode pointer) {
		this.pointer = pointer;
	}

	private void setNextPointer() {
		if (pointer.getNext() == null) {
			System.out.println("End of list at setNextPointer()!");
			return;
		}
		System.out.println("Not end of list!");
		this.pointer = pointer.getNext();
	}

	public ListNode getNextPointer() {
		if (pointer == tail) {
			System.out.println("End of list at getNextPointer()!");
			pointer = null; // this will make the next iteration act normally
			return null;
		}
		if (pointer == null) {
			pointer = head;
			return this.pointer; // return this.pointer alone will not move the pointer

		}
//		if (pointer != head) { //this will not move the pointer if pointer == head and will make a loop
		setNextPointer();
//		}
		return this.pointer;
	}
}
