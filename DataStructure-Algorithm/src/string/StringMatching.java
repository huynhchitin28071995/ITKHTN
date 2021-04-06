package string;

public class StringMatching {
	public static int bruteForceStringMatch(char[] t, int n, char[] p, int m) {
		for (int i = 0; i <= n - m; i++) {
			int j = 0;
			while (j < m && p[j] == t[i + j])
				j++;
			if (j == m) {
				System.out.println("Yes");
				return i;
			}
		}
		System.out.println("No");
		return -1;
	}

	int f[];

	public void prefixTable(int p[], int m) {
		int i = 1;
		int j = 0;
		f[0] = 0;
		while (i < m) {
			if (p[i] == p[j]) {
				f[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = f[j - 1];
			} else {
				f[i] = 0;
				i++;
			}

		}
	}

	public int kmp(char t[], int n, int p[], int m) {
		int i = 0;
		int j = 0;
		prefixTable(p, m);
		while (i < n) {
			if (t[i] == p[j]) {
				if (j == m - 1)
					return i - j;
				else {
					i++;
					j++;
				}
			} else if (j > 0)
				j = f[j - 1];
			else
				i++;
		}
		return -1;
	}

	public static void main(String[] args) {
		String t = "test test test test";
		String p = "test";
		bruteForceStringMatch(t.toCharArray(), t.length(), p.toCharArray(), p.length());
	}
}
