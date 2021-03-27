package stack;

public class DynamicArrayStack extends Stack {
	public static int MINCAPACITY = 1 << 15;

	public DynamicArrayStack() {
		super();
	}

	public DynamicArrayStack(int cap) {
		super(cap);
	}

	public void push(int data) {
		if (size() == capacity)
			expand();
		stackRep[++top] = data;
	}

	private void expand() {
		int length = size();
		int[] newStack = new int[length << 1]; // length<<1 = length * (2^1);
		System.arraycopy(stackRep, 0, newStack, 0, top + 1);
		stackRep = newStack;
		this.capacity = this.capacity << 1;
	}

	private void shrink() { // shrinks to 1/2 if more than 3/4 empty
		int length = top + 1;
		if (length <= MINCAPACITY || top << 2 >= length) // 3*length>=4,length>=4/3 -> top>=1/3 no shrink/return.
			return;
		length += top << 1;// shrink to 1/2 or less of the heap
		if (top < MINCAPACITY)
			length = MINCAPACITY;
		int[] newstack = new int[length];
		System.arraycopy(stackRep, 0, newstack, 0, top + 1);
		stackRep = newstack;
		this.capacity = length;
	}

	public int pop() throws Exception {
		int data = top();
		stackRep[top--] = Integer.MIN_VALUE;// dereference for garbage collection
		shrink();
		return data;
	}

	public static void main(String[] args) {
		System.out.println(1 << 15);
		System.out.println(1 << 2);
	}

}
