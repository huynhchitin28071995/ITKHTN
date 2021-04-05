package hackerRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
	// complete this method
	public int compare(Player a, Player b) {
		if (a.score < b.score)
			return 1;
		else if (a.score == b.score) {
			if (a.name.equals(b.name)) {
				return 0;
			} else {
				int i = 0;
				while (i < a.name.length() - 1 && i < b.name.length() - 1 && a.name.charAt(i) == b.name.charAt(i)) {
					i++;
				}
				if (a.name.charAt(i) < b.name.charAt(i)) {
					return -1;
				} else {
					if (a.name.charAt(i) == b.name.charAt(i) && a.name.length() < b.name.length())
						return -1;
					return 1;
				}
			}
		} else
			return -1;

	}
}

public class PlayerComparator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}