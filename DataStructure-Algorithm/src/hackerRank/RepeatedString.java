package hackerRank;

import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		long count = 0;
		int size = s.length();
		for (int i = 0; i < size; i++) {
			if (s.charAt(i) == 'a')
				count++;
		}
		count *= (n / size);
		for (int i = 0; i < n % size; i++) {
			if (s.charAt(i) == 'a')
				count++;
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		String s = scanner.nextLine();
//
//		long n = scanner.nextLong();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		long result = repeatedString(s, n);
//
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
//
//		scanner.close();
		repeatedString("abcac", 10);
	}
}
