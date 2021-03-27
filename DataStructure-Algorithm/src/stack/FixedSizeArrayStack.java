package stack;

import java.util.EmptyStackException;

public class FixedSizeArrayStack extends Stack {

	public FixedSizeArrayStack() {
		super();
	}

	public FixedSizeArrayStack(int cap) {
		super(cap);
	}

	public void push(int data) throws Exception {
		if (size() == capacity) {
			throw new Exception("Stack is full!");
		}
		stackRep[++top] = data;
	}

	public int pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		int data = stackRep[top]; // store top
		stackRep[top--] = Integer.MIN_VALUE;// next push() will replace this value.
		return data;
	}

}
