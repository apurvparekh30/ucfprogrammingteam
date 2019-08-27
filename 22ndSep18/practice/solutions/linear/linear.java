// Arup Guha
// 2/9/2017
// Solution to COP4516 Final Individual Contest Question: Linear Equation Solver

import java.util.*;
import java.math.*;

public class linear {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process each case.
		for (int loop=0; loop<numCases; loop++) {

			// Get input - being lazy to use modInverse =)
			BigInteger a = new BigInteger(stdin.next());
			BigInteger b = new BigInteger(stdin.next());
			long low = stdin.nextInt();
			long high = stdin.nextInt();

			long x = a.modInverse(b).longValue();

			long[] below = moddiv(low, b.longValue());
			long[] above = moddiv(high, b.longValue());

			// Smallest the answer could be.
			long res = above[0] - below[0] - 1;

			// Include low boundary point.
			if (below[1] <= x) res++;

			// Include high boundary point.
			if (x <= above[1]) res++;

			// Ta da!
			System.out.println(res);
		}
	}

	// b > 0
	public static long[] moddiv(long a, long b) {

		long[] res = new long[2];

		// Non-neg and perfect division cases are regular.
		if (a >= 0 || a%b == 0) {
			res[0] = a/b;
			res[1] = a%b;
		}

		// Annoying case (neg with mod)
		else {
			res[0] = a/b-1;
			res[1] = a%b + b;
		}
		return res;
	}
}