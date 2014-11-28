package prime;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IsPrime {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int number = Integer.parseInt(line);
		if (isPrime(number)) {
			System.out.println("It's prime");
		} else {
			System.out.println("It's not prime");
		}
	}

	public static boolean isPrime(int number) {
		if (number % 2 == 0) {
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