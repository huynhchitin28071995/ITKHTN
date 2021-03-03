package item24_25_26;

public class Calculator {
	enum Operation {
		PLUS, MINUS;
	}

	private int num1;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public class InnerClass {
		public void innerClassInstanceMethod() {
			System.out.println(
					"Can not declare static method in non-static inner class. To access this method, must declare:\n Calculator c = new Calculator();\n InnerClass ic = c.new InnerClass(); \n ic.innerClassInstanceMethod()");
		}
	}

	public static void main(String[] args) {
		System.out.println(Operation.MINUS);
	}
}
