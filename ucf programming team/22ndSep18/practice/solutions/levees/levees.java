// Arup Guha
// 6/26/2012
// Solution to Southeast Regional Problem D: Shoring up the Levees

import java.util.*;

class lineseg {

	public double[] A;
	public double[] B;

	public lineseg(double[] start, double[] end) {
		A = start;
		B = end;
	}

	// Returns the length of this line segment.
	public double length() {
		double sumsq = 0;
		for (int i=0; i<A.length; i++)
			sumsq += Math.pow(B[i]-A[i],2);
		return Math.sqrt(sumsq);
	}

	// Pre-condition: this intersects other
	// Post-condition: the point of intersection is returned.
	public double[] intersect(lineseg other) {

		// Set up matrix of equations for parameters to solve for line seg. intersection.
		double[][] mat = new double[2][2];
		mat[0][0] = this.B[0] - this.A[0];
		mat[0][1] = other.A[0] - other.B[0];
		mat[1][0] = this.B[1] - this.A[1];
		mat[1][1] = other.A[1] - other.B[1];

		double den = det(mat);

		// Replace the first variable's column here.
		mat[0][0] = other.A[0] - this.A[0];
		mat[1][0] = other.A[1] - this.A[1];

		double num = det(mat);

		// Equation solution
		double lambda = num/den;

		// Now solve for the intersection point.
		double[] ans = new double[2];
		for (int i=0; i<2; i++)
			ans[i] = this.A[i] + lambda*(this.B[i] - this.A[i]);
		return ans;
	}

	// Precondition: mat is a 2x2
	// Postcondition: the determinant of mat is returned.
	public static double det(double[][] mat) {
		return mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0];
	}
}

class triangle implements Comparable<triangle> {

	public lineseg[] edges;

	// Create a triangle object from 3 pts.
	public triangle(double[] a, double[] b, double[] c) {

		edges = new lineseg[3];
		edges[0] = new lineseg(a, b);
		edges[1] = new lineseg(b, c);
		edges[2] = new lineseg(c, a);
	}

	// Use Heron's formula to find the area of this triangle.
	public double area() {
		double s = perimeter()/2;
		double a = edges[0].length();
		double b = edges[1].length();
		double c = edges[2].length();
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

	// Returns the perimeter of the triangle.
	public double perimeter() {
		double ans = 0;
		for (int i=0; i<edges.length; i++)
			ans += edges[i].length();
		return ans;
	}

	// Returns value rounded to the nearest thousanth
	public static double round3(double value) {

		int floor = (int)value;
		double rest = value - floor;
		int restdec = (int)(10000*rest);

		if (restdec%10 < 5)
			return floor + ((int)(rest*1000))/1000.0;
		return floor + ((int)(rest*1000 + 1))/1000.0;
	}

	// Sorting method described in problem.
	public int compareTo(triangle other) {

		if (round3(area()) > round3(other.area()))
			return -1;
		else if (round3(area()) < round3(other.area()))
			return 1;
		else if (perimeter() > other.perimeter())
			return -1;
		else if (perimeter() < other.perimeter())
			return 1;
		return 0;
	}

	// Print in desired format.
	public void print() {
		System.out.printf("%.3f %.3f", area(), perimeter());
	}
}

public class d {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

		double[][] quad = new double[4][2];

		for (int i=0; i<8; i++)
			quad[i/2][i%2] = stdin.nextDouble();

		while (!done(quad)) {

			// These are the two diagonals.
			lineseg one = new lineseg(quad[0], quad[2]);
			lineseg two = new lineseg(quad[1], quad[3]);

			// This is the intersection point.
			double[] pt = one.intersect(two);

			// Create our four triangles.
			triangle[] list = new triangle[4];
			for (int i=0; i<list.length; i++)
				list[i] = new triangle(quad[i], quad[(i+1)%4], pt);

			// Sort in order for printing.
			Arrays.sort(list);

			// Print our output.
			for (int i=0; i<list.length-1; i++) {
				list[i].print();
				System.out.print(" ");
			}
			list[list.length-1].print();
			System.out.println();

			// Read in the next data set.
			for (int i=0; i<8; i++)
				quad[i/2][i%2] = stdin.nextDouble();
		}
	}

	// Returns true if all entries of quad are 0.0.
	public static boolean done(double[][] quad) {

		int col = quad[0].length;
		for (int i=0; i<quad.length*quad[0].length; i++)
			if (Math.abs(quad[i/col][i%col]) > 1e-10)
				return false;
		return true;
	}
}