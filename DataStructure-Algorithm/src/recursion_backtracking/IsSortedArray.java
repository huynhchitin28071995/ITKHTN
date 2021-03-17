package recursion_backtracking;

public class IsSortedArray {

	public static int isSorted(int[] array, int index) {
//		System.out.println(index);
		if (index == 1) { // base case/terminate case
			return 1;
		}
		return (array[index - 1] < array[index - 2]) ? 0 : isSorted(array, index - 1); // return 0 is also base case,
																						// since it returns and stops.
	}

	public static int isSorted2(int[] array, int length) {
		if (length == 1)
			return 1; // base case
		if (array[length - 1] < array[length - 2]) {
			return 0; // base case
		} else {
			return isSorted2(array, length - 1); // cursive case
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 4, 5 };
		int[] array1 = { 5, 4, 3, 2, 1 };
		System.out.println(isSorted(array, array.length));
		System.out.println(isSorted2(array, array.length));
		System.out.println(isSorted(array1, array1.length));

	}
}
