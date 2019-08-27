// Arup Guha
// 4/19/2017
// Solution to COP 4516 Team Final Contest Problem: Double Farmland

import java.util.*;

public class doubleland {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process each case.
		for (int loop=0; loop<numCases; loop++) {

			// Get farm values and add them.
			int n = stdin.nextInt();
			int[] values = new int[n];
			int total = 0;
			for (int i=0; i<n; i++) {
				values[i] = stdin.nextInt();
				if (values[i] <= 0 || values[i] > 100000000) System.out.println("too big!!!");
				total += values[i];
			}

			// Set Danny's Mask - 1s in positions of the farms he wants.
			int dannyMask = 0;
			int numDanny = stdin.nextInt();
			for (int i=0; i<numDanny; i++)
				dannyMask |= (1 << (stdin.nextInt()-1));

			// Count total number of subsets that match and the ones that
			// Danny is happy with.
			int possible = 0, dannyWins = 0;

			// Try each subset.
			for (int mask=0; mask<(1<<n); mask++) {

				// Add up all of the farms in this subset.
				int thisSub = 0;
				for (int i=0; i<n; i++)
					if ((mask & (1<<i)) != 0)
						thisSub += values[i];

				// A possible subset of farms.
				if (2*thisSub == total) {
					possible++;

					// Danny is happy all of his farms are in this set!
					if ((mask & dannyMask) == dannyMask) dannyWins++;
				}
			}

			if (possible == 0) {
				System.out.println("impossible");
			}
			else {

				// Divide out gcd and print.
				int div = gcd(possible, dannyWins);
				System.out.println((dannyWins/div+"/"+(possible/div)));
			}
		}
	}

	// Returns the greatest common divisor of a and b.
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
}