package recursion_backtracking;

public class Factorial {
	private static int count = 0;
public static void main(String[] args) {
	System.out.println(factorialOf(10));
	System.out.print(count);
}
private static int factorialOf(int n) {
	count++;
	if(n > 1) {
		return n * factorialOf(n-1);
	} else {
		return 1;
	}
}
private static int count(int count) {
	return count++;
}
}
