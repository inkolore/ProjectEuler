package projectEuler.problem25;

import java.util.ArrayList;
import java.util.List;

public class Problem24LexicographicPermutations {

	public static int factorial(int n) {
		int product = 1;
		for(int i = n; i >= 1; i--) {
			product *= i;
		}
		return product;
	}
	
	public static void main(String[] args) {
		
		int remainingNumber = 1000000;
		remainingNumber --;	// -1 because arrays start at 0
		int nbDigits = 10;
		// 9! is below int max value so it's okay
		
		List<Integer> remainingDigits = new ArrayList<>();
		for(int i = 0; i < nbDigits; i++) {
			remainingDigits.add((Integer) i);
		}
		
		int[] permutation = new int[nbDigits];
		for(int i = 0; i < nbDigits; i++) {
			int factorial = factorial(nbDigits - i - 1);
			
			int indexDigit = remainingNumber / factorial;
			permutation[i] = remainingDigits.get(indexDigit);
			remainingDigits.remove(indexDigit);
			
			remainingNumber = remainingNumber % factorial;
		}

		System.out.println("The permutation is given by");
		for(int j = 0; j < nbDigits; j++) {
			System.err.printf("%s ", permutation[j]);
		}
	}

}
