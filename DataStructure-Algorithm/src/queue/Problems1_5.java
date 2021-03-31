package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problems1_5 {
	private static Queue<Integer> queue;

	private static void problem1(Queue<Integer> q) {
		if (q.isEmpty())
			return;
		int val = q.remove();
		problem1(q);
		q.add(val);
	}

	private static void problem1b(Queue<Integer> q) {
		Stack<Integer> s = new Stack<Integer>();
		while (!q.isEmpty()) {
			s.push(q.remove());
		}
		while (!s.isEmpty()) {
			q.add(s.pop());
		}
	}

	public static void main(String[] args) {
		queue = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.add(i);
		}
		System.out.println(queue.toString());
		problem1(queue);
		System.out.println(queue.toString());
		problem1b(queue);
		System.out.println(queue.toString());
	}
}
