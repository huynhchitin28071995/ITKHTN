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
	
	public static void main(String[] args) {
		towersOfHanoi(3, "Base", "Destination", "Aux");
	}
}
