/*  ACM Mid-Central Programming competition 2015 Problem I: Word Clouds Revisited
    solution by Andy Harrington
    dynamic programming iterative solution
*/

import java.util.*;
import static java.lang.Math.*;

class clouds_ah {
    static int N, C;
    static int[] w, h, totH;

    public static void main(String[] args) {   
      Scanner in = new Scanner(System.in);
      N = in.nextInt();
      C = in.nextInt();
      w = new int[N+1]; // sentinel 
      w[0] = C;         //    entry at 0
      h = new int[N+1];
      totH = new int[N+1]; // height through row ending with w[i] x h[i] rect
      for (int i = 1; i <= N; i++) {
        w[i] = in.nextInt();
        h[i] = in.nextInt(); 
        int rowH = h[i];
        totH[i] = rowH + totH[i-1]; // first ith rect alone on line
        int wLeft = C - w[i];    // start to test extensions backwards       
        for (int j = i-1; wLeft >= w[j]; j--) {//all possible rows ending at i
           rowH = max(h[j], rowH);
           totH[i] = min(totH[j-1] + rowH, totH[i]);
           wLeft -= w[j];
        }
      }
      System.out.println(totH[N]);
   }
}
