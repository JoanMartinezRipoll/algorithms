package prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlmostPrimeNumbers {
	public static void main (String args[]) throws NumberFormatException, IOException {
	    /*
        A prime number is a natural number that has exactly two distinct natural number divisors,
        which are 1 and the prime number itself.
        The first prime numbers are: 2, 3, 5, 7, 11, 13.

        Almost prime numbers are the non-prime numbers
        which are divisible by only a single prime number.

        Please implement this method to
        return the number of almost prime numbers within the given range (inclusively).
       */
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("calculate prime numbers within the range (inclusively).");
		System.out.println("from:");
		int from = Integer.parseInt(is.readLine());
		System.out.println("to:");
		int to = Integer.parseInt(is.readLine());
		int count = countAlmostPrimeNumbers(from, to);
		System.out.println("There are " + count + " almost prime numbers");
	}

	public static int countAlmostPrimeNumbers(int from, int to) {
    
		int primes[] = new int[to];
		int primeCounter = 0;
		int counter = 0;
		for (int i = 0 ; i<=to; i++){
			if (isPrimeNumber(i)) {
				primes[primeCounter] = i;
				primeCounter++;
			}
			else {
				int primeDivisors = 0;
				for (int j = 0; j<primeCounter; j++) {
					if (primes[j] != 1 && i%primes[j] == 0 ) {
						primeDivisors++;
					}					
				}
				if (primeDivisors == 1) {
					counter ++;
				}
			}
		}
		return counter;
	    }
	
	
	  private static boolean isPrimeNumber(int num) {
		if (num == 2) return true;
		if (num%2 == 0) return false;
		for (int i = 3; i*i <=num ; i++ ) {
			if (num%i == 0 ) return false;
		}
		return true;
	}

}
