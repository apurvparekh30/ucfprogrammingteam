// Arup Guha
// 3/11/2015
// Solution to UCF HS Problem: The Little Bird

import java.util.*;

public class bird {

	final public static double EPSILON = 1e-9;

	public static void main(String[] args) {

		// Get number of cases.
		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process cases.
		for (int loop=1; loop<=numCases; loop++) {

			int distance = stdin.nextInt();
			int numPts = stdin.nextInt();

			// Create pts.
			pt[] pts = new pt[numPts];
			for (int i=0; i<numPts; i++) {
				int x = stdin.nextInt();
				int y = stdin.nextInt();
				pts[i] = new pt(x,y);
			}

			// Initialize with distance to last line segment.
			double res = distOriginToLineSeg(pts[0], pts[numPts-1]);
			for (int i=0; i<numPts-1; i++)
				res = Math.min(res, distOriginToLineSeg(pts[i], pts[i+1]));

			// It's safe.
			if (res < distance-EPSILON)
				System.out.println("Yard #"+loop+": Better not risk it.");

			// No it's not...
			else
				System.out.println("Yard #"+loop+": Fly away!");
		}
	}

	public static double distOriginToLineSeg(pt start, pt end) {

		// First guess is based on closer end point.
		double res = Math.min(start.distFromOrigin(), end.distFromOrigin());

		// Direction of movement.
		pt dir = new pt(end.x-start.x, end.y-start.y);

		// Denominator when you solve system of vector equations for line intersection
		// between segment and perpendicular line from origin.
		// Perpendicular vector to line is (dy, -dx). So for parameter t pt is (dy*t, -dx*t).
		double den = det(dir.x, -dir.y, dir.y, dir.x);

		// Numerator for same equation - solution is parameter on line segment.
		double num = det(-start.x, -dir.y, -start.y, dir.x);

		// Safe since we'll never have a zero vector for our line segment.
		double lambda = num/den;

		// Shortest point to line is on segment.
		if (lambda > -EPSILON && lambda < 1+EPSILON)
			res = (new pt(start.x+lambda*dir.x, start.y+lambda*dir.y)).distFromOrigin();

		// This is our shortest.
		return res;
	}

	// Usual 2 x 2 determinant.
	public static double det(double a, double b, double c, double d) {
		return a*d - b*c;
	}
}

class pt {

	public double x;
	public double y;

	public pt(double myx, double myy) {
		x = myx;
		y = myy;
	}

	public double distFromOrigin() {
		return Math.sqrt(x*x + y*y);
	}
}