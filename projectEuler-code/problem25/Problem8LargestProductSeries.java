package projectEuler.problem25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem8LargestProductSeries {

	public static void main(String[] args) {
		
		try {
			String filePath = new File("").getAbsolutePath();
			// Read file
			File myObj = new File(filePath.concat("/src/projectEuler/resources/8LargeNumber.txt"));
			Scanner myReader = new Scanner(myObj);
			
			int sizeNumber = 1000;	// It's not necessary to store whole number
									// but it's just more convenient
			int[] numberArray = new int[sizeNumber];
			int sizeProduct = 13;
			long product;		// 9^13 is smaller than long limit
			
			// Store number as an array of ints
			int indexNumber = 0;
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				//System.out.println(line);
				for(int i = 0; i < line.length(); i++) {
					numberArray[indexNumber] = Character.getNumericValue(line.charAt(i));
					indexNumber++;
				}
			}
			
			// Go over the number and skip whenever there is a 0
			// Index I'm iterating over is the END point of the product
			
			myReader.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
