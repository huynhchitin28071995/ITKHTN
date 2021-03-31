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

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(4);
		s.push(5);
		s.push(-2);
		s.push(-3);
		s.push(11);
		s.push(10);
		s.push(6);
		s.push(5);
		s.push(21);
		s.push(22);
		System.out.println(s.toString());
		problem8(s);
		System.out.println(s.toString());
		problem8a(s);
		System.out.println(s.toString());
	}
}
