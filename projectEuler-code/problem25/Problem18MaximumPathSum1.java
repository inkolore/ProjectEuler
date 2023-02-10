package projectEuler.problem25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem18MaximumPathSum1 {

	public static void main(String[] args) {
		
		try {
			String filePath = new File("").getAbsolutePath();
			// Read file
			File myObj = new File(filePath.concat("/src/projectEuler/resources/18MaximumPathSum.txt"));
			Scanner myReader = new Scanner(myObj);

			int nbLines = 15;
			int[][] arrays = new int[nbLines][];
			for(int i = 0; i < nbLines; i++) {
				arrays[i] = new int[i+1];
				System.out.println(arrays[i].length);
			}
			System.out.println(arrays.length);
			
			int curLine = 0;
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] words = line.split(" ");
				for (int j = 0; j < words.length; j++) {
					arrays[curLine][j] = Integer.parseInt(words[j]);
				}
				curLine++;
			}
			
			int[] adjacentRowBelow = new int[2];
			for(int l = nbLines - 2; l >= 0; l--) {
				for(int col = 0; col <= l; col++) {
					adjacentRowBelow[0] = arrays[l+1][col];
					adjacentRowBelow[1] = arrays[l+1][col+1];
					int maxBelow = Math.max(adjacentRowBelow[0], adjacentRowBelow[1]);
					
					arrays[l][col] += maxBelow;
				}
			}
			System.out.printf("The maximum sum is equal to %s %n", arrays[0][0]);
			
			myReader.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
