/*  ACM Mid-Central Programming competition 2015 Problem C: Dance Recital
    solution by Andy Harrington
    naive try of all permutations: 10! is not big.
*/

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class dance {
    static int n, minD=10000;
    static int[] bestSeq; //debug
    static int[][] d;

    public static void main(String[] args) throws Exception {   
      if (args.length > 0) DEBUG = Integer.parseInt(args[0]); //debug
      Scanner in = new Scanner(System.in);
      n = in.nextInt();
      String[] team = new String[n];        
      d = new int[n][n];
      for (int i = 0; i < n; i++) {
        team[i] = in.next();
        for (int j = 0; j<i; j++) 
           for (char ch: team[j].toCharArray()) 
             if (team[i].contains(""+ch)) 
                d[i][j]=d[j][i]=d[i][j]+1; 
      }
      int[] perm = new int[n];
      for (int i = 0; i < n; i++)
        perm[i] = i;
      trySeq(perm, 0, 0);
      System.out.println(minD);
      for (int p: bestSeq) dprln(team[p], 1); // debug    
   }

   static void swap(int[] perm, int i, int j)
   {
      int temp = perm[i];
      perm[i] = perm[j];
      perm[j] = temp;
   }

   static void trySeq(int[] perm, int iStart, int sum) 
   {
      if (DEBUG > 1)
        System.err.format("ist=%d, %s sum=%d\n", iStart,permStr(perm), sum);
      if (iStart == n) {
          if (minD > sum) {
             minD = sum;
             bestSeq = perm.clone(); //debug
          }
          return;
      }
      for (int j = iStart; j < n; j++) {
          swap(perm, iStart, j);
          trySeq(perm, iStart+1, 
                  sum + ((iStart>0) ? d[perm[iStart-1]][perm[iStart]] : 0));
          swap(perm, iStart, j);
      }
    }

   // DEBUG display from here on
   static int DEBUG = 1;  // level of debug info shown 0: none; 3: most
 
    static String permStr(int[] perm)
    {
      String s = "";
      for (int i: perm)
        s += i;
      return s;
    }

   static void dpr(String s, int d) { // debug print; no newline
     if (DEBUG >= d) System.err.print(s);
   }

   static void dprln(String s, int d) { // debug print with newline
     dpr(s+'\n', d);
   }
}
