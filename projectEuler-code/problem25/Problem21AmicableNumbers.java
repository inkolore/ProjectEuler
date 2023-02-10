package projectEuler.problem25;

import java.util.ArrayList;
import java.util.List;

public class Problem21AmicableNumbers {

	public static int strictDivisorsSum(int n) {
		int sum = 0;
		int threshold = (int) Math.sqrt((double) n);
		
		for (int i = 2; i <= threshold; i++) {
			// If i divides n, then so does (n / i)
			if((n % i) == 0) {
				if(i != threshold) {
					sum += i;
					sum += (n / i);
				} else {
					sum += threshold;	// Square number
				}
				
			}
		}
		sum += 1;					// 1 is always a divisor
		
		return sum;
	}
	
	public static void mainTest(String[] args) {
		
		System.out.println(strictDivisorsSum(1));
		System.out.println(strictDivisorsSum(2));
		System.out.println(strictDivisorsSum(6));
		System.out.println(strictDivisorsSum(36));
		System.out.println(strictDivisorsSum(220));
		System.out.println(strictDivisorsSum(284));
	}

	public static void main(String[] args) {
		int maxNumber = 10000;
		int[] storedResults = new int[maxNumber + 1];
		// Compute all results
		for(int i = 1; i <= maxNumber; i++) {
			storedResults[i] = strictDivisorsSum(i);
		}
		
		// Check for amicable pairs
		int sumAmicable = 0;
		List<Integer> listAmicable = new ArrayList<>();
		for(int i = 1; i <= maxNumber; i++) {
			int di = storedResults[i];
			if(i != di) {
				if((di <= maxNumber) && (storedResults[di] == i)) {
					sumAmicable += i;
					listAmicable.add((Integer) i);
				}
			}
		}
		
		System.out.printf("The sum of amicable numbers is equal to %s %n", sumAmicable);
		System.out.println(listAmicable);
	}
}
