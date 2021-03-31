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

	private static void problem2() { // implement a queue using 2 stacks
		QueueWith2Stacks<Integer> q = new QueueWith2Stacks<>();
		for (int i = 0; i < 10; i++) {
			q.enQueue(i);
		}
		while (!q.isEmpty())
			System.out.println(q.deQueue());
//		q.deQueue();
	}

	private static void problem3() {// implement 1 stack using 2 queues
		OneStackW2Queue<Integer> s = new OneStackW2Queue<>();
		for (int i = 0; i < 10; i++) {
			try {
				s.push(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (!s.isEmpty())
			try {
				System.out.println(s.pop());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	// comeback to problem4 later
	private static void problem5() { // transfer items in queue to stack, preserve order: q.remove() = s.pop()
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < 10; i++) {
			q.add(i);
		}
		System.out.println(q.toString());
		while (!q.isEmpty())
			s.push(q.remove());
		System.out.println(s.peek());
		while (!s.isEmpty())
			q.add(s.pop());
		while (!q.isEmpty())
			s.push(q.remove());
		System.out.println(s.peek());
	}

	public static void main(String[] args) {
		queue = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.add(i);
		}
//		System.out.println(queue.toString());
//		problem1(queue);
//		System.out.println(queue.toString());
//		problem1b(queue);
//		System.out.println(queue.toString());
//		problem2();
//		problem3();
		problem5();
	}
}
