package projectEuler.problem25;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem13LargeSum {
	public static void main2(String[] args) {
		int[] numTemp = {9, 9};
		int[] numTotal = {1, 0, 9, 9};
		addAndCarry(numTotal, numTemp);
		System.out.println(Arrays.toString(numTotal));
		
		// What if the carry is a two digit number ?
		// Never the case here because I do it 2-by-2
	}

	public static void addAndCarry(int[] totalSum, int[] tempLine) {
		int nbDigits = tempLine.length;
		int nbDigitsMax = totalSum.length;
		int diffIndices = nbDigitsMax - nbDigits;
			
		int carry = 0;
		// A digit by digit, starting from end (digits of lowest power)
		for(int i = (nbDigitsMax - 1); i >= diffIndices; i--) {
			totalSum[i] += tempLine[i - diffIndices] + carry;
			
			if(totalSum[i] >= 10) {
				carry = totalSum[i] / 10;
				totalSum[i] = totalSum[i] % 10;
			} else {
				carry = 0;
			}
		}
		// On dépasse de la longueur du premier terme
		for(int i = (diffIndices - 1); i >= 0; i--) {
			totalSum[i] += carry;
			
			if(totalSum[i] >= 10) {
				carry = totalSum[i] / 10;
				totalSum[i] = totalSum[i] % 10;
			} else {
				carry = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		/* Sum of 100 numbers with 50 digits
		 * Immediate problem : each number is above INT_MAXVALUE
		 * Let alone their sum
		*/
		
		/*
		 * Current idea : do addition digit by digit, one line at a time
		 * I will use arrays of ints, not bytes, bc can't be bothered with the
		 * annoying auto conversion from byte to ints during arithmetic
		 */
		int nbDigits = 50;
		int nbTerms = 100;
		int nbDigitsMax = nbDigits + (int) Math.log10((double) nbTerms);
		System.out.println("Answer has maximum " + nbDigitsMax + " digits.");
		
		int[] totalSum = new int[nbDigitsMax];
		Arrays.fill(totalSum, 0);
		int[] tempLine = new int[nbDigits];
		
		try {	
			String filePath = new File("").getAbsolutePath();
			
			// Read file
			File myObj = new File(filePath.concat("/src/projectEuler/13LargeSum.txt"));
			Scanner myReader = new Scanner(myObj);
			
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				for(int i = 0; i < line.length(); i++) {
					tempLine[i] = Character.getNumericValue(line.charAt(i));
				}
				addAndCarry(totalSum, tempLine);
			}
			// Print final result
			for(int i = 0; i < tempLine.length; i++) {
				System.out.printf("%s", totalSum[i]);
			}
			System.out.println("");
			
			myReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
