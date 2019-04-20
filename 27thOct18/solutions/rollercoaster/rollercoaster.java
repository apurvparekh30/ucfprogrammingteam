// Arup Guha
// 11/13/2010
// Solution to 2010 SE Regional Problem H: Roller Coaster

import java.util.*;

public class rollercoaster {
	
	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		
		int N = stdin.nextInt();
		int K = stdin.nextInt();
		int L = stdin.nextInt();
		
		while (N != 0 || K != 0 || L != 0) {
			
			// Will store minimum dizziness to achieve each fun level from 0 to 20N, inclusive.
			int[] funarray = new int[20*N+1];
			
			funarray[0] = 0;
			
			// -1 is sentinel value for we can't get this fun level yet.
			for (int i=1; i<funarray.length; i++)
				funarray[i] = -1;
			
			// Go through each segment.
			for (int seg=0; seg<N; seg++) {
				
				// Fun and dizziness for this segment.
				int f = stdin.nextInt();
				int d = stdin.nextInt();
				
				for (int fun=20*N; fun>=0; fun--) {
					
					// You can get to this fun level, so we'll close our eyes.
					if (funarray[fun] != -1) {
						
						// Close your eyes and lower the dizziness!
						funarray[fun] -= K;
						if (funarray[fun] < 0)
							funarray[fun] = 0;
					}
					
					// We can build on fun-f to get to this fun level, maybe.
					if (fun-f >= 0 && funarray[fun-f] != -1) {
						
						// We've never achieved fun before, and if we keep our eyes open
						// now, we can, without exceeding maximum dizziness.
						if (funarray[fun] == -1 && funarray[fun-f]+d <= L)
							funarray[fun] = funarray[fun-f] + d;
						
						// We previously achieved this fun level, but this time we do so
						// with less dizziness.
						else if (funarray[fun] != -1 && funarray[fun-f]+d<funarray[fun])
							funarray[fun] = funarray[fun-f] + d;
					}
				}
			}
			
			// Find the best fun level we achieved.
			int fun;
			for (fun=20*N; fun>=0; fun--)
				if (funarray[fun] != -1)
					break;
					
			System.out.println(fun);
			
			// Get next case.
			N = stdin.nextInt();
			K = stdin.nextInt();
			L = stdin.nextInt();
		}		
	}
}