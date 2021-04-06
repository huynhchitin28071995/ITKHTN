package search;

public class SearchAlgorithm {
	public static int unorderedLinearSearch(int[] a, int data) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == data)
				return i;
		}
		return -1;
	}

	public static int orderedLinearSearch(int[] a, int data) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == data)
				return i;
			else if (a[i] > data)
				return -1;
		}
		return -1;
	}

	// iterative Binary Search Algorithm
	public int binarySearchIterative(int[] a, int data) {
		int low = 0;
		int high = a.length - 1;
		int mid = low + (high - low) / 2;
		while (low <= high) {
			if (a[mid] == data)
				return mid;
			else if (a[mid] < data)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	// recursive binary search algorithm
	public int binarySearchRecursive(int[] a, int low, int high, int data) {
		int mid = low + (high - low) / 2;
		if (low > high)
			return -1;
		if (a[mid] == data)
			return mid;
		else if (a[mid] < data)
			return binarySearchRecursive(a, mid + 1, high, data);
		else
			return binarySearchRecursive(a, low, mid - 1, data);
	}
}
