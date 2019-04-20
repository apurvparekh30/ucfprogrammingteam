// Arup Guha
// 2/11/2015
// Solution to COP 2016 Spring 4516 Individual Contest Final Exam

import java.util.*;

public class steps {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int[][] adj = new int[n][n];

		// Read in the all of the relevant distances.
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				adj[i][j] = stdin.nextInt();

		// Process each case.
		int numCases = stdin.nextInt();
		for (int loop=0; loop<numCases; loop++) {

			// Store path.
			char[] walk = stdin.next().toCharArray();

			// Add each edge in; just convert letters to numbers 0 - 25.
			int distance = 0;
			for (int i=0; i<walk.length-1; i++)
				distance += adj[walk[i]-'A'][walk[i+1]-'A'];

			// Print result.
			System.out.println(distance);
		}
	}
}