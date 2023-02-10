package projectEuler.problem25;

public class Problem2SumEvenFibonacci {

	public static void main(String[] args) {
		int maxValue = 4_000_000;
		long sum = 0;
		
		// Naive solution of just computing sum and keeping
		// 2 current fibonacci numbers
		int f1 = 1;
		int f2 = 1;
		int indexToCompute = 3;	// Every 3rd Fibonacci number is even
		while(f2 < maxValue) {
			f2 = f1 + f2;
			f1 = f2 - f1;	// f1 becomes what used to be f2
			
			if((indexToCompute % 3) == 0) {
				sum += (long) f2;
			}
			indexToCompute++;
		}
		System.out.println(sum);
	}
}
