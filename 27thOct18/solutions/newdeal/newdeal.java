// Arup Guha
// 7/22/08
// Solution to BHCSI Contest Problem: New Deal.
import java.io.*;
import java.util.*;

public class newdeal {
	
	public static void main(String[] args) throws Exception {

		Scanner fin = new Scanner(new File("newdeal.in"));

		int numCases = fin.nextInt();
		
		for (int i=1; i<=numCases; i++) {
			
			int numBoxes = fin.nextInt();
			
			// Set up arrays to store both the positive and negative values.
			int[] positive = new int[numBoxes];
			int[] negative = new int[numBoxes];
			int posCount = 0, posSum = 0;
			int negCount = 0, negSum = 0;
			
			// Read in values into two arrays, one for the positive values
			// and one for the negative values.
			for (int j=0; j<numBoxes; j++) {
				int val = fin.nextInt();
				
				if (val > 0) {
					positive[posCount] = val;
					posCount++;
					posSum += val;
				}
				else {
					negative[negCount] = -val;
					negCount++;
					negSum -= val;
				}
			}
			
			int target = fin.nextInt();
			
			// We will run the regular DP subset sum algorithm on both
			// sets of values.
			boolean[] posArray = subsetSum(positive, posSum);
			boolean[] negArray = subsetSum(negative, negSum);
			
			// Look for each combination possible of positive numbers with
			// negative numbers to add up to the target.
			boolean found = false;
			for (int j=target; j<posArray.length; j++) {
				if (j-target < negArray.length && posArray[j] && negArray[j-target]) {
					found = true;
					break;
				}
			}
			
			// Output the appropriate response.
			if (found)
				System.out.println("Test case #"+i+": You can hit the target "+target+" and win $10M!");
			else
				System.out.println("Test case #"+i+": You can not hit the target "+target+", sorry!");
		}		
		
		
		fin.close();		
	}
	
	// Returns an array of size max+1 that stores whether or not subsets from
	// values can add up to anything from 0 to max.
	public static boolean[] subsetSum(int[] values, int max) {
		
		// Initialize the array.
		boolean[] sums = new boolean[max+1];
		sums[0] = true;
		for (int i=1; i<sums.length; i++)
			sums[i] = false;
			
		// Loop through each value.
		for (int i=0; i<values.length; i++) {
			
			// See if this value helps create a new subset.
			for (int j=max; j>=values[i]; j--)
				if (sums[j-values[i]])
					sums[j] = true;
		}
		
		// Return the array that stores all the answers.
		return sums;
	}
}