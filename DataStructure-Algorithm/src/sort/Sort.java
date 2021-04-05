package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort {
	public static void bubbleSort(int[] a) {
		boolean swapped = true;
		for (int pass = a.length - 1; pass >= 0 && swapped; pass--) {
			swapped = false;
			for (int i = 0; i < pass; i++) {
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapped = true;
				}
			}
		}
		ArrayList<Integer> l = new ArrayList<>();
		l.add(0);
		l.add(2);
		l.add(1);
		l.add(3);
		Collections.sort(l);
		System.out.println(l);
	}

	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	public static void insertionSort(int[] a) {
		int i, j, temp;
		for (i = 1; i < a.length; i++) {
			temp = a[i];
			for (j = i; j >= 1 && a[j - 1] > temp; j--) {
				a[j] = a[j - 1];
			}
			a[j] = temp;
		}
	}

	public static void shellSort(int[] a) {
		int i, j, h, temp;
		h = 1;
		while (h < a.length) {
			h = 3 * h;
		}
		for (; h > 0; h = h / 3) {
			for (i = h + 1; i < a.length; i++) {
				temp = a[i];
				for (j = i; j >= 1 && a[j - 1] > temp; j--) {
					a[j] = a[j - 1];
				}
				a[j] = temp;
			}
		}
	}

	public static void mergeSort(int[] a, int[] temp, int left, int mid, int right) {
		int i, leftEnd, size, tempPos;
		leftEnd = mid - 1;
		tempPos = left;
		size = right - left + 1;
		while ((left <= leftEnd) && (mid <= right)) {
			if (a[left] <= a[mid]) {
				temp[tempPos] = a[left];
				tempPos++;
				left++;
			} else {
				temp[tempPos] = a[mid];
				tempPos++;
				mid++;
			}
		}
		while (left <= leftEnd) {
			temp[tempPos] = a[left];
			left++;
			tempPos++;
		}
		while (mid <= right) {
			temp[tempPos] = a[mid];
			mid++;
			tempPos++;
		}
		for (i = 0; i <= size; i++) {
			a[right] = temp[right];
			right--;
		}
	}

	public static void quickSort(int[] a, int low, int high) {
		int pivot;
		if (high > low) {
			pivot = partition(a, low, high);
			quickSort(a, low, pivot - 1);
			quickSort(a, pivot + 1, high);
		}
	}

	private static int partition(int[] a, int low, int high) {
		int left = low;
		int pivotItem = a[low];
		int right = high;
		while (left < right) {
			while (a[left] < pivotItem)
				left++;
			while (a[right] > pivotItem)
				right--;
			if (left < right)
				swap(a, left, right);
		}
		a[low] = a[right];
		a[right] = pivotItem;
		System.out.println(Arrays.toString(a));
		return right;
	}

	private static void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 5, 7, 3, 4, 6, 2, 1, 9, 8, 0 };
//		bubbleSort(a);
//		selectionSort(a);
//		insertionSort(a);
//		shellSort(a);
//		mergeSort(a);
		System.out.println("Start: " + Arrays.toString(a));
		quickSort(a, 0, 9);
		System.out.println("End: " + Arrays.toString(a));
	}

}
