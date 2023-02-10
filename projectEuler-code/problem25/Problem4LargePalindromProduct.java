package projectEuler.problem25;

import java.util.Arrays;
import projectEuler.general.NumberDigit;

public class Problem4LargePalindromProduct {
	
	public static void main(String[] args) {
		
		// Iterate in a diagonal fashion, decreasing
		int maxValue = 999;
		int x = maxValue;
		int y = maxValue;
		
		int product;
		int diag = 0;
		while(true) {
			product = x * y;
			if(NumberDigit.isPalindromic(product)) {
				break;
			}
			
			// Diagonal iteration
			if(x == maxValue) {
				diag++;
				x = maxValue - diag;
				y = maxValue;
			} else {
				x++;
				y--;
			}
		}
		
		// Check that the product found is indeed maximum, within the
		// contour line of x*y = product <-> y = product/x
		int xCheck, yCheck;
		int productCheck;
		for(yCheck = maxValue; yCheck >= (int) ((double)product / (double)maxValue); yCheck--) {
			for(xCheck = maxValue; xCheck >= (int) ((double)product / (double)yCheck); xCheck--) {
				// The area is not super optimal because I'm going over things I've already
				// computed, but at least it's 100% guaranteed
				productCheck = xCheck * yCheck;
				if(productCheck > product) {
					if(NumberDigit.isPalindromic(productCheck)) {
						System.out.println("The solution was not optimal");
						System.out.printf("New product : %s %n", productCheck);
						System.out.printf("x : %s, y : %s %n", xCheck, yCheck);
					}
				}
			}
		}
		
		System.out.printf("The two numbers are equal to %s and %s %n", x, y);
		System.out.printf("Their product is equal to %s %n", product);
	}

}
