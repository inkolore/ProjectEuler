package projectEuler.problem25;

public class Problem19CountingSundays {

	public static boolean leapYear(int year) {
		if((year % 4) == 0) {
			if((year % 100) == 0) {
				if((year % 400) == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}
	
	public static int addedDay(int month, int year) {
		if(leapYear(year) && (month == 2)) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		/*
		 * How many Sundays fell on the first of the month during
		 * the twentieth century (1 Jan 1901 to 31 Dec 2000)?
		 * Info : 1 Jan 1900 was a Monday.
		 */
		
		int[] nbDaysMonth = {31, 28, 31, 30,	// January, February, etc.
							 31, 30, 31, 31,
							 30, 31, 30, 31};
		int day = 7;	// First Sunday : 7 Jan 1900
		int month = 1;	// not counted yet for 21st century though
		int year = 1900;
		
		int nbSundays = 0;
		while(year <= 2000) {
			if((year >= 1901) && (day == 1)) {
				nbSundays++;
			}
			
			// Increment by a week
			day += 7;
			int nbDaysThisMonth = nbDaysMonth[month - 1] + addedDay(month, year);
			if(day > nbDaysThisMonth) {
				month++;
				day = day % nbDaysThisMonth;
				
				if(month > 12) {
					year++;
					month = 1;
				}
			}
		}
		
		System.out.printf("The number of Sundays in the 21st century is equal to %s %n", nbSundays);
	}

}
