import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Stupid {
	public static void main(String[] args) throws Exception {
		List<Integer> arr = new ArrayList<Integer>(); // collections can't store primitive types (object-based) so Integer used instead of int. Additionally, generics can't represent primitive types. Also uses Java 7 type inference.
		Scanner s = new Scanner(System.in); // new scanner: a simple text scanner which can parse primitive types
		while (s.hasNextInt()) { // while scanner has an integer to read
			arr.add(s.nextInt()); // add integer (int is autoboxed to Integer and added)
		}
		int solution[] = new int[arr.size()];
		for (Integer i : arr) {
			solution[i]++;
		}

		String sol = Arrays.toString(solution);
		sol = sol.substring(1, sol.length() - 1);
		System.out.println(sol);
	}
}
