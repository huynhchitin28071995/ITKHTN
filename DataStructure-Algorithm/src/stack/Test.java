package stack;

public class Test {
	public static void main(String[] args) {
		Stack s1 = new FixedSizeArrayStack();
		Stack s2 = new FixedSizeArrayStack(10);
		Stack s3 = new DynamicArrayStack();
		Stack s4 = new DynamicArrayStack(10);
		Stack s5 = new LinkedStack();
		try {
			for (int i = 0; i < 20; i++) {
//				s1.push(i);
//				s2.push(i);
//				s3.push(i);
//				s4.push(i);
				s5.push(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(s5.toString());
	}
}
