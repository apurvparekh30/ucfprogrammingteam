/*  ACM Mid-Central Programming competition 2015 Problem E: Kitchen Measurements
    solution by Andy Harrington

    Input:  n c1 c2 c3 ... cn V  (all positive integers)
            64 >= c1 > c2 > ... > cn;  V < c1; 2 <= n <= 6
    Jug 1...n have given capacities and no other marks. Jug 1 starts full,
    and the rest are empty. You want to end with volume V in jug 1.
    You can pour one jug into another, stopping when the receiving jug is full
    or the starting jug is empty.
    Output the minimum amount of liquid to pour or "impossible"

    Dijiksta's algorithm:
    Create  nodes for fringe as each new tree node is added.
    For easy lookup, nodes are stored in a hashtable with int index key which
    represents the volumes v[1], ... v[n-1]  in base c[1]+1:
        index = v[1] + v[2]*base +...+ v[n-1]*base^(n-2),
    where v[0] is implicit from the fixed total volume sum.
    Unfortunately Java's PriorityQueue does not have the decreaseKey needed by
    Djiksta's algorithm. This slow variation just deletes the old entry (O(n)) ,
    and add the revised node as a new node.
*/

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class kitchen_del_from_pq {
    public static void main(String[] args) {
      jugs.solveSysIn(args);
      //jugs.randTry(args)  // alternative for test data development only
    }
}

class jugs implements Comparable<jugs> {  // equals is default - same object

   int dist, index;  // jug volumes encoded in index
   jugs parent;

   public jugs(int dist_, jugs parent_, int index_) { //create and remember
      dist = dist_;
      parent = parent_;
      index = index_;
      node.put(index, this);  // remember for node lookup and
      fringe.offer(this);         //   as new fringe node
   }

   public int compareTo(jugs js){   // for Java's min-first priority queue
      return dist - js.dist;
   }

   int[] getV(int[] v) { //pass space for v and return reference
      v[0] = totVol;  // v[0] calculated below from known sum totVol
      for (int i = index, j = 1; j < n; j++) {
         v[j] = i % base;
         v[0] -= v[j];
         i /= base;
      }
      return v; // convenience
   }

   public String toString() { // debug display only
      return String.format("%s, dist=%d, pi=%d, i=%d",
                           vStr(getV(new int[n])), dist,
                           (parent==null ? -1 : parent.index), index);
   }

   static int NONE = -1; // marks obsolete node, or no solution
   static int[] cap; // capacities
   static int n, V, totVol; // n: number of jugs; V desired volume
   static int base; // cap[1] +1:  base for node index calc
   static int[] pow; // powers of base for volumes conversion to int index:
   static HashMap<Integer, jugs> node; //v[1]+v[2]*base ... + v[n-1]*base^(n-2)
   static PriorityQueue<jugs>  fringe; // fringe dist
   static Random rand = new Random();
   static int changes = 0;

   static void solveSysIn(String[] args) // solve with System.in data
   {
      if (args.length > 0) DEBUG = Integer.parseInt(args[0]); //debug
      Scanner in = new Scanner(System.in);
      n = in.nextInt();
      cap = new int[n];
      for (int i = 0; i < n; i++)
        cap[i] = in.nextInt();
      V = in.nextInt();
      int d = solve();
      System.out.println(d == NONE ? "impossible" : ""+d);
   }

   static int solve()
   {
      totVol = cap[0];
      base = cap[1]+1;  // for v conversion to int
      pow = new int[n]; //
      pow[0] = 0; pow[1] = 1;
      for (int i = 2; i < n; i++)
        pow[i] = pow[i-1] * base;
      node = new HashMap<Integer, jugs>();
      fringe = new PriorityQueue<jugs>();
      new jugs(0, null, 0); // root saved in fringe, node table
      int[] v = new int[n]; // volumes in closest
      while (true) {
         jugs closest = fringe.poll();
         if (closest == null) break;
         closest.getV(v);
         if (v[0] == V) {
           showSeq(closest);  // debug
           return closest.dist;
         }
         dprln("Next closest:" + closest, 2); //debug
         for (int i = 0; i < n-1; i++)  // find neighbors
           for (int j = i+1; j < n; j++) {
              tryPour(closest, i, j, v);
              tryPour(closest, j, i, v);
           }
      }
      dprln("\n\n" + node.size() + " nodes, removed " + changes, 1); // debug
      return NONE;
   }

   static void tryPour(jugs js, int from, int to, int[] v) { // extend fringe
      int pour =  min(cap[to] - v[to], v[from]);
      if (pour == 0) return;
      int iNbr = js.index + pour * (pow[to] - pow[from]); // neighbor index
      jugs oldNbr = node.get(iNbr);
      if (oldNbr == null || oldNbr.dist > js.dist+pour) {
        if (oldNbr != null) {
          fringe.remove(oldNbr);
          changes++;
        }
        jugs nbr = new jugs(js.dist+pour, js, iNbr);
        dprln("         " + ((oldNbr==null) ? "Add:" : "Chg:")+nbr, 3);//debug
      }
   }

   // for development only
   static void randTry(String[] args) // [[[nTry] maxC] n]
   {
      DEBUG = 0;
      int maxC = 64, nTry = 100, maxNodes = 0, maxDist = 0;
      n = 6;
     if (args.length >= 1)
         n = Integer.parseInt(args[args.length - 1]);
      if (args.length >= 2)
         maxC = Integer.parseInt(args[args.length - 2]);
      if (args.length == 3)
         nTry = Integer.parseInt(args[0]);
      List<Integer> choices = new ArrayList<Integer>();
      cap = new int[n];
      System.out.println("  dist    nodes | n data---");
      for ( ; nTry > 0; nTry--) {
         if (choices.size() < n) {
            choices.clear();
            for (int i = 1; i <= maxC; i++)
               choices.add(i);
            Collections.shuffle(choices);
         }
         for (int i = 0; i < n; i++)
            cap[i] = choices.remove(choices.size()-1);
         Arrays.sort(cap);
         for (int i = 0, j = n-1; i < j; i++, j--) {
            int temp = cap[i];
            cap[i] = cap[j];
            cap[j] = temp;
         }
         V = 1 + rand.nextInt(cap[0]-1);
         int d = solve();
         int totNodes = node.size();
         if (d > maxDist || totNodes > maxNodes) {
            maxDist = max(d, maxDist);
            maxNodes = max(totNodes, maxNodes);
            System.out.format("%6d %8d | %d %s %d\n",
                          d, totNodes, n, vStr(cap), V);
         }
      }
   }

   // DEBUG display from here on
   static int DEBUG = 1;  // level of debug info shown 0: none; 3: most
   static void showSeq(jugs closest) { //follow full sequence
     if (DEBUG == 0) return;
     dprln("\n\n" + node.size() + " nodes, removed " + changes, 1);
     ArrayList<int[]> seq = new ArrayList<int[]>();
     jugs parent = closest;
     while (parent != null) {
         seq.add(parent.getV(new int[n]));
         parent = parent.parent;
     }
     System.err.println(vStr(cap) + " capacities; goal " + V);
     for (int m = seq.size()-1; m >= 1; m--){
         int[] pVol = seq.get(m), v = seq.get(m-1);
         System.err.println(vStr(pVol));
         int fromi=-1, toi=-1;
         for (int i = 0; i < n; i++)
            if (v[i] > pVol[i]) toi = i;
            else if (v[i] < pVol[i]) fromi = i;
         for (int i = 0; i < n; i++)
            System.err.print(i == toi ? " ++" :
                                       (i == fromi ? " --" :
                                                     "   "));
         System.err.println(" pour " + (v[toi] - pVol[toi]));
     }
     System.err.println(vStr(seq.get(0)) + " total poured: " + closest.dist);
   }

   static String vStr(int[] v) { // format jug volumes
     String s = "";
     for (int x: v) s += String.format("%3d", x);
     return s;
   }

   static void dpr(String s, int d) { // debug print; no newline
     if (DEBUG >= d) System.err.print(s);
   }

   static void dprln(String s, int d) { // debug print with newline
     dpr(s+'\n', d);
   }
}
