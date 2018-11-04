/*************************
 *
 *  Stephen Fulwider
 *	BHCSI - 2007
 *	Happy Sets
 *
 *	Mock Contest - 7/13/07
 *
 *************************/

import java.io.*;
import java.util.*;

public class happy
{	
	private Scanner stdIn;
	private int n, k;
	private int[] A;
	
	/* open file, read in how many data sets are being processed */
	private happy() throws Exception
	{
		stdIn = new Scanner(new File("happy.in"));
		n = stdIn.nextInt();
	}
	
	/* read in a data set from the file */
	private void read() throws Exception
	{
		k = stdIn.nextInt();
		A = new int[k];
		for (int i=0; i<k; i++)
			A[i] = stdIn.nextInt();
	}
	
	/* go through all permutations of an array A, test if happy set */
	private boolean permute() throws Exception
	{
		/* get all permutations */		
		JohnsonTrotter jt = new JohnsonTrotter(k);
		dirInt[][] perms = jt.permute();
		
		/* enumerate through all permutations -- if any are a happy set, return true */
		for (dirInt[] perm : perms)
			if (isHappy(dirInt.toIntArray(perm)))
				return true;
		
		/* if no permutation is a happy set, return false */
		return false;
	}
	
	/* determintes whether an permuted integer array corresponding to vals in A is happy */
	private boolean isHappy(int[] perm)
	{
		int val = A[perm[0]]; 
		for (int i=1; i<A.length; i++)
		{
			if (i%4 == 1) // +
				val += A[perm[i]];
			else if (i%4 == 2) // -
				val -= A[perm[i]];
			else if (i%4 == 3) // *
				val *= A[perm[i]];
			else // / - only case where we need to test to make sure we still have an int
			{
				/* make sure to check if A[perm[i]] == 0 before taking mod!!!!!! */
				if (A[perm[i]] == 0 || val%A[perm[i]] != 0)
					return false;
				val /= A[perm[i]];
			}
		}
		return true;
	}
	
	private int getNumDataSets() { return n; }
	
	/* main to get it all going */
	public static void main(String[] args) throws Exception
	{
		/* instantiate new instance of problem */
		happy set = new happy();
		
		/* process each data set */
		for (int i=1; i<=set.getNumDataSets(); i++)
		{
			/* read data set from file */
			set.read();
			
			/* output whether any permuation is happy */
			if (set.permute())
				System.out.println("Set " + i + " is a Happy Set =)");
			else
				System.out.println("Set " + i + " is a Sad Set =(");
		}
	}
}

/******************************
 *
 * Stephen Fulwider
 * BHCSI - 2007
 * Johnson-Trotter Algorithm
 * 
 * Iterative technique to list out all the permutations of a given length.
 * Satisfies a minimal change property--that is, between any two subsequent
 * permutations, it is guaranteed that only two numbers have been transposed.
 * This is similar to the gray codes used in computer architecture that are
 * useful in simplfying down complex boolean expressions.
 *
 ******************************/

class JohnsonTrotter
{
	private int n;
	
	public JohnsonTrotter(int n) throws Exception
	{
		this.n = n;
	}
	
	public dirInt[][] permute() throws Exception
	{
		ArrayList<dirInt[]> perms = new ArrayList<dirInt[]>();
			
		/* init dirInt[] array to values 1..n, all pointing left */
		dirInt[] arr = new dirInt[n];
		for (int i=0; i<n; i++)
			arr[i] = new dirInt(i+1,'<');
		
		/* print first line */
		//dirInt.println(arr);
		perms.add(arr);
		int cnt=1;
		int k;
		
		dirInt[] thisDirInt = arr.clone();
		/* continue cycling as long as there is still a mobile integer */
		while ((k = dirInt.getLargestMobile(thisDirInt)) != -1)
		{
			thisDirInt = thisDirInt.clone();
			/* swap mobile integer and integer it is pointing to */
			dirInt temp = thisDirInt[k];
			thisDirInt[k] = thisDirInt[k].getDir()=='<'?thisDirInt[k-1]:thisDirInt[k+1];
			if (temp.getDir()=='<')
				thisDirInt[(k--)-1] = temp;
			else
				thisDirInt[(k++)+1] = temp;
				
			/* reverse the dir. of any integer larger than mobile integer
			 * just swapped */
			for (int i=0; i<n; i++)
				if (thisDirInt[i].getVal()>thisDirInt[k].getVal())
					thisDirInt[i].reverse();
			//dirInt.println(arr);
			perms.add(thisDirInt);
			cnt++;
		}

		return perms.toArray(new dirInt[0][0]);
	}
}

/******************************
 *
 * Stephen Fulwider
 * BHCSI - 2007
 * class to hold an integer and its direction
 *
 ******************************/
class dirInt
{
	private int val;
	private char dir; /* '<' or '>' */
	
	/* constructor */
	dirInt(int v, char d)
	{
		val = v;
		dir = d;
	}
	
	/* default constructor -- should not be used */
	dirInt()
	{
		this(-1,'N');
	}
	
	/* getters/setters */
	void setVal(int v) {val = v;}
	void setDir(char d) {dir = d;}
	int getVal() {return val;}
	char getDir() {	return dir;}
	
	/* instance methods */
	/* reverse an integers direction */
	void reverse()
	{
		if (dir=='<')
			dir = '>';
		else
			dir = '<';
	}
	
	/* printers */
	public String toString()
	{
		if (dir=='<')
			return "" + dir + val + " ";
		return " " + val + dir + "";
	}
	
	/* class methods */
	public static void println(dirInt[] arr)
	{
		String s = "";
		for (int i=0; i<arr.length; i++)
			s += arr[i].toString();
		System.out.println(s);
	}
	
	/* returns index of largest mobile (-1 if none exists) */
	public static int getLargestMobile(dirInt[] arr)
	{
		int n = arr.length;
		int largestMobileIndex = -1;
		/* loop through each element in array, searching whether each value
		 * and is mobile relative to its current neighbor */
		for (int i=0; i<n; i++)
			/* if it is, set k to the the largest mobile if:
			 * a) k has not yet been set
			 * b) just found a mobile larger than current largest */
			if (isMobile(arr[i],(arr[i].getDir()=='<'?(i==0?null:arr[i-1]):(i==n-1?null:arr[i+1]))))
				if (largestMobileIndex == -1 || arr[i].getVal() > arr[largestMobileIndex].getVal())
					largestMobileIndex = i;
		/* return value found for largest mobile integer--if this returns -1,
		 * then no mobile integer was found and the main while loop will exit */
		return largestMobileIndex;
	}
	
	/* tells whether i is mobile relative to neighbor n */
	public static boolean isMobile(dirInt i, dirInt n)
	{
		/* if pointing no nothing */
		if (n==null)
			return false;
		/* if value is greater than neighbor, then is mobile */
		if (i.getVal() > n.getVal())
			return true;
		return false;
	}
	
	/* return an integer array of just the values (no dir) */
	public static int[] toIntArray(dirInt[] A)
	{
		int[] vals = new int[A.length];
		for (int i=0; i<vals.length; i++)
			vals[i] = A[i].getVal()-1;
		return vals;
	}
}