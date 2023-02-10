package projectEuler.problem25;

import java.util.List;

public class Problem7_10001prime {
	
	public static boolean coprimeArray(int number, int[] listNumber, int indexMax) {
		for (int i = 0; i < indexMax; i++) {
			if((number % listNumber[i]) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int indexPrime = 10001;
		// Using same algorithm as in general.Prime but with a fixed-size array
		// Int overflow is definitely an issue to think about, but here
		// I'm just trying something with int's first
		int[] primeList = new int[indexPrime];
		primeList[0] = 2;
		primeList[1] = 3;
		
		for(int i = 2; i < indexPrime; i++) {
			int p = primeList[i-1] + 2;
			while(!coprimeArray(p, primeList, i)) {
				p += 2;
			}
			
			primeList[i] = p;
		}
		
		System.out.printf("The desired prime is equal to %s %n", primeList[indexPrime - 1]);
	}
}
