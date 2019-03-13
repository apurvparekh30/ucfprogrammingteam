import java.util.*;
import java.io.*;

class k {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static ArrayList<Integer> list[];
    static Set<Integer> set[][];
    static final int oo = 987654321;
    static int t;

    static class state implements Comparable<state> {
        int v,c,p;
        state(int v,int c,int p){
            this.v = v;
            this.c = c;
            this.p = p;
        }
        @Override
        public int compareTo(state o) {
            return Integer.compare(this.c,o.c);
        }
    }


    public static void main(String[] args) {
        n = fs.nextInt();
        list = new ArrayList[n+1];
        set = new HashSet[n+1][n+1];
        int []t = new int[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
            int m = fs.nextInt();
            t[i] = fs.nextInt();
            for(int j=0;j<m;j++){
                int s = fs.nextInt();
                int x = fs.nextInt();
                if(set[i][x]==null){
                    set[i][x] = new HashSet<>();
                }
                list[i].add(x);
                for(int k=0;k<s;k++){
                    set[i][x].add(fs.nextInt());
                }
            }
        }
        int []dist = new int[n+1];
        Arrays.fill(dist,oo);
        PriorityQueue<state> pq = new PriorityQueue<>();
        pq.offer(new state(1,0,1));
        dist[1] = 0;
        int ans = -1;
        while(!pq.isEmpty()){
            state curr = pq.poll();
            int v = curr.v;
            int c = curr.c;
            int p = curr.p;
            if(v==n)
                break;
            for(int next:list[v]){
                if(set[v][next]!=null && set[v][next].contains(p)){
                    continue;
                }
                if(next == p)
                    continue;
                dist[next] = c + t[v];
                pq.offer(new state(next,dist[next],v));
            }
        }
        if(dist[n]==oo){
            System.out.println("impossible");
        }
        else{
            System.out.println(dist[n]+t[n]);
        }
    }
}