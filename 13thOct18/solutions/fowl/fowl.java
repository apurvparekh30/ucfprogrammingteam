// Arup Guha
// 12/15/2015
// Solution to 2012 UCF HS Online Contest Problem: Enraged Fowl

import java.util.*;

public class fowl {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process each case.
		for (int loop=1; loop<=numCases; loop++) {

			// Read in the sides.
			int[] sides = new int[3];
			for (int i=0; i<3; i++)
				sides[i] = stdin.nextInt();

			// Need to sort the sides.
			Arrays.sort(sides);

			// Just check if it's a right triangle.
			if (sides[0]*sides[0] + sides[1]*sides[1] == sides[2]*sides[2])
				System.out.println("Target #"+loop+": YES");
			else
				System.out.println("Target #"+loop+": NO");
		}
	}
}