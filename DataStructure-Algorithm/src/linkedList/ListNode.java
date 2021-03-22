package linkedList;

public class ListNode {
	private int data;
	private ListNode next;

	public ListNode(int data) {
		super();
		this.data = data;
	}

	public ListNode() {
		// TODO Auto-generated constructor stub
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "list node: data = " + this.data;
	}
}
