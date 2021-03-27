package stack;

import java.util.Stack;

public class Problems {
	public static void problem1(String s) {
		Stack<Character> stk = new Stack<>();
		if (s == null || s.length() == 0)
			return;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (!stk.isEmpty() && stk.peek() == '(')
					stk.pop();
				else {
					System.out.println("Invalid closing symbol");
					return;
				}
			} else if (s.charAt(i) == ']') {
				if (!stk.isEmpty() && stk.peek() == '[')
					stk.pop();
				else {
					System.out.println("Invalid closing symbol");
					return;
				}
			} else if (s.charAt(i) == '}') {
				if (!stk.isEmpty() && stk.peek() == '{')
					stk.pop();
				else {
					System.out.println("Invalid closing symbol");
					return;
				}
			} else if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
				stk.push(s.charAt(i));
			}
		}
		if (stk.isEmpty()) {
			System.out.println("The string is valid");
		} else {
			System.out.println("The string is invalid");
		}
	}

	public static void problem2(String s) {
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/')
				System.out.print(s.charAt(i));
			else if (s.charAt(i) == ')') {
				while (stk.peek() != '(') {
					System.out.print(stk.pop());
				}
				stk.pop();
			} else {
				if (s.charAt(i) == '*' || s.charAt(i) == '/') {
					while (!stk.isEmpty() && stk.peek() != '(' && stk.peek() != '+' && stk.peek() != '-') {
						System.out.print(stk.pop());
					}
					if (!stk.empty() && stk.peek() == '(')
						stk.pop();
				} else {
					while (!stk.isEmpty() && stk.peek() != '(') {
						System.out.print(stk.pop());
					}
					if (!stk.empty() && stk.peek() == '(')
						stk.pop();
				}
				stk.push(s.charAt(i));
			}
		}
		while (!stk.isEmpty())
			System.out.print(stk.pop());
	}

	public static void main(String[] args) {
		String s = "(asdf)(dfsgdfa)(xcz)dsa[gfgf[]]{}[]";
//		problem1(s);
		s = "A*B-(C+D)+E";
		problem2(s);
	}
}
