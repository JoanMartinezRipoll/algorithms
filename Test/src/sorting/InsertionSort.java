package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String args[]) {
		List<Integer> arr = new ArrayList<Integer>(); // collections can't store primitive types (object-based) so Integer used instead of int. Additionally, generics can't represent primitive types. Also uses Java 7 type inference.
		Scanner s = new Scanner(System.in); // new scanner: a simple text scanner which can parse primitive types
		while (s.hasNextInt()) { // while scanner has an integer to read
			arr.add(s.nextInt()); // add integer (int is autoboxed to Integer and added)
		}
		Integer array[] = new Integer[arr.size()];
		arr.toArray(array);
		insertionSort(array);
		array.toString();
	}

	public static void insertionSort(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			int j;
			for (j = i - 1; j >= 0 && array[j] > current; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = current;
		}
	}
}
