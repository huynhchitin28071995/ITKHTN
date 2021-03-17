package recursion_backtracking;

import java.util.Arrays;

public class GenStringsOfLengthN {
	static int[] A = new int[4];

	private void kString(int n, int k) {
		if (n < 1) {
			System.out.println(Arrays.toString(A));
		} else {
			for (int i = 0; i < k; i++) {
				kString(n - 1, k - 1);
			}
		}
	}
}
