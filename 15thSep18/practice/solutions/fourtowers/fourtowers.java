// Arup Guha
// 9/7/2016
// Solution to 2013 NCNA Problem D: Four Tower Towers of Hanoi

import java.util.*;

public class fourtowers {

	final public static int MAX = 1000;
	public static long[] memo;

	public static void main(String[] args) {

		// Set up memo table - same for all cases.
		memo = new long[MAX+1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 3;

		Scanner stdin = new Scanner(System.in);
		int loop = 1;

		// Process each case.
		while (stdin.hasNext()) {

			// Get input.
			int n = stdin.nextInt();

			// Solve it.
			System.out.println("Case "+loop+": "+solve(n));

			// Go to the next case.
			loop++;
		}
	}

	// Solves the problem for n disks
	public static long solve(int n) {

		// Our base case.
		if (memo[n] != -1) return memo[n];

		// Our strategy is to solve for some number of disks k, leaving us n-k-1 disks
		// to solve using 3 towers. We know that we want n-k-1 <= 62.
		long res = -1;

		// left represents the number of disks left to solve for the 3 case.
		for (int left=1; left<=62 && left<n-1; left++) {
			long tmp = 2*(solve(n-1-left) + (1L << (left)) - 1) + 1;
			if (res == -1 || (tmp < res && tmp > 0))
				res = tmp;
		}

		// Store and return.
		memo[n] = res;
		return res;


	}
}