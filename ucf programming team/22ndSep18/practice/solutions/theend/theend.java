// Arup Guha
// 7/3/2012
// Solution to 2012 U-Chicago Contest Problem D: The End of the World

import java.util.*;

public class theend {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

		String s = stdin.next();

		while (!s.equals("X")) {
			System.out.println(solveRec(s, 'A', 'B'));
			s = stdin.next();
		}

	}

	// Returns the number of steps to solve the puzzle with string s from tower start to tower end.
	public static long solveRec(String s, char start, char end) {

		// value equals the last index with character end.
		int value = done(s, end);
		if (value < 2)
			return value;

		// Move the rest of the string that needs to be moved (rec call),
		// then the bottom disk in the wrong tower (1), plus
		// moving the rest of the disks from other to the end pile (2^k - 1)
		// These last two just add to 2^k.
		char other = (char)(3 - (end - 'A') - (s.charAt(value-1) - 'A') + 'A');
		return solveRec(s.substring(0,value-1), s.charAt(value-1), other) + (1L << (value-1));
	}

	// Returns the index of the last correct disk, starting from the end.
	public static int done(String s, char end) {
		int i = s.length();
		while (i>0 && s.charAt(i-1) == end) i--;
		return i;
	}
}