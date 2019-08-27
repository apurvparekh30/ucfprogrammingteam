// Arup Guha
// 9/7/2016
// Solution to 2013 NCNA Problem C: One Move from Towers of Hanoi

import java.util.*;

public class towers {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		long k = stdin.nextLong();
		long n = stdin.nextLong();
		int loop = 1;

		// Process each case.
		while (k != 0) {

			// This is the recursive call we're interested in.
			System.out.println("Case "+loop+": "+solve(k, n, 0, 2));

			// Get next case.
			k = stdin.nextLong();
			n = stdin.nextLong();
			loop++;
		}
	}

	// Solves the problem for the moveNum th move with numDisks, when we are going from
	// startTower to endTower. (Code for towers is A = 0, B = 1, C = 2.
	public static String solve(long moveNum, long numDisks, int startTower, int endTower) {

		// Middle move is completely specified.
		if (moveNum == (1L << (numDisks-1)))
			return numDisks+" "+(char)('A'+startTower)+" "+(char)('A'+endTower);

		// Move is in first half, when we go from start to mid.
		else if (moveNum < (1L << (numDisks-1)))
			return solve(moveNum, numDisks-1, startTower, 3-startTower-endTower);

		// Move is in second half, from mid to end. Don't forget to subtract out first 1/2 moves...
		else
			return solve(moveNum-(1L << (numDisks-1)), numDisks-1, 3-startTower-endTower, endTower);
	}
}