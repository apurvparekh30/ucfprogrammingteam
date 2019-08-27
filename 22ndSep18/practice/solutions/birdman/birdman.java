// Arup Guha
// April 9, 2014
// Solution to 2002 UCF High School Contest Problem Birdman of Waikiki

import java.util.*;

public class birdman {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process all cases.
		for (int loop=0; loop<numCases; loop++) {

			// Read in data.
			int[] data = new int[8];
			for (int i=0; i<8; i++)
				data[i] = stdin.nextInt();

			// Create our two segments.
			seg seg1 = new seg(new pt(data[0], data[1]), new pt(data[2], data[3]));
			seg seg2 = new seg(new pt(data[4], data[5]), new pt(data[6], data[7]));

			// Determine if there's an intersection.
			if (seg1.intersect(seg2))
				System.out.println("Move to the left or right!");
			else
				System.out.println("Good picture, Birdman!");
		}
	}
}

class pt {

	public int x;
	public int y;

	public pt(int myx, int myy) {
		x = myx;
		y = myy;
	}

	public pt getVector(pt other) {
		return new pt(other.x-x, other.y-y);
	}

	public double crossMag(pt other) {
		return x*other.y - other.x*y;
	}
}

class seg {

	final public static double EPSILON = 1e-9;
	public pt start;
	public pt end;
	public pt dir;

	public seg(pt s, pt e) {
		start = s;
		end = e;
		dir = start.getVector(end);
	}

	// Returns true iff other intersects this.
	public boolean intersect(seg other) {

		// Denominator for system of equations set up for line intersection.
		double den = det(dir.x, -other.dir.x, dir.y, -other.dir.y);

		// Parallel lines case.
		if (den == 0) {

			// Check for case where lines are NOT coincidental.
			pt vect = start.getVector(other.start);
			if (vect.crossMag(dir) != 0) return false;

			// Coincidental lines, so we must see if the segments overlap at all.
			double lambda1 = getLambda(other.start);
			double lambda2 = getLambda(other.end);
			return !((lambda1 > 1 && lambda2 > 1) || (lambda1 < 0 && lambda2 < 0));
		}

		// Typical case.
		double num1 = det(other.start.x-start.x, -other.dir.x, other.start.y-start.y, -other.dir.y);
		double num2 = det(dir.x, other.start.x-start.x, dir.y, other.start.y-start.y);

		// Segments intersect iff both lambda values are in between 0 and 1.
		return -EPSILON <= num1/den && num1/den <= 1+EPSILON && -EPSILON <= num2/den && num2/den <= 1+EPSILON;
	}

	public static double det(double a, double b, double c, double d) {
		return a*d - b*c;
	}

	// dest must be on this segment.
	public double getLambda(pt dest) {

		// Make sure we don't divide by 0.
		if (dir.x != 0)
			return 1.0*(dest.x - start.x)/dir.x;

		// Use only if dx is 0...we assume no directional vector is 0.
		else
			return 1.0*(dest.y - start.y)/dir.y;
	}
}