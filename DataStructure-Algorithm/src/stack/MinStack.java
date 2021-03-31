package stack;

public class MinStack extends Stack{
	private LinkedStack elementStack = new LinkedStack();
	private LinkedStack minStack = new LinkedStack();

	@Override
	public void push(int data) throws Exception {
		elementStack.push(data);
		if(minStack.isEmpty()||data<=minStack.peek()) {
			minStack.push(data);
		}
//		else {
//			minStack.push(minStack.peek());
//		}
	}

	@Override
	public int pop() throws Exception {
		if(elementStack.peek()==minStack.peek())//additional statement for problem 7.
			minStack.pop();
		return elementStack.pop();
	}
	
	public int getMin() {
		return minStack.peek();
	}
}
