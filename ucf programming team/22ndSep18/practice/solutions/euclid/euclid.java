// Arup Guha
// 11/8/2009
// My Solution to 2009 SE Regional Problem B: Euclid

import java.util.*;

class pt {
	public double x;
	public double y;
	
	public pt(double my_x, double my_y) {
		x = my_x;
		y = my_y;
	}
	
	// Adding a vector to a point to get to a new point is handy.
	public pt addVect(vector v) {
		double newx = x+v.i;
		double newy = y+v.j;
		return new pt(newx,newy);
	}
	
}

class vector {
	
	public double i;
	public double j;
	
	// A vector is the difference between two pts.
	public vector(pt start, pt end) {
		i = end.x - start.x;
		j = end.y - start.y;
	}
	
	// But if we already know the vector, use this constructor.
	public vector(double a, double b) {
		i = a;
		j = b;
	}
	
	// Useful because it's the area of the parallelogram defined by
	// the two vectors.
	public double crossMag(vector other) {
		return Math.abs(this.i*other.j-other.i*this.j);
	}
	
	// Returns a new vector that is factor times this one.
	public vector scaleFactor(double factor) {
		return new vector(i*factor, j*factor);
	}
}

public class euclid {
	
	public static void main(String[] args) {
		
		Scanner fin = new Scanner(System.in);
		
		pt[] abc = new pt[3];
		pt[] def = new pt[3];
		
		// Read in a,b,c.
		for (int i=0; i<3; i++) {
			double one = fin.nextDouble();
			double two = fin.nextDouble();
			abc[i] = new pt(one,two);
		}
		
		// Read in d,e,f.
		for (int i=0; i<3; i++) {
			double one = fin.nextDouble();
			double two = fin.nextDouble();
			def[i] = new pt(one,two);
		}
		
		// Loop through all cases.
		while (!zero(abc) || !zero(def)) {
			
			// Get the area of triangle def.
			vector de = new vector(def[0], def[1]);
			vector df = new vector(def[0], def[2]);
			double areadef = 0.5*de.crossMag(df);
			
			// Get the area of the parallelogram defined by a,b and c.
			vector ab = new vector(abc[0], abc[1]);
			vector ac = new vector(abc[0], abc[2]);
			double areapara = ab.crossMag(ac);
			
			// Get the ratio of the areas of def to the parallelogram.
			double factor = areadef/areapara;
			
			// This really is the vector ah, a ratio of ac.
			vector ah = ac.scaleFactor(factor);
			pt H = abc[0].addVect(ah);
			pt G = H.addVect(ab);
			
			// Print out our answer.
			System.out.printf("%.3f %.3f %.3f %.3f\n",G.x+1e-9,G.y+1e-9,H.x+1e-9,H.y+1e-9);
			
			abc = new pt[3];
			def = new pt[3];
		
			// Read in a,b,c.
			for (int i=0; i<3; i++) {
				double one = fin.nextDouble();
				double two = fin.nextDouble();
				abc[i] = new pt(one,two);
			}
		
			// Read in d,e,f.
			for (int i=0; i<3; i++) {
				double one = fin.nextDouble();
				double two = fin.nextDouble();
				def[i] = new pt(one,two);
			}
			
		}
	}
	
	// Returns true if all points are (0,0) in the array.
	public static boolean zero(pt[] array) {
		for (int i=0; i<array.length; i++)
			if (Math.abs(array[i].x) > 1e-9 || Math.abs(array[i].y) > 1e-9)
				return false;
		return true;
	}
}
		
		