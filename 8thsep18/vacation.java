import java.util.*;
import java.io.*;

class vacation {


    static final double INF = 1000000;

    static FastReader fs = new FastReader();
    static boolean [][]blocked;
    static int r,b;
    static Ride []rides;

    static double getDist(Ride a,Ride b){
        return Math.sqrt((a.x - b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
        //return Math.hypot((b.x-a.x),(b.y-a.y));
    }

    static double tsp(int curr,int mask){
        if(mask==((1<<r)-1)){
            return 0;
        }
        double best = INF;
        for(int i=1;i<r;i++){
            if((mask & (1<<i))!=0) continue;
            if(blocked[curr][i]) continue;
            best = Math.min(best,getDist(rides[curr], rides[i]) + tsp(i,mask|(1<<i)));          
        }
        return best;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            r = fs.nextInt();
            b = fs.nextInt();
            r++;
            rides = new Ride[r];
            rides[0] = new Ride(0,0);
            for(int i=1;i<r;i++){
                int x = fs.nextInt();
                int y = fs.nextInt();
                rides[i]=new Ride(x,y);
            }
            blocked = new boolean[r][r];
            for(int i=0;i<b;i++){
                int aa,bb;
                aa = fs.nextInt();
                bb = fs.nextInt();
                blocked[aa][bb]=true;
                blocked[bb][aa]=true;
            }
            double ans = tsp(0,1);
            System.out.printf("Vacation #%d:\n", t);
            if (ans < INF)
                System.out.printf("Jimmy can finish all of the rides in %.3f seconds.\n\n", ans+(r-1)*120);
            else
                System.out.printf("Jimmy should plan this vacation a different day.\n\n");
        }
    }
    static class Ride {
        int x,y;
        Ride(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public String toString(){
            return "[x=" + x + ",y=" + y +"]";
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