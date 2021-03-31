package queue;

import java.util.Stack;

public class QueueWith2Stacks<T> {
	Stack<T> s1;
	Stack<T> s2;

	public QueueWith2Stacks() {
		super();
		this.s1 = new Stack<>();
		this.s2 = new Stack<>();
	}

	public void enQueue(T data) {
		s1.push(data);
	}

	public T deQueue() {
		if (s2.isEmpty())
			while (!s1.isEmpty())
				s2.push(s1.pop());
		return s2.pop();

	}

	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}
}
