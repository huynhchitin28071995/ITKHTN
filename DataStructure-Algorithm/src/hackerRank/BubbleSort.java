package hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	// Complete the countSwaps function below.
	static void countSwaps(int[] a) {
		int count = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					count++;
				}
			}
		}
		System.out.println("Array is sorted in " + count + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
//		int n = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		int[] a = new int[n];
//
//		String[] aItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			int aItem = Integer.parseInt(aItems[i]);
//			a[i] = aItem;
//		}
//
//		countSwaps(a);
//
//		scanner.close();
		int[] a = { 4, 2, 7, 6, 3, 1 };
		countSwaps(a);
		System.out.println(Arrays.toString(a));
	}
}
