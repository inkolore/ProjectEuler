package projectEuler.general;

import java.util.ArrayList;
import java.util.List;

public class Prime {
	
	public static List<Integer> sieveEratosthenes(int threshold) {
		/*
		 * int threshold = (int) Math.sqrt((double) number);
		 * System.out.println(Integer.MAX_VALUE > threshold);
		 */
		
		List<Integer> sieveList = new ArrayList<>();
		List<Integer> primeList = new ArrayList<>();
		for(int i = 3; i <= threshold; i+=2) {
			// Add all odd numbers
			sieveList.add((Integer) i);
		}
				
		primeList.add(2);
		while(!sieveList.isEmpty()) {
			int prime = sieveList.get(0);
			primeList.add((Integer) prime);		// Using casting to indicate that it's an element
												// not an index
			sieveList.remove((Integer) prime);
			for(int j = prime*prime; j <= threshold; j += 2*prime) {
				// Remove all (odd) multiples of prime from the list
				// We only have to remove the odd multiples, since there are no even numbers
				// in our sieveList
				// Moreover, we can start at prime^2 because all multiples of prime before
				// have already been removed
				sieveList.remove((Integer) j);
			}
		}
		return primeList;
	}

	public static boolean coprimeList(int number, List<Integer> listNumber) {
		for(int divider : listNumber) {
			if((number % divider) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int computeNextPrime(List<Integer> computedPrimes) {
		// Assuming we already added 2 & 3 to the list
		// and that the list is ordered increasingly
		int returnNumber = computedPrimes.get(computedPrimes.size() - 1);
		while(!coprimeList(returnNumber, computedPrimes)) {
			returnNumber += 2;
		}
		return returnNumber;
	}
}
