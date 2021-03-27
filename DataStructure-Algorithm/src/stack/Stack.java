package stack;

public abstract class Stack {
	protected int capacity; // length of array used to implement the stack
	public static final int CAPACITY = 10; // default array capacity
	protected int[] stackRep; // array represents a stack
	protected int top = -1; // index of the top element of the stack in array

	public Stack(int capacity) {
		this.capacity = capacity;
		stackRep = new int[capacity];
	}

	public Stack() {
		this(CAPACITY);
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public String toString() {
		String s = "[";
		StringBuilder sb = new StringBuilder(s);
		if (size() > 0)
			sb.append(stackRep[0]);
		if (size() > 1)
			for (int i = 1; i < size(); i++)
				sb.append(", " + stackRep[i]);
		return sb.append("]").toString();
	}

	public abstract void push(int data) throws Exception;

	public int top() throws Exception {
		if (isEmpty())
			throw new Exception("Stack is empty");
		return stackRep[top];
	}

	public abstract int pop() throws Exception;
}
