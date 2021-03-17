package recursion_backtracking;

public class TowerOfHanoi {

	public static void towersOfHanoi(int n, String fromPeg, String toPeg, String auxPeg) {
		if (n == 1) {
			System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
			return;
		}
		towersOfHanoi(n - 1, fromPeg, auxPeg, toPeg);
		System.out.println("Move disk from peg " + fromPeg + " to " + toPeg);
		towersOfHanoi(n - 1, auxPeg, toPeg, fromPeg);
	}

	public static void towersOfHanoi2(int disk, String fromPeg, String toPeg, String auxPeg) {
		if (disk == 1) {
			System.out.println("Move first disk from " + fromPeg + " to " + toPeg);
			return;
		} else {

			towersOfHanoi2(disk - 1, fromPeg, auxPeg, toPeg);
			System.out.println("Move disk from " + fromPeg + " to " + toPeg);
			towersOfHanoi2(disk - 1, auxPeg, toPeg, fromPeg);
		}
	}

	public static void main(String[] args) {
//		towersOfHanoi(3, "Base", "Destination", "Aux");
		towersOfHanoi2(3, "Base", "Destination", "Aux");
	}
}
