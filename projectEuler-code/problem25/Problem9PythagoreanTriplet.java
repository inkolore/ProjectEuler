package projectEuler.problem25;

public class Problem9PythagoreanTriplet {

	public static void main(String[] args) {
		// What can be improved :
		// Print only in order a < b < c
		
		int k = 1000;	// a + b + c = k = 1000 in our case
		for(int a = 1; a < k; a++) {
			int num = k * (2*a - k);
			int den = 2 * (a - k);
			if(((num * den) > 0) && ((num % den) == 0)) {	// b is a positive integer
				int b = num / den;
				int c = 1000 - a - b;
				System.out.printf("The triplet is given by %s %s %s.%n", a, b, c);
				System.out.println((a*a + b*b) == c*c);
			}
		}
	}

}
