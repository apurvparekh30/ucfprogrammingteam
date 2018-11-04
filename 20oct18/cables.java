import java.util.*;
import java.io.*;

class cables{

    static FastReader fs = new FastReader();
    static int n;
    static int []x,y;
    static ArrayList<edge> al;
    static int []pr,rnk;

    static double getDist(double x1,double y1,double x2,double y2){
        return Math.hypot(x1-x2,y1-y2);
    }
    static int find(int i){
        return (pr[i]==i)?i:(pr[i]=find(pr[i]));
    }
    static class edge implements Comparable<edge>{
        int x,y;
        double c;
        edge(int xx,int yy,double cc){
            x = xx;
            y = yy;
            c = cc;
        }
        @Override
        public int compareTo(edge other){
            double tmp = this.c - other.c;
            if(tmp<0.0)
                return -1;
            if(tmp>0.0)
                return 1;
            return 0;
        }
    }

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n==0)
                break;
            x = new int[n];
            y = new int[n];
            al = new ArrayList<edge>();
            for(int i=0;i<n;i++){
                x[i] = fs.nextInt();
                y[i] = fs.nextInt();
            }
            for(int i=0;i<n;i++)
                for(int j=i+1;j<n;j++){
                    al.add(new edge(i,j,getDist(x[i],y[i],x[j],y[j])));
                }
            Collections.sort(al);
            int eCnt = al.size();
            pr = new int[n];
            rnk = new int[n];
            for(int i=0;i<n;i++)
                pr[i] = i;
            double cost = 0;
            for(int i=0;i<eCnt;i++){
                edge curr = al.get(i);
                int x = curr.x;
                int y = curr.y;
                int px = find(x);
                int py = find(y);
                if(px!=py){
                    cost+=curr.c;
                    if(rnk[px]>rnk[py])
                        pr[py] = px;
                    else{
                        pr[px] = py;
                        if(rnk[px]==rnk[py]) 
                            rnk[py]++;
                    }
                }
            }
            System.out.printf("%.2f\n",cost);
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