import java.util.*;

class e {

    static Scanner fs = new Scanner(System.in);
    static int n,m,l;
    static long max = 0;
    static Edge edges[];
    static int p[];
    static int r[];

    static int find(int i){
        return (p[i]==i) ? i:(p[i] = find(p[i]));
    }

    static class Edge implements Comparable<Edge> {
        int u,v,c;
        Edge(int u,int v,int c){
            this.u = u;
            this.v = v;
            this.c = c;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.c,o.c);
        }
    }
    public static void main(String[] args) {
        n = fs.nextInt();
        m = fs.nextInt();
        l = fs.nextInt();
        edges = new Edge[m];
        p =  new int [n+1];
        r = new int[n+1];
        for(int i=0;i<=n;i++)
            p[i] = i;
        for(int i=0;i<m;i++){
            int u = fs.nextInt();
            int v = fs.nextInt();
            int c = fs.nextInt();
            edges[i] = new Edge(u,v,c);
            if(l > 0)
                max = max + c;
            l--;
        }
        Arrays.sort(edges);
        int cc = n;
        long cost = 0;
        for(Edge e:edges){
            int u = e.u;
            int v = e.v;
            int c = e.c;
            int uu = find(u);
            int vv = find(v);
            if(uu!=vv){
                cc--;
                cost = cost + c;
                if(r[uu] > r[vv]){
                    p[vv] = uu;
                }
                else{
                    p[uu] = vv;
                    if(r[uu]==r[vv]){
                        r[vv]++;
                    }
                }
            }
            if(cc==1)
                break;
        }
        StringBuilder sb = new StringBuilder("impossible");
        if(cost <= max && cc == 1){
            sb = new StringBuilder("possible");
        }
        System.out.println(sb);
    }
}