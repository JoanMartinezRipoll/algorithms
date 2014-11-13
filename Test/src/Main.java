

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int number = Integer.parseInt(line);
		System.out.println(getNumberOfPrimes(number));
	}

	static int getNumberOfPrimes(int N) {
		int result = 0;
		for (int number = 2; number < N; number++) {
			boolean isPrime = true;
			if (number != 2 && number % 2 == 0) {
				isPrime = false;
			} else {
				for (int i = 3; i * i <= number; i++) {
					if (number % i == 0) {
						isPrime = false;
						break;
					}
				}
			}
			if (isPrime) {
				result++;
			}
		}
		return result;
	}

}
