// Arup Guha
// 8/31/2013
// Solution to 2013 UCF Locals Problem: Minion

import java.util.*;
import java.io.*;

public class minion {

	public static void main(String[] args) throws Exception {

		Scanner stdin = new Scanner(new File("minion.in"));
		int numCases = stdin.nextInt();

		// Process each case.
		for (int loop=0; loop<numCases; loop++) {

			// Get illegal items.
			int numCantUse = stdin.nextInt();
			HashSet<String> cantuse = new HashSet<String>();
			for (int i=0; i<numCantUse; i++)
				cantuse.add(stdin.next());

			// Read in the graph.
			int n = stdin.nextInt();
			int e = stdin.nextInt();
			int[][] adj = new int[n][n];
			for (int i=0; i<e; i++) {
				int u = stdin.nextInt();
				int v = stdin.nextInt();
				String s = stdin.next();

				// Only fill this in if we can traverse the edge.
				if (!cantuse.contains(s)) {
					adj[u][v] = 1;
					adj[v][u] = 1;
				}
			}

			// Set up DFS, call and return.
			boolean[] used = new boolean[n];
			System.out.println(dfs(adj, 0, used));
		}

		stdin.close();
	}

	public static int dfs(int[][] adj, int start, boolean[] used) {

		int n = adj.length;

		// We reached the end.
		if (start == n-1) return 1;

		// Mark that we've gone here.
		used[start] = true;

		// Try all the neighbors. If any get us to the end, return 1.
		for (int i=0; i<n; i++)
			if (!used[i] && adj[start][i] == 1)
				if (dfs(adj, i, used) == 1)
					return 1;

		// Never got to the end.
		return 0;
	}
}