package hackerRank;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class JumpingCloulds {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		LinkedList<Integer> ll = new LinkedList<>();
		for (int i = 1; i < c.length; i++) {
			if (i + 1 < c.length && c[i + 1] != 1) {
				ll.add(++i);
			} else {
				ll.add(i);
			}
		}
		System.out.println(ll);
		System.out.println(ll.size());
		return ll.size();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int n = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		int[] c = new int[n];
//
//		String[] cItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			int cItem = Integer.parseInt(cItems[i]);
//			c[i] = cItem;
//		}
//
//		int result = jumpingOnClouds(c);
//
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
//
//		scanner.close();
//		int[] c = { 0, 0, 1, 0, 0, 1, 0 };
		int[] c = { 0, 0, 0, 1, 0, 0 };
//		int[] c = { 0, 0, 0, 0, 1, 0 };
		jumpingOnClouds(c);
	}
}
