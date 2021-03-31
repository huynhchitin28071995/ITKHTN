package queue;

import java.util.LinkedList;
import java.util.Queue;

public class OneStackW2Queue<T> {
	Queue<T> q1;
	Queue<T> q2;

	public OneStackW2Queue() {
		q1 = new LinkedList<T>();
		q2 = new LinkedList<T>();
	}

	public void push(T data) throws Exception {
		q1.add(data);
	}

	public T pop() throws Exception {
		if (q2.isEmpty())
			while (!q1.isEmpty())
				q2.add(q1.remove());
		return q2.remove();
	}

	public boolean isEmpty() {
		return q1.isEmpty() && q2.isEmpty();
	}

}
