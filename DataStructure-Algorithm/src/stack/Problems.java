package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

	public static Object[] problem2(String s) { // infix to postfix conversion
		Stack<String> stk = new Stack<>();
//		String[] strings = s.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
		String[] strings = s.split("(?<=[-+*/()])|(?=[-+*/()])");
		List<String> list = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			strings[i] = strings[i].trim();
			// use equals() to compare, not comparison operator
			if (strings[i].equals("") || strings[i].equals(" "))
				continue;
			if (!strings[i].equals("+") && !strings[i].equals("-") && !strings[i].equals("*") && !strings[i].equals("/")
					&& !strings[i].equals("(") && !strings[i].equals(")"))
				list.add(strings[i]);
			else if (strings[i].equals(")")) {
				while (!stk.peek().equals("("))
					list.add(stk.pop());
				stk.pop();
			} else {
				if (strings[i].equals("*") || strings[i].equals("/")) {
					while (!stk.isEmpty() && !stk.peek().equals("(") && !stk.peek().equals("+")
							&& !stk.peek().equals("-"))
						list.add(stk.pop());
				} else if (strings[i].equals("+") || strings[i].equals("-")) {
					while (!stk.isEmpty() && !stk.peek().equals("("))
						list.add(stk.pop());
				}
				stk.push(strings[i]);
			}
		}

		while (!stk.isEmpty())
			list.add(stk.pop());
		return list.toArray();
	}

//will back to problem 3 later

	public static void problem4(Object[] objects) {// evaluate postfix expression
		Stack<Integer> stk = new Stack<Integer>();
		for (Object string : objects) {
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
			} else if (string.equals(" ")) {
				continue;
			} else
				stk.push(Integer.parseInt((String) string));
		}
		System.out.println(stk.pop());
	}

	public static void problem5(String s) { // evaluate infix expression with 2 stacks in 1 pass
		String[] o = s.split("(?<=[-+*/()])|(?=[-+*/()])");//this regexp does not deal with white space
		Stack<String> stkOprt = new Stack<>();
		Stack<Integer> stkOprd = new Stack<>();
		for (int i = 0; i < o.length; i++) {
			if(o[i].equals(" ")) continue;
			o[i] = ((String)o[i]).trim();
			
			if(o[i].equals("(")) 
				stkOprt.push("(");
			else if(o[i].equals(")")) {
				while(stkOprt.peek()!="(") {
					stkOprd.push(evaluate(stkOprt.pop(), stkOprd.pop(), stkOprd.pop()));
				}
				stkOprt.pop();
			} else if (isOperator((String) o[i])) {
				while (!stkOprt.isEmpty()&&precedence((String) o[i])<=precedence(stkOprt.peek())) {
					stkOprd.push(evaluate(stkOprt.pop(), stkOprd.pop(), stkOprd.pop()));
				}
				stkOprt.push((String) o[i]);
			} else {
				
				stkOprd.push(Integer.parseInt((String)o[i]));
			}
		
	}
		while (!stkOprt.isEmpty()) {
			stkOprd.push(evaluate(stkOprt.pop(), stkOprd.pop(), stkOprd.pop()));
		}
		System.out.println(stkOprd.pop());
	}
	private static boolean isOperator(String s) {
		switch (s) {
		case "+":
		case "-":
		case "*":
		case "/":
			return true;

		default:
			return false;
		}
	}
	private static int precedence(String s) {
		switch (s) {
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		case "^":
			return 3;
		default:
			return -1;
		}
	}

	private static int evaluate(String oprt, int val2, int val1) {
		if (oprt.equals("+")) {
			return val1 + val2;
		} else if (oprt.equals("*"))
			return val1 * val2;
		else if (oprt.equals("-")) {
			return (val1 - val2);
		} else if (oprt.equals("/")) {
			return (val1 / val2);
		}
		return Integer.MIN_VALUE;
	}

	public static void problem6() throws Exception{ //design a stack to getMinimun O(1)
		MinStack ms = new MinStack();
		ms.push(7);
		ms.push(4);
		ms.push(9);
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		
	}
	public static void problem8(String s) { //check is palindrome with i and j
		int i = 0;
		int j = s.length() - 1;
		while(s.charAt(i)==s.charAt(j)&&s.charAt(i)!='X'&&s.charAt(j)!='X') {
			i++;
			j--;
		}
		if(s.charAt(i+1)!=s.charAt(j-1)) {
			System.out.println("Not palindrome!");
		} else {
			System.out.println("Is palindrome!");
		}
	}
	public static void problem9_10(String s) { //check is palindrome with stack and in case string is a list
		Stack<Character> stk = new Stack<Character>();
		int i = 0;
		while(s.charAt(i) != 'X') {
			stk.push(s.charAt(i++));
		}
		i++;
		for (; i < s.length(); i++) {
			if(s.charAt(i) == stk.peek())
				stk.pop();
			else if(s.charAt(i)!=stk.peek()||stk.isEmpty()){
				System.out.println("Not palindrome");
				return;
			}
		}
		if(stk.isEmpty()) System.out.println("Is palindrome"); else System.out.println("Not palindrome"); 
	}
	public static void problem11(Stack<Integer> s) { //reverse a stack
		if(s.isEmpty()) return;
		int val = s.pop();
		problem11(s);
		insertAtBottom(s, val);
	}
	private static void insertAtBottom(Stack<Integer> s, int data) {
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		int temp = s.pop();
		insertAtBottom(s, data);
		s.push(temp);
	}
	private static Stack<Integer> stk = new Stack<Integer>();
	public static void main(String[] args) throws Exception {
		String s = "(asdf)(dfsgdfa)(xcz)dsa[gfgf[]]{}[]";
//		problem1(s);
		s = "A * B-(C+D)+E";
		System.out.println(Arrays.toString(problem2(s)));
		s = "100 * (2 - 3) / 4+5";
		System.out.println(100 * (2 - 3) / 4 + 5);
		System.out.println(Arrays.toString(problem2(s)));
		problem4(problem2(s));
		s = "100 * ( 3+ 5)/2-7*4-1";
		System.out.println(100 *( 3 + 5) / 2 - 7 * 4 - 1);
		System.out.println(Arrays.toString(s.split("(?<=[-+*/()])|(?=[-+*/()])")));
		problem5(s);
		problem6();
		problem9_10("abababaXbababaaaaa");
		problem8("abababaXabababa");
		
		for(int i =0; i< 10; i++)
			stk.push(i);
		problem11(stk);
		while(!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
	}
}
