package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problems6_10 {
	private static void problem6() {
		// circular array queue, no front and rear defined. 1 location for storing value
		// defining isEmpty().

		// -> size n
	}

	private static void problem8(Stack<Integer> s) { // check Each successive pair is consecutive?
		// Stack<Integer> sTemp = s;// this will alter the stack
		Stack<Integer> sTemp = (Stack<Integer>) s.clone(); // this will not alter the stack
		if (sTemp.size() % 2 != 0)
			sTemp.pop();
		while (!sTemp.isEmpty())
			if (Math.abs(sTemp.pop() - sTemp.pop()) != 1) {
				System.out.println("Each successive pair is not consecutive!");
				return;
			}
		System.out.println("Each successive pair is consecutive!");
	}

	private static void problem8a(Stack<Integer> s) { // implement queue to solve problem
		Queue<Integer> q = new LinkedList<Integer>();
		reverseStack(s); // for the preserving order in the last step
		boolean isPairwiseOrdered = true;
		while (!s.isEmpty()) {
			int n = s.pop();
			q.add(n);
			if (!s.isEmpty()) { // to prevent the odd number of elements case
				int m = s.pop();
				q.add(m);
				if (Math.abs(m - n) != 1)
					isPairwiseOrdered = false;
			}
		}
		while (!q.isEmpty()) { // recover stack with preserved order
			s.push(q.remove());
		}
		if (isPairwiseOrdered)
			System.out.println("Each successive pair is consecutive!");
		else
			System.out.println("Each successive pair is not consecutive!");
	}

	private static void reverseStack(Stack<Integer> s) {
		Queue<Integer> q = new LinkedList<Integer>();
		while (!s.isEmpty())
			q.add(s.pop());
		while (!q.isEmpty())
			s.push(q.remove());
	}

	private static void problem9(Queue<Integer> q) { // interleaving first half with second half
		if (q.size() % 2 != 0)
			throw new IllegalArgumentException();
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		int i = 0;
		int size = q.size();

		while (i < size / 2) {
			q1.add(q.remove());
			i++;
		}
		while (!q.isEmpty())
			q2.add(q.remove());
		while (!q1.isEmpty() && !q2.isEmpty()) {
			q.add(q1.remove());
			q.add(q2.remove());
		}
		System.out.println(q.toString());
	}

	private static void problem9a(Queue<Integer> q) {
		if (q.size() % 2 != 0)
			throw new IllegalArgumentException();
		Stack<Integer> s = new Stack<>();
		int haftSize = q.size() / 2;
		// start
		for (int i = 0; i < haftSize; i++)
			s.push(q.remove());
		while (!s.isEmpty())
			q.add(s.pop());
		for (int i = 0; i < haftSize; i++)
			q.add(q.remove());
		// end: to reverse the front element
		for (int i = 0; i < haftSize; i++)
			s.push(q.remove()); // front become top
		while (!s.isEmpty()) {
			q.add(s.pop());
			q.add(q.remove());
		}
	}

	private static void problem10(Queue<Integer> q, int k) { // reverse the order of first k element of a queue
		if (k > q.size())
			throw new IllegalArgumentException();
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < k; i++)
			s.push(q.remove());
		while (!s.isEmpty())
			q.add(s.pop());
		for (int i = k; i < q.size(); i++)
			q.add(q.remove());
	}

	public static void main(String[] args) {
//		Stack<Integer> s = new Stack<Integer>();
//		s.push(4);
//		s.push(5);
//		s.push(-2);
//		s.push(-3);
//		s.push(11);
//		s.push(10);
//		s.push(6);
//		s.push(5);
//		s.push(21);
//		s.push(22);
//		System.out.println(s.toString());
//		problem8(s);
//		System.out.println(s.toString());
//		problem8a(s);
//		System.out.println(s.toString());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 11; i < 21; i++)
			q.add(i);
		System.out.println(q.toString());
//		problem9a(q);
		problem10(q, 11);
		System.out.println(q.toString());
	}
}
