package recursion_backtracking;

import java.util.Arrays;

public class GenStringsOfNBits {
	static int[] A = new int[4];

	public static void genStringsOfNBits(int nBits) {

		// base case
		if (nBits < 1) {
			System.out.println(Arrays.toString(A));
		} else {
			// cursive case
			A[nBits - 1] = 0;
			genStringsOfNBits(nBits - 1);
			A[nBits - 1] = 1;
			genStringsOfNBits(nBits - 1);
		}
	}

	public static void main(String[] args) {
		genStringsOfNBits(4);
	}
}
