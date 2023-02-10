package projectEuler.problem25;

import java.util.ArrayList;
import java.util.List;
import projectEuler.general.Prime;

public class Problem5SmallestMultiple {
	
	public static void main(String[] args) {
		// Smallest multiple of 1 to 20
		int maxNumber = 20;
		
		// Step 1 : List all prime numbers up to n = 20
		List<Integer> listPrime = new ArrayList<>();
		listPrime.add((Integer) 2);
		listPrime.add((Integer) 3);
		int p = 3;
		while(true) {
			p = Prime.computeNextPrime(listPrime);
			if(p > maxNumber) {
				break;
			} else {
				listPrime.add((Integer) p);
			}
		}
		
		// Step 2 : compute largest power of each prime that is <= n
		// and multiply those to obtain the smallestMultiple
		long smallestMultiple = 1;
		for(int prime : listPrime) {
			int power = 1;
			while((int) Math.pow((double)prime, (double)power) <= maxNumber) {
				power++;
			}
			power--;
			
			smallestMultiple *= (int) Math.pow((double)prime, (double)power);
		}
		
		System.out.printf("The smallest multiple is equal to %s %n", smallestMultiple);
	}
}
