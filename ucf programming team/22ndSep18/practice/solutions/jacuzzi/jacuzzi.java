// Arup Guha
// 12/15/2015
// Solution to 2012 UCF HS Online Contest Problem: Jiminy's Jacuzzis

import java.util.*;

public class jacuzzi {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process each case.
		for (int loop=1; loop<=numCases; loop++) {

			// Read in all sides.
			int n = stdin.nextInt();
			int[] sides = new int[n];
			for (int i=0; i<n; i++)
				sides[i] = stdin.nextInt();

			// Need to sort the sides.
			Arrays.sort(sides);

			// Add up all but the last side.
			int rest = 0;
			for (int i=0; i<n-1; i++)
				rest += sides[i];

			// Output result, rest must be bigger than largest side.
			if (rest > sides[n-1])
				System.out.println("Jacuzzi #"+loop+": YES");
			else
				System.out.println("Jacuzzi #"+loop+": NO");
		}
	}
}