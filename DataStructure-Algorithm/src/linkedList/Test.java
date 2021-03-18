package linkedList;

public class Test {
	public static void main(String[] args) {
		List list = new List();
		for (int i = 0; i < 10; i++) {
			list.addFirst(new ListNode(i));
		}
		System.out.println("head node: " + list.getHead().getData());
		while (list.getNextPointer() != null) {
			System.out.println("Traversing: " + list.getPointer().getData());
		}
		while (list.getNextPointer() != null) {
			System.out.println("Traversing: " + list.getPointer().getData());
		}
	}

}
