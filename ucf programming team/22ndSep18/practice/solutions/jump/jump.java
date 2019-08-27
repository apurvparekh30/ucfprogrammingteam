// Arup Guha
// 2/22/2016
// Solution to COP 4516 Final Individual Contest Problem: Jump

import java.util.*;

public class jump {

	public static int n;
	public static int[] blocks;
	public static int up;
	public static int down;

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process each case.
		for (int loop=0; loop<numCases; loop++) {

			// Get all the data for the case.
			n = stdin.nextInt();
			blocks = new int[n];
			for (int i=0; i<n; i++)
				blocks[i] = stdin.nextInt();
			up = stdin.nextInt();
			down = stdin.nextInt();

			// Solve and output result.
			boolean[] used = new boolean[n];
			int[] perm = new int[n];
			System.out.println(solve(0, perm, used));
		}
	}

	public static int solve(int k, int[] perm, boolean[] used) {

		// If we get this far, we can make it.
		if (k == n) return 1;

		int total = 0;

		// Try each possible unused block in slot k.
		for (int i=0; i<n; i++) {

			// Three conditions under which we can't put block i in this position.
			if (used[i]) continue;
			if (k > 0 && blocks[i] > blocks[perm[k-1]] && blocks[i]-blocks[perm[k-1]] > up) continue;
			if (k > 0 && blocks[i] < blocks[perm[k-1]] && blocks[perm[k-1]]-blocks[i] > down) continue;

			// Put item i in slot k.
			used[i] = true;
			perm[k] = i;

			// Add in all solutions by placing item i in slot k.
			total += solve(k+1, perm, used);

			// Unmark item i.
			used[i] = false;
		}

		return total;
	}
}