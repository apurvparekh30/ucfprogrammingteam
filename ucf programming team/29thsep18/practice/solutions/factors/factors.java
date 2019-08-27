// Arup Guha
// 2/19/2016
// Solution to COP 4516 Final Individual Contest Problem: Factors

import java.util.*;

public class factors {

	final public static long LIMIT = 1000000000000000L;

	public static void main(String[] args) {

		// Useful to be able to look up - powers of 2 and 3.
		long[] pow2 = fillPow(2);
		long[] pow3 = fillPow(3);

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process each case.
		for (int loop=0; loop<numCases; loop++) {

			int n = stdin.nextInt();
			long res = LIMIT;

			// Try each way to break n into a product to two integers.
			for (int i=1; i*i<=n; i++) {
				if (n%i == 0) {

					// The exponent to 3 will always be less than or equal to the exponent to 2.
					// To have n factors, n = (e2+1)(e3+1) where e2 and e3 are the exponents to the two distinct prime factors.
					int exp3 = i-1;
					int exp2 = n/i-1;

					// Something is too big.
					if (exp3 >= pow3.length || exp2 >= pow2.length || pow3[exp3] == 0 || pow2[exp2] == 0) continue;
					if (pow2[exp2] > LIMIT/pow3[exp3]) continue;
					if (pow2[exp2]*pow3[exp3] > LIMIT) continue;

					// See if this way is better.
					res = Math.min(res, pow2[exp2]*pow3[exp3]);
				}
			}

			// Ta da!!!
			System.out.println(res);
		}
	}

	// Fills up an array of base raised to each power, up to a value of 10^15.
	public static long[] fillPow(int base) {
		long[] res = new long[64];
		res[0] = 1;
		for (int i=1; i<res.length; i++) {
			res[i] = base*res[i-1];
			if (res[i] > LIMIT) break;
		}
		return res;
	}
}