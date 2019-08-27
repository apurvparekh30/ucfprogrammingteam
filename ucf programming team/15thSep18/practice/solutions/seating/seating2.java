// Arup Guha
// 3/18/2014
// Alternate Solution to 2014 FHSPS Playoff Problem: Seating Arrangements(seating2)

import java.util.*;

public class seating2 {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process each case.
		for (int loop=0; loop<numCases; loop++) {
			int n = stdin.nextInt();
			System.out.println(solve(n,0,false));
		}
	}

	// Returns the number of solutions where the number of couples yet to be placed is couples,
	// the number of singles yet to be placed is singles, and last is true iff the previous
	// person placed was the first person of a new couple. 
	// This solution implicitly seats everyone in order from left to right.
	public static int solve(int couples, int singles, boolean last) {

		// Oops, can't seat a negative number of people.
		if (couples < 0 || singles < 0) return 0;
		
		// Everyone is sitting!
		if (couples == 0 && singles == 0) return 1;
		
	
		int sum = 0;
		
		// Place the first person from a couple.
		sum += solve(couples-1, singles+1, true);
		
		// Since the last person placed was a person from a new couple, their mate can't be placed
		// here. So, there are singles-1 choices of people to put in this slot.
		if (last)
			sum += ((singles-1)*solve(couples, singles-1, false));
			
		// Since last is false, the previous person is the last in a couple and ANY of the singles
		// can be placed here.
		else	
			sum += (singles*solve(couples, singles-1, false));
			
		return sum;
	}
}