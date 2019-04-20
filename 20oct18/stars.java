import java.util.*;
import java.io.*;

class stars {

    static FastReader fs = new FastReader();
    static int n;
    static int[] pr, rnk;
    static int[] x, y;
    static ArrayList<edge> lst[];
    static ArrayList<edge> al;
    static double min[];

    static double getDist(double x1,double y1,double x2,double y2){
        return Math.hypot(x1-x2,y1-y2);
    }

    static int find(int i){
        return (pr[i]==i)?i:(pr[i]=find(pr[i]));
    }

    static class edge implements Comparable<edge> {
        int x, y;
        double c;

        edge(int xx, int yy, double cc) {
            x = xx;
            y = yy;
            c = cc;
        }

        @Override
        public int compareTo(edge other) {
            double tmp = this.c - other.c;
            if (tmp < 0.0)
                return -1;
            if (tmp > 0.0)
                return 1;
            return 0;
        }

        @Override
        public String toString(){
            return x+" "+y+" "+c;
        }
    }

    public static void main(String[] args) {
        int tc = 0;
        while (true) {
            tc++;
            n = fs.nextInt();
            if(n==0) break;
            x = new int[n];
            y = new int[n];
            lst = new ArrayList[n];
            al = new ArrayList<edge>();
            min = new double[n];
            Arrays.fill(min,Double.MAX_VALUE);
            for(int i=0;i<n;i++){
                x[i] = fs.nextInt();
                y[i] = fs.nextInt();
            }

            
            
            /* for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    double dist = getDist(x[i],y[i], x[j], y[j]);
                    edge e = new edge(i,j,dist);
                    lst[i].add(e);
                    lst[j].add(e);
                    min[i] = Math.min(dist,min[i]);
                    min[j] = Math.min(dist,min[j]);
                }
            }
            for(int i=0;i<n;i++){
                for(edge e:lst[i]){
                    if(e.c == min[i])
                        al.add(e);
                }
            } */
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j) continue;
                    double dist = getDist(x[i],y[i],x[j],y[j]);
                    min[i] = Math.min(dist,min[i]);
                    min[j] = Math.min(dist,min[j]);
                }
            }
            //System.out.println(Arrays.toString(min));
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j) continue;
                    double dist = getDist(x[i],y[i], x[j], y[j]);
                    if(dist == min[i])
                        al.add(new edge(i,j,dist));
                }
            }
            /* for(edge e:al)
                System.out.println(e); */
            Collections.sort(al);
            /* for(edge e:al)
                System.out.println(e); */
            int eCnt = al.size();
            pr = new int[n];
            rnk = new int[n];
            for(int i=0;i<n;i++)
                pr[i] = i;
            int cc = n;
            for(int i=0;i<eCnt;i++){
                edge curr = al.get(i);
                int x = curr.x;
                int y = curr.y;
                int px = find(x);
                int py = find(y);
                if(px!=py){
                    cc--;
                    if(rnk[px]>rnk[py])
                        pr[py] = px;
                    else{
                        pr[px] = py;
                        if(rnk[px]==rnk[py]) 
                            rnk[py]++;
                    }
                }
            }
            System.out.printf("Universe %d contains %d constellations\n",tc,cc);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}