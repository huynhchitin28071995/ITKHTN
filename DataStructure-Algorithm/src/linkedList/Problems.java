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
		ListNode slowPtr = list.getHead();
		ListNode fastPtr = list.getHead().getNext();
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

	private static void problem12(LinkedList list) { // find the start of the loop.
		ListNode slowPtr = list.getHead();
		ListNode fastPtr = list.getHead();
		boolean isLoop = false;
		while (fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
			if (slowPtr.equals(fastPtr)) {
				System.out.println("This list is cyclic!");
				isLoop = true;
				break;
			}
		}
		if (isLoop) {
			slowPtr = list.getHead(); // move slowPtr to head
			while (slowPtr != fastPtr) {
				slowPtr = slowPtr.getNext();// slowPtr and fastPtr move 1 step. they will meet again at the start of the
				fastPtr = fastPtr.getNext();// loop.
			}
			System.out.println("Start of the loop is at value: " + slowPtr.getData());
		} else {
			System.out.println("This list is non-cyclic!");
		}
	}

	private static void problem15(LinkedList list) {
		ListNode slowPtr = list.getHead();
		ListNode fastPtr = list.getHead();
		boolean isCyclic = false;
		while (fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
			if (slowPtr.equals(fastPtr)) {
				System.out.println("This list is cyclic!");
				isCyclic = true;
				break;
			}
		}
		int counter = 0;
		if (isCyclic) { // count the number of steps for slowPtr to reach the meeting point again (1
						// step at a time)
			do {
				counter++;
				slowPtr = slowPtr.getNext();
			} while (slowPtr != fastPtr);
			System.out.println("Loop length = " + counter);
		} else {
			System.out.println("This list is non-cyclic");
		}
	}

	private static void problem16(ListNode head, ListNode newNode) { // Add new node in descending linked list
		ListNode cur = head;
		if (head == null)
			return;
		ListNode temp = cur;
		while (cur != null && newNode.getData() < cur.getData()) {
			temp = cur;
			cur = cur.getNext();
		}
		newNode.setNext(cur);
		temp.setNext(newNode);
	}

	private static ListNode problem17(LinkedList list) { // reverse a singly linked list
		ListNode cur = list.getHead();
		ListNode next;
		ListNode prev = null;
		while (cur != null) {
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		list.setHead(prev);// package-private method. no need to return prev
		return prev;// prev is at tail, also new head. return new head, and store it in main
	}

	private static void problem17a(ListNode cur, LinkedList list) {
		if (cur == null)
			return;
		ListNode next = cur.getNext();// next is after cur
		if (next == null) {// cur is at tail and next is null
			list.setHead(cur);// cur is at tail and is new head
			return;
		}
		// if cur is not at tail
		problem17a(next, list);// next is the new cur
		next.setNext(cur);// set next's next pointer to cur/before
		cur.setNext(null);

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
		for (int i = 0; i < 10; i += 1) {
			ll.insertAtBegin(new ListNode(i));
		}
		ListNode node = ll.getHead();
		ListNode temp = node;
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
			if (node != null) {
				temp = node; // to get the before-last node for making loop
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

//		System.out.println("IsCyclic = " + problem11(ll.getHead(), ll.length()));
//		temp.setNext(ll.getHead().getNext().getNext());
//		System.out.println("IsCyclic = " + problem11(ll.getHead(), ll.length()));
//		problem12(ll);
//		temp.setNext(ll.getHead());
//		problem12(ll);
//		problem15(ll);
//		temp.setNext(ll.getHead().getNext().getNext());
//		problem15(ll);
//		problem16(ll.getHead(), new ListNode(5));
//		problem17(ll);
		problem17a(ll.getHead(), ll);
		node = ll.getHead();
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}
}
