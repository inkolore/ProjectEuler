package projectEuler.general;

import java.util.Arrays;

public class NumberDigit {

	public static int[] numberToArray(int number) {
		int numLength = (int) Math.log10((double) number) + 1;
		int[] numAsArray = new int[numLength];
		Arrays.fill(numAsArray, 0);
		
		int remainingNum = number;
		// Turn the number as an array of digits
		for (int i = 0; i < numLength; i++) {
			int power = numLength - i - 1;
			int power10 = (int)Math.pow(10.0, (double)power);
			
			numAsArray[i] = remainingNum / power10;
			remainingNum = remainingNum % power10;
		}
		
		return numAsArray;
	}
	
	public static boolean isPalindromic(int[] numberArray) {
		int numLength = numberArray.length;
		
		// Check if array of digits is symmetric
		for (int i = 0; i < (numLength/2); i++) {
			// We don't need to check the middle digit
			if(numberArray[i] != numberArray[numLength - i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindromic(int number) {
		int[] numberArray = numberToArray(number);
		return(isPalindromic(numberArray));
	}
}
