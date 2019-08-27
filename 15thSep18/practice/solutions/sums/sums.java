// Arup Guha
// 5/5/2013
// Solution to 2011 Jordan Contest Problem J: Triangular Sums. Also solution to 2006 NY Problem B.

import java.util.*;

public class sums {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Precompte answers.
		int[] ans = new int[301];
		ans[0] = 0;
		int tri = 1;
		
		// ans[i] stores sum to i, just add one term to previous sum.
		for (int i=1; i<ans.length; i++) {
			tri += (i+1);
			ans[i] = ans[i-1] + i*tri;
		}

		// Process all cases.
		for (int loop=1; loop<=numCases; loop++) {
			int n = stdin.nextInt();
			System.out.println(loop+" "+n+" "+ans[n]);
		}
	}
}