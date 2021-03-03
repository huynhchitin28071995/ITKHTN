package item24_25_26;

import item24_25_26.Calculator.InnerClass;

public class Test {
	public static void main(String[] args) {
		System.out.println(Calculator.Operation.MINUS);
		Calculator c = new Calculator();
		InnerClass ic = c.new InnerClass(); // each instance of InnerClass will have a reference to it's enclosing
											// instance
		ic.innerClassInstanceMethod();
		c.setNum1(10);
	}
}
