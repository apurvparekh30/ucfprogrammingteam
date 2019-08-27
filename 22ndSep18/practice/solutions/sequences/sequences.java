// Arup Guha
// 2/9/2017
// Solution to COP4516 Final Individual Contest Question: Adding Sequences

import java.util.*;

public class sequences {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process each case.
		for (int loop=0; loop<numCases; loop++) {

			int n = stdin.nextInt();
			int iter = stdin.nextInt();

			// Read in the sequence.
			int[] vals = new int[n];
			for (int i=0; i<n; i++)
				vals[i] = stdin.nextInt();

			// Run addition process iter times.
			for (int i=0; i<iter; i++)
				vals = add(vals);

			// Output sequence.
			for (int i=0; i<vals.length; i++)
				System.out.print(vals[i]+" ");
			System.out.println();
		}
	}

	// Returns S(k+1) given S(k).
	public static int[] add(int[] arr) {
		int[] res = new int[arr.length-1];
		for (int i=0; i<res.length; i++)
			res[i] = arr[i] + arr[i+1];
		return res;
	}
}