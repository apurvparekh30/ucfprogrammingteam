// Arup Guha
// 5/5/2015
// Solution to FHSPS Problem: Swan Boats

import java.util.*;

public class swan {

	final public static int RADIUS = 1000;

	public static int n;
	public static pt[] loc;
	public static double speed;
	public static double[][] times;

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Go through each case.
		for (int loop=0; loop<numCases; loop++) {

			// Read in the parameters for this case.
			// Store starting point at end of array.
			n = stdin.nextInt();
			loc = new pt[n+1];
			loc[n] = new pt(stdin.nextInt()*Math.PI/180, RADIUS);
			speed = stdin.nextDouble();

			// And the locations to visit.
			for (int i=0; i<n; i++) {
				int dist = stdin.nextInt();
				int angle = stdin.nextInt();
				loc[i] = new pt(angle*Math.PI/180, dist);
			}

			// Make this look up table to avoid sqrt over and over agian.
			times = new double[n+1][n+1];
			for (int i=0; i<n+1; i++)
				for (int j=0; j<n+1; j++)
					times[i][j] = loc[i].dist(loc[j])/speed;

			// Set up permutation algorithm.
			boolean[] used = new boolean[n];
			int[] perm = new int[n];

			// Solve and output.
			double res = solve(0, used, perm);
			System.out.printf("%.2f\n", res);
		}
	}

	public static double solve(int k, boolean[] used, int[] perm) {

		// Base case - filled in perm.
		if (k == n) return eval(perm);

		// Recursive case.
		else {

			// This should be good enough...
			double res = 2*RADIUS*(n+20);

			for (int i=0; i<n; i++) {
				if (!used[i]) {
					used[i] = true;
					perm[k] = i;
					res = Math.min(res, solve(k+1, used, perm));
					used[i] = false;
				}
			}

			// Here is our answer.
			return res;
		}
	}

	public static double eval(int[] perm) {

		// Go from start point to first landmark.
		double res = times[n][perm[0]];

		// Go to the rest of the landmarks.
		for (int i=1; i<n; i++)
			res += times[perm[i-1]][perm[i]];

		// Come back home and return.
		res += times[perm[n-1]][n];
		return res;
	}
}

class pt {

	public double angle;
	public double mag;
	public double x;
	public double y;

	// Sets up object with all relevant information.
	public pt(double myAngle, double myMag) {
		angle = myAngle;
		mag = myMag;
		x = mag*Math.cos(angle);
		y = mag*Math.sin(angle);
	}

	// Gets the distance between objects.
	public double dist(pt other) {
		return Math.sqrt((x-other.x)*(x-other.x)+(y-other.y)*(y-other.y));
	}
}
