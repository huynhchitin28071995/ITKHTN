package hackerRank;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Result {

	/*
	 * Complete the 'countingValleys' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER steps 2. STRING path
	 */

	public static int countingValleys(int steps, String path) {
		Queue<Character> q = new LinkedList<>();
		boolean isBelow;
		int countVal = 0;
		if (path.charAt(0) == 'U') {
			isBelow = false;
		} else {
			isBelow = true;
			countVal++;
		}
		q.offer(path.charAt(0));
//		System.out.println(q);
		for (int i = 1; i < steps; i++) {
			if (!q.isEmpty() && (path.charAt(i) != q.peek())) {
				q.poll();
//				if (q.isEmpty() && i + 1 < steps && (path.charAt(i + 1) == path.charAt(i))) {
				if (q.isEmpty() && i + 1 < steps && (path.charAt(i + 1) == 'D')) {
//					isBelow = !isBelow;
//					if (isBelow)
					countVal++;
				}
			} else {
				q.offer(path.charAt(i));
			}
		}
		return countVal;

	}

}

public class CountValley {
	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int steps = Integer.parseInt(bufferedReader.readLine().trim());
//
//		String path = bufferedReader.readLine();
//
//		int result = Result.countingValleys(steps, path);
//
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedReader.close();
//		bufferedWriter.close();
		System.out.println(Result.countingValleys(10, "UDUUUDUDDD"));
		System.out.println(Result.countingValleys(8, "UDDDUDUU"));
		System.out.println(Result.countingValleys(12, "DDUUDDUDUUUD"));
	}
}
