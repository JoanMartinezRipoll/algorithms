package prime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPrimeFactor {
	public static int largestPrimeFactor(long number) {
		int i = 2;
		while (i <= number) {
			if (number % i == 0) {
				number = number / i;
				System.out.println("Prime" + i);
				System.out.println("Number" + number);
			} else {
				i++;
			}
		}
		return i;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		long number = Long.parseLong(line);
		System.out.println(largestPrimeFactor(number));
	}
}