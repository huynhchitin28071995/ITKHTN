package queue;

public class DynamicArrayQueue {
	private int[] queueRep;
	private int size, front, rear;
	private static int CAPACITY = 16;
	public static int MINCAPACITY = 1 << 15;

	public DynamicArrayQueue() {
		queueRep = new int[CAPACITY];
		size = front = rear = 0;
	}

	public DynamicArrayQueue(int cap) {
		queueRep = new int[cap];
		size = front = rear = 0;
	}

	public void enQueue(int data) {
		if (size == CAPACITY)
			expand();
		size++;
		queueRep[rear] = data;
		rear++;
	}

	private void expand() {
		int length = size();
		int[] newQueue = new int[length << 1];
		for (int i = front; i <= rear; i++) {
			newQueue[i - front] = queueRep[i % CAPACITY];

		}
		queueRep = newQueue;
		front = 0;
		rear = size - 1;
		CAPACITY *= 2;
	}

	private void shrink() {
		int length = size;
		if (length <= MINCAPACITY || length << 2 >= length)
			return;
		if (length < MINCAPACITY)
			length = MINCAPACITY;
		int[] newQueue = new int[length];
		System.arraycopy(queueRep, 0, newQueue, 0, length + 1);
	}

	public int deQueue() {
		if (size == 0)
			throw new IllegalStateException("Queue is empty: Underflow");
		else {
			size--;
			int data = queueRep[(front % CAPACITY)];
			queueRep[(front)] = Integer.MIN_VALUE;
			front = (front + 1) % CAPACITY;
			return data;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == CAPACITY;
	}

	public int size() {
		return size;
	}

	public String toString() {
		String result = "[";
		for (int i = 0; i < size; i++) {
			result += Integer.toString(queueRep[(front + i) % CAPACITY]);
			if (i < size - 1) {
				result += ", ";
			}
		}
		result += "]";
		return result;
	}

	public static void main(String[] args) {
		System.out.println(1 << 15);
		DynamicArrayQueue d = new DynamicArrayQueue();
		for (int i = 0; i < 100; i++)
			d.enQueue(i);
		System.out.println(d.toString());
	}
}
