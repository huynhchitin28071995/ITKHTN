package linkedList;
//instructed
public class LinkedList {
	private int length;
	private ListNode head;
	public LinkedList() {
		length = 0;
	}
	public synchronized ListNode getHead() {
		return head;
	}
	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}
	public synchronized void insertAtEnd(ListNode node) {
		if (head == null) {
			head = node;
		} else {
			ListNode p, q;
			for (p = head; (q = p.getNext()) != null ; p = q);
			p.setNext(node);
		}
		length++;		
	}
	
	public void insert(int data, int position) {
		if (position < 0) {
			position = 0;
		}
		if(position > length) {
			position = length;
		}
		if(head == null) {
			head = new ListNode(data);
		} else if(position == 0) {
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head = temp;
		} else {
			ListNode temp = head;
			for (int i = 1; i < position; i++) {
				temp = temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
		length++;
	}
}
