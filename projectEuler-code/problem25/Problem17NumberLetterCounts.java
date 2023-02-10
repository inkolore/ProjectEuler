package projectEuler.problem25;

public class Problem17NumberLetterCounts {
	
	public static String numberToName(int number) {
		String[] name1to20 = {"zero",
							  "one", "two", "three", "four", "five",
				   			  "six", "seven", "eight", "nine", "ten",
				   			  "eleven", "twelve", "thirteen", "fourteen", "fifteen",
				   			  "sixteen", "seventeen", "eighteen", "nineteen"};
		String[] tens = {"",
						 "", "twenty", "thirty", "forty", "fifty",
				 		 "sixty", "seventy", "eighty", "ninety"};
		if ((number >= 0) && (number <= 19)) {
			return name1to20[number];
		} else if((number >= 20) && (number <= 99)) {
			int remainder = (number % 10);
			
			if(remainder == 0) {
				return tens[(number/10)];
			} else {
				String name = tens[(number/10)];
				name += "-" + name1to20[remainder];
				return name;
			}
		} else if((number >= 100) && (number <= 999)) {
			int remainder100 = (number % 100);
			
			if(remainder100 == 0) {
				return (name1to20[(number/100)] + " hundred");
			} else {
				String name = (name1to20[(number/100)] + " hundred and ");
				name += numberToName(remainder100);
				return name;
			}
		} else if(number == 1000) {
			return "One thousand";
		}
		System.out.println("En dehors de la zone acceptée");
		return null;
	}
	
	public static void mainTest(String[] args) {
		for(int i = 1; i <= 29; i++) {
			System.out.println(numberToName(i));
		}
		for(int i = 100; i <= 105; i++) {
			System.out.println(numberToName(i));
		}
		for(int i = 120; i <= 129; i++) {
			System.out.println(numberToName(i));
		}
		String name = numberToName(357);
		String nameEdited = name.replaceAll("[ -]+", "");
		System.out.println(name);
		System.out.println(nameEdited);
	}
	
	public static void main(String[] args) {
		int maxVal = 1000;
		
		int totalLetterCount = 0;
		for (int i = 1; i <= maxVal; i++) {
			String name = numberToName(i);
			// Don't take into account spaces or hyphens
			String nameEdited = name.replaceAll("[ -]+", "");
			
			totalLetterCount += nameEdited.length();
		}
		
		System.out.printf("The sum in total is equal to %s %n", totalLetterCount);
	}

	public static void mainOld(String[] args) {
		/*
		 * https://en.wikipedia.org/wiki/English_numerals
		 */
		
		// I don't need to assign each number its length,
		// I can count how many times "fourty" appears from 1 to 1000
		// for example, if that helps.
		
		int maxVal = 1000;	// Nothing implemented for tens of thousands and above
		
		// Observation 1 : if I compute 1-99, then 100-999 is done by appending
		// one hundred and (...)
		
		// Observation 2 : 20-99 are also done by appending,
		//since no need to count hyphens or space
		String[] digits = {"one", "two", "three", "four", "five",
						   "six", "seven", "eight", "nine"};
		String[] tens = {"twenty", "thirty", "fourty", "fifty",
						 "sixty", "seventy", "eighty", "ninety"};
		String[] tenPlusDigits = {"ten", "eleven", "twelve", "thirteen", "fourteen",
								  "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String hundred = "hundred";
		String and = "and";
		
		int digitLetterCount = 0;
		for(String sNumber : digits) {			// 1 - 9
			digitLetterCount += sNumber.length();
		}
		
		int less100LetterCount = digitLetterCount;
		for(String sNumber : tenPlusDigits) {	// 10 - 19
			less100LetterCount += sNumber.length();
		}
		for(String sNumber : tens) {			// 20 - 99
			// We use the word related to the 10 times
			// And then we append to 9 of those the 9 digts
			less100LetterCount += (10 * sNumber.length());
			less100LetterCount += digitLetterCount;
		}
		
		int totalLetterCount = less100LetterCount;
		for(String sNumber : digits) {			// 100 - 999
			// Reusing 1 - 99 to have (sNumber*100 + (1-99))
			totalLetterCount += (99 * (sNumber.length() + hundred.length() + and.length()));
			totalLetterCount += less100LetterCount;
			
			// 100, 200, ..., 900
			totalLetterCount += sNumber.length() + hundred.length();
		}
		
		System.out.printf("The sum in total is equal to %s %n", totalLetterCount);
	}
}
