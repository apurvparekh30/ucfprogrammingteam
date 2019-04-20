import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

// Solution to A - Binary is the Best problem
// FIU High School Competition, 2015
// by Kip Irvine

public class BinaryIsBest {
	
	final int binary = 2;
	
	// This way works also, but it's more work:
	String convert( String str, int base ) {
		String result = "";
		char[] digits = str.toCharArray();
		
		// convert to decimal
		int n = 0;
		for(int i=0; i < digits.length; i++) {
			n = (n*2) + digits[i] - '0';			
		}
		
		// convert to the new base
		int quotient = 0;
		do {
			quotient = n / base;
			int remainder = n % base;
			result = String.format("%d",remainder) + result;
			n = quotient;			
		} while( n != 0);
		
		return result;
	}

	void start() //throws Exception 
	{
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("binary.judge.in.txt"));
		int numTestCases = in.nextInt();
		for(int t=0; t < numTestCases; t++) {
			int base = in.nextInt();    // number base
			String str = in.next();
			
			// Do it the easy way, using BigInteger.
			// first, convert from binary to BigInteger, then
			// display it in the target format.
			BigInteger output = new BigInteger(str, binary);
			System.out.printf("%s\n", output.toString(base) );

			// Uncomment the next line to do it the hard way: 
			//System.out.println(convert( str, base ));
		} // for t
	} // start
		
	public static void main(String[] args) //throws Exception 
	{
		new BinaryIsBest().start();
	}
}
