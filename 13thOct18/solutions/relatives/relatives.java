// Arup Guha
// 6/3/2013
// Solution to 2006 World Finals Problem I: Degrees of Separation

import java.util.*;

public class relatives {
	
	// Okay for this problem.
	final public static int NO_EDGE = 100;
	
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		
		int n = stdin.nextInt();
		int e = stdin.nextInt();
		int loop = 1;
		
		// Go through cases.
		while (n != 0) {
			
			// Store all data.
			HashMap<String,Integer> lookup = new HashMap<String,Integer>();
			int[][] adj = new int[n][n];
			for (int i=0; i<n; i++) {
				Arrays.fill(adj[i], NO_EDGE);
				adj[i][i] = 0;
			}
			int index = 0;
			
			// Read in graph.
			for (int i=0; i<e; i++) {
				
				// Read in names.
				String a = stdin.next();
				String b = stdin.next();
				
				// Add to list if necessary.
				if (!lookup.containsKey(a)) lookup.put(a, index++);
				if (!lookup.containsKey(b)) lookup.put(b, index++);
				
				// Add edge to graph.
				int v1 = lookup.get(a);
				int v2 = lookup.get(b);
				adj[v1][v2] = 1;
				adj[v2][v1] = 1;
			}
			
			// Solve and output.
			int girth = solve(adj);
			if (girth > n)
				System.out.println("Network "+loop+": DISCONNECTED");
			else
				System.out.println("Network "+loop+": "+girth);
			System.out.println();			
			
			// Get next case.
			n = stdin.nextInt();
			e = stdin.nextInt();
			loop++;
		}
	}
	
	public static int solve(int[][] adj) {
		
		int n = adj.length;
		
		// Run Basic Floyds - no need to preserve matrix.
		for (int k=0; k<n; k++)
			for (int i=0; i<n; i++)
				for (int j=0; j<n; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
	
		// Get girth.
		int max = 0;
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				if (adj[i][j] > max)
					max = adj[i][j];
					
		return max;
	}
}