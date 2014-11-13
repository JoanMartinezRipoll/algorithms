package prime;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrimeNumbers {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int number = Integer.parseInt(line);
		for (int i = 0; i < number; i++) {
			if (isPrime(i)) {
				System.out.println(i + ",");
			}
		}
	}

	public static boolean isPrime(int number) {
		if (number == 2) {
			return true;
		}

		else if (number == 1 || number % 2 == 0) {
			return false;
		}

		for (int i = 3; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}