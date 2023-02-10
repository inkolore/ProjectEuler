package projectEuler.problem25;

import java.util.Arrays;

public class Problem12DivisibleTriangularNumber {

	public static int nbDivisors(int n) {
		int result = 0;
		int threshold = (int) Math.floor(Math.sqrt((double) n));
		
		for (int i = 1; i < threshold; i++) {
			if((n % i) == 0) {
				result += 2;
			}
		}
		// i = threshold
		if((threshold * threshold) == n) {
			result++;
		} else {	// threshold < sqrt(n) in this case
			if((n % threshold) == 0)
				result += 2;
		}
			
		return result;
	}
	
	public static int nbDivisors(int n, int[] storedResults) {
		// storeResults[i] stores nbDivisors(i), so 0 is never initialized
		if(n == 0) {
			System.out.println("Computing divisors of 0, error");
			return -5;
		}
		
		if((n >= 0) && (n < storedResults.length)) {
			if(storedResults[n] == (-1)) {		// Not computed yet
				storedResults[n] = nbDivisors(n);
				return storedResults[n];
			}
			return storedResults[n];
		}
		return nbDivisors(n);
	}
	
	public static void main(String[] args) {
		// Find value of first triangular number
		// with five hundred divisors (or more)
		
		// I'm going to use the fact that $T_n = n*(n+1)/2$ and that
		// n and n+1 are co-prime, so
		// d(T_n) = d(n/2) * d(n+1) if n even for example
		
		System.out.println(nbDivisors(1));
		System.out.println(nbDivisors(2));
		System.out.println(nbDivisors(6));
		System.out.println(nbDivisors(36));
		System.out.println(nbDivisors(27720));
		System.out.println(nbDivisors(76576500));
		
		
		int size_array = 20000 + 2;	// size of array for which I am keeping results
		int[] storeResults = new int[size_array];
		// storeResults[i] stores nbDivisors(i), so 0 is never initialized
		Arrays.fill(storeResults, -1);	// -1 to detect we haven't filled that yet
		
		int minNbDivisors = 500;
		int nbDiv;
		for (int i = 1; i < size_array; i++) {
			if((i % 2) == 0) {
				nbDiv = nbDivisors(i/2, storeResults) * nbDivisors(i+1, storeResults);
			} else {
				nbDiv = nbDivisors(i, storeResults) * nbDivisors((i+1)/2, storeResults);
			}
			
			if(nbDiv >= minNbDivisors) {
				System.out.println("The " + i + "-th triangular number solves the problem");
				System.out.printf("It is equal to %s %n", i*(i+1)/2 );
				System.out.println("It has " + nbDiv + " divisors");
				break;
			}
		}
		
		System.out.println("Done");
	}
}