/*  ACM Mid-Central Programming competition 2015 Problem H: Pyro Tubes
    solution by Andy Harrington
*/

import java.util.*;

public class pyro_ah 
{    
    public static void main(String[] args) 
    {
        int TUBES = 18;
        List<Integer> seq = new ArrayList<Integer>();
        HashSet<Integer> allowed = new HashSet<Integer>();
        Scanner in = new Scanner(System.in);   //  change?
        int n = in.nextInt();
        while (n > 0) {
          seq.add(n);
          allowed.add(n);
          n = in.nextInt();
        }

        for (int L: seq) {
          n = 0;
          for (int b1 = 1<<(TUBES-1); b1 > 0; b1>>=1) {
            int L1 = L^b1;
            if (L1 < L) continue;
            if (allowed.contains(L1)) n++;
            for (int b2 = b1>>1; b2 > 0; b2>>=1) {
              int L2 = L1^b2;
              if (L2 > L &&   allowed.contains(L2)) n++;
            }
          }
          System.out.println(L + ":" + n);
        }
   }
}
