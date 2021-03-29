package stack;

import java.util.Arrays;
import java.util.Stack;

public class Problems {
	public static void problem1(String s) { /// check balance of symbols
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

	public static String problem2(String s) { // infix to postfix conversion
		Stack<Character> stk = new Stack<Character>();
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}
			if (s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/'
					&& s.charAt(i) != '(' && s.charAt(i) != ')')
//				System.out.print(s.charAt(i));
				result += s.charAt(i);
			else if (s.charAt(i) == ')') {
				while (stk.peek() != '(') {
//					System.out.print(stk.pop());
					result += stk.pop();
				}
				stk.pop();
			} else {
				if (s.charAt(i) == '*' || s.charAt(i) == '/') {
					while (!stk.isEmpty() && stk.peek() != '(' && stk.peek() != '+' && stk.peek() != '-') {
//						System.out.print(stk.pop());
						result += stk.pop();
					}
				} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
					while (!stk.isEmpty() && stk.peek() != '(') {
//						System.out.print(stk.pop());
						result += stk.pop();
					}
				}
				stk.push(s.charAt(i));
			}
		}

		while (!stk.isEmpty()) {
			result += stk.pop();
//			System.out.print(stk.pop());
		}
		return result;
	}

//will back to problem 3 later

	public static void problem4(String[] s) {// evaluate postfix expression
		Stack<Integer> stk = new Stack<Integer>();
		for (String string : s) {
			if (string.equals("+"))
				stk.push(stk.pop() + stk.pop());
			else if (string.equals("-")) {
				int op1 = stk.pop();
				int op2 = stk.pop();
				stk.push(op2 - op1);
			}

			else if (string.equals("*")) {
				stk.push(stk.pop() * stk.pop());
			} else if (string.equals("/")) {
				int op1 = stk.pop();
				int op2 = stk.pop();
				stk.push(op2 / op1);
			} else
				stk.push(Integer.parseInt(string));
		}
		System.out.println(stk.pop());
	}

	public static void main(String[] args) {
		String s = "(asdf)(dfsgdfa)(xcz)dsa[gfgf[]]{}[]";
//		problem1(s);
		s = "A*B-(C+D)+E";
//		problem2(s);
		s = "10 * 2 - 3 + 4";
		System.out.println(10 * 2 - 3 + 4);
		System.out.println(Arrays.toString(problem2(s).split("")));
		problem4(problem2(s).split(""));
	}
}
