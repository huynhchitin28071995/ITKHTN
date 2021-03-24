package linkedList;

import java.util.Hashtable;

public class Problems {
	// find the n-th node from the end of the linked list
	private static void problem2(LinkedList list, int n) {
		ListNode curNode = list.getHead();

		while (curNode != null) {
//			System.out.println("count(curNode) = " + count(curNode));
			if (count(curNode) < n - 1) {
				System.out.println("Fewer number of nodes in the list.");
				return;
			} else if (count(curNode) > n - 1) {
				curNode = curNode.getNext();
			} else {
				System.out.println(n + "-th value from the end of the list = " + curNode.getData());
				return;
			}
		}

	}

	private static void problem3(LinkedList list, int n) {
		if (n < 1)
			return;

		Hashtable<Integer, ListNode> ht = new Hashtable<>();
		ListNode curNode = list.getHead();
		int pos = 0;
		int count = 0;
		while (curNode != null) {
			ht.put(++pos, curNode);
			count++;
			curNode = curNode.getNext();
		}
		if (n > count) {
			System.out.println("Fewer number of nodes in the list.");
			return;
		}
		System.out.println(n + "-th value from the end of the list = " + ht.get(count - n + 1));
	}

	private static void problem4(LinkedList list, int n) {
		if (n < 1)
			return;

		ListNode curNode = list.getHead();
		int count = 0;
		while (curNode != null) {
			curNode = curNode.getNext();
			count++;
		}
		if (n > count) {
			System.out.println("Fewer number of nodes in the list.");
			return;
		}
		int pos = count - n + 1;
		curNode = list.getHead();
		for (int i = 1; i < pos; i++) {
			curNode = curNode.getNext();
		}
		System.out.println(n + "-th value from the end of the list = " + curNode.getData());
	}

	private static void problem5(LinkedList list, int n) { // solve with 1 scan
		if (n < 1)
			return;
//		ListNode pNthNode = null;
		ListNode pNthNode = list.getHead();
		ListNode pTemp = list.getHead();
		for (int i = 0; i < n; i++) {
			if (pTemp == null)
				return;
			pTemp = pTemp.getNext();
		}
		while (pTemp != null) {
			pTemp = pTemp.getNext();
//			pNthNode = (pNthNode == null ? list.getHead() : pNthNode.getNext());
			pNthNode = pNthNode.getNext();
		}
		if (pNthNode != null)
			System.out.println(n + "-th value from the end of the list = " + pNthNode.getData());
	}

	private static int count = 0;

	private static void problem6(ListNode head, int n) { // solve problem 5 with recursion
		if (n < 1)
			return;
//		if (head == null) {
//			System.out.println("Fewer number of nodes in the list.");
//			return;
//		}
		if (head != null) { // always run until head == null
			problem6(head.getNext(), n);
			count++;
			if (n == count) {
				System.out.println(n + "-th value from the end of the list = " + head.getData());
				return;
			}
		}

	}

	private static void problem7(LinkedList list) { // check linked list is null terminated or cyclic - self-solved
		ListNode curNode = list.getHead();
		while (curNode != null) {
			curNode = curNode.getNext();
			if (curNode == list.getHead()) {
				System.out.println("This linked list is cyclic!");
				return;
			}
		}
		System.out.println("This linked list is null-terminated!");
	}

	private static boolean problem7a(ListNode node, int listSize) { // find other nodes that has the same next pointer
		if (node == null)
			return false;
		ListNode temp = node.getNext();
		int count = 0;
		while (temp != null && count < listSize) { // the problem appears when this while loop is in a loop of nodes.
			if (temp.equals(node)) {
				System.out.println("This linked list is cyclic!");
				return true;
			}
			temp = temp.getNext();
			count++;
		}
		return problem7a(node.getNext(), listSize);
	}

	private static boolean problem8(LinkedList list) {
		ListNode curNode = list.getHead();
		Hashtable<Integer, ListNode> ht = new Hashtable<>();
		int counter = 0;
		while (curNode != null) {
			if (ht.containsValue(curNode))
				return true;
			else {
				ht.put(counter, curNode);
			}
			counter++;
			curNode = curNode.getNext();
		}
		return false;
	}

	private static void problem10(LinkedList list) {
		ListNode slowPtr = list.getHead(), fastPtr = list.getHead().getNext();
		while (fastPtr != null && fastPtr.getNext() != null) {
			if (slowPtr.equals(fastPtr)) {
				System.out.println("This list is cyclic!");
				return;
			}
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		System.out.println("This list is non-cyclic");
	}

	private static boolean problem11(ListNode head, int listSize) {
		if (head == null)
			return false;
		ListNode node = head.getNext();
		count = 0;
		while (node != null && count <= listSize) {
			if (node.equals(head))
				return true;
			node = node.getNext();
			count++;
		}
		return problem11(head.getNext(), listSize);
	}

	private static int count(ListNode curNode) {
		int count = 0;
//		ListNode temp = curNode.getNext();
		while (curNode.getNext() != null) {
			curNode = curNode.getNext();
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		for (int i = 0; i < 10; i++) {
			ll.insertAtBegin(new ListNode(i));
		}
		ListNode node = ll.getHead();
		ListNode temp = node;
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
			if (node != null) {
				temp = node;
			}
		}
//		for (int i = 0; i < 10; i++) {
//			problem2(ll, i);
//		}
//		problem2(ll, 10);
//		problem2(ll, 11);
//		problem2(ll, 13);
//
//		for (int i = 0; i < 10; i++) {
//			problem3(ll, i);
//		}
//		problem3(ll, 10);
//		problem3(ll, 11);
//		problem3(ll, 13);
//
//		for (int i = 0; i < 10; i++) {
//			problem4(ll, i);
//		}
//		problem4(ll, 10);
//		problem4(ll, 11);
//		problem4(ll, 13);

//		for (int i = 0; i < 10; i++) {
//			problem5(ll, i);
//		}
//		problem5(ll, 10);
//		problem5(ll, 11);
//		problem5(ll, 13);

//		for (int i = 0; i < 10; i++) {
//			problem6(ll.getHead(), i);
//			count = 0;
//		}
//		problem6(ll.getHead(), 10);
//		problem6(ll.getHead(), 11);
//		problem6(ll.getHead(), 13);

//		System.out.println("IsCyclic = " + problem7a(ll.getHead(), ll.length()));
//		temp.setNext(ll.getHead().getNext().getNext());
//		System.out.println("IsCyclic = " + problem7a(ll.getHead(), ll.length()));
//		System.out.println("IsCyclic = " + problem8(ll));
//		temp.setNext(ll.getHead().getNext().getNext().getNext());
//		System.out.println("IsCyclic = " + problem8(ll));
//		problem10(ll);
//		temp.setNext(ll.getHead().getNext().getNext().getNext());
//		problem10(ll);

		System.out.println("IsCyclic = " + problem11(ll.getHead(), ll.length()));
		temp.setNext(ll.getHead().getNext().getNext());
		System.out.println("IsCyclic = " + problem11(ll.getHead(), ll.length()));
	}
}
