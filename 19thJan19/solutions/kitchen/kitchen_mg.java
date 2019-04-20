// MCPC'15: Kitchen Measurements
// Author: Michael Goldwasser
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class kitchen_mg {

    final static int MAXN = 6;
    final static int MAXV = 64;
    final static long MASK = ((1L << 7)-1);  // 2^7 - 1

    static class Move implements Comparable<Move> {
        int cost;
        long result;
        public int compareTo(Move other) {
            return Integer.compare(cost, other.cost);
        }
    }

    // cost.get(state) represents min quantity of water to reach state
    static HashMap<Long,Integer> cost = new HashMap<>();    
    static int cap[] = new int[MAXN]; // capacities of jars
    static int N,V;

    // return volume of jar j for given state
    static int volume(long state, int j) {
        return (int) ((state >> (7*j)) & MASK);
    }

    // return new state that results when setting
    // volume of jar j to v.
    static long setVolume(long state, int j, int v) {
        long temp = MASK << (7*j);
        return (state ^ (state & temp) ^ (((long) v) << (7*j)));
    }

    static boolean isGoal(long state) {
        return (volume(state, 0) == V);
    }


    // for debug only
    static String dump(long state) {
        StringBuffer sb = new StringBuffer();

        for (int j=0; j < N; j++) {
            if (j != 0) sb.append(",");
            sb.append(volume(state,j));
        }
        return sb.toString();
    }

    static List<Move> neighbors(long state) {
        List<Move> results = new ArrayList<Move>();
        for (int j=0; j<N; j++)
            for (int k=0; k<N; k++) {
                if (j != k) {
                    // consider pouring from j to k
                    int vj = volume(state,j);
                    int vk = volume(state,k);
                    int quantity = Math.min(vj, cap[k] - vk);
                    if (quantity > 0) {
                        Move temp = new Move();
                        temp.cost = quantity;
                        temp.result = setVolume(setVolume(state, j, vj-quantity), k, vk+quantity);
                        results.add(temp);
                    }
                }
            }
        return results;
    }


    static int solve() {
        PriorityQueue<Move> fringe = new PriorityQueue<>();
        Move initial = new Move();  // first jar full; rest are empty
        initial.cost = 0;
        initial.result = cap[0];
        fringe.add(initial);
        while (!fringe.isEmpty()) {
            Move next = fringe.poll();

            if (isGoal(next.result))
                return next.cost;
            if (!cost.containsKey(next.result)) {  // this is new
                System.err.println("With cost " + next.cost + " can reach state " + dump(next.result));
                cost.put(next.result, next.cost);
                List<Move> nbrs = neighbors(next.result);
                for (int j=0; j < nbrs.size(); j++) {
                    if (!cost.containsKey(nbrs.get(j).result)) {  // not already solved case
                        nbrs.get(j).cost += next.cost;
                        fringe.add(nbrs.get(j));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int j=0; j < N; j++)
            cap[j] = sc.nextInt();
        V = sc.nextInt();

        int best = solve();
        if (best == -1)
            System.out.println("impossible");
        else
            System.out.println(best);
    }

}
