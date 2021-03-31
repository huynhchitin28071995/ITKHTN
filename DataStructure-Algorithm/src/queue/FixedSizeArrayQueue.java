package queue;

public class FixedSizeArrayQueue {
	private int[] queueRep;
	private int size, front, rear;
	private static final int CAPACITY = 16;

	public FixedSizeArrayQueue() {
		queueRep = new int[CAPACITY];
		size = 0;
		front = 0;
		rear = 0;
	}

	public FixedSizeArrayQueue(int cap) {
		queueRep = new int[cap];
		size = 0;
		front = 0;
		rear = 0;
	}

	// insert an element at the rear of the queue. O(1)
	public void enQueue(int data) {
		if (size == CAPACITY)
			throw new IllegalStateException("Queue is full: Overflow");
		else {
			size++;
			queueRep[rear] = data;
			rear = (rear + 1) % CAPACITY; // rear is always less than CAPACITY
		}
	}

	// removes the front element from the queue. O(1)
	public int deQueue() {
		if (size == 0)
			throw new IllegalStateException("Queue is empty: Underflow");
		else {
			size--;
			int data = queueRep[front % CAPACITY];// font%CAPACITY always < CAPACITY
			queueRep[front] = Integer.MIN_VALUE;
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

//	public static void main(String[] args) {
//		FixedSizeArrayQueue f = new FixedSizeArrayQueue();
//		for (int i = 0; i < 100; i++)
//			f.enQueue(i);
//	}
}
