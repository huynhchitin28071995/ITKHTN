package recursion_backtracking;

import java.util.Arrays;

public class GenStringsOfLengthN {
	static int[] A = new int[4];
	static long counter = 0;

	private static void kString(int n, int k) {
		// base case
		if (n < 1) {
			System.out.println(Arrays.toString(A));
		} else {
			// cursive case
			// do something for recursion
			for (int i = 0; i < k; i++) {
				System.out.println(counter++);
				A[n - 1] = i; // set A[n-1] equals to 0 -> k - 1
				kString(n - 1, k); // set smaller subset.
			}

		}
	}

	public static void main(String[] args) {
		kString(4, 4);
	}
}
