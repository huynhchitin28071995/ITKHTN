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
		
//		System.out.println("print length " + listLength(list.getHead()));
		System.out.println("print length " + list.getCountNode());
	}
	
	private static int listLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while (currentNode.getNext() != null) {
			System.out.println("asd");
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
}
