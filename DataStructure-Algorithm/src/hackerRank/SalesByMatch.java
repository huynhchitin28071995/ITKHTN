package hackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class SalesByMatch {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		for (int i = 0; i < ar.length; i++) {
			if (ht.containsKey(ar[i])) {
				ht.replace(ar[i], ht.get(ar[i]), ht.get(ar[i]) + 1);
			} else {
				ht.put(ar[i], 1);
			}
		}

		return ht.values().stream().mapToInt(v -> v = v / 2).sum();

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
