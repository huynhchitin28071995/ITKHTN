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
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
		for (int i = 0; i < 10; i++) {
			problem2(ll, i);
		}
		problem2(ll, 10);
		problem2(ll, 11);
		problem2(ll, 13);

		for (int i = 0; i < 10; i++) {
			problem3(ll, i);
		}
		problem3(ll, 10);
		problem3(ll, 11);
		problem3(ll, 13);

		for (int i = 0; i < 10; i++) {
			problem4(ll, i);
		}
		problem4(ll, 10);
		problem4(ll, 11);
		problem4(ll, 13);
	}
}
