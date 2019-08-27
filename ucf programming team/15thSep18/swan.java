import java.util.*;
import java.io.*;

class swan{

    static FastReader fs = new FastReader();
    static double [][]dst;
    static int n;
    static int speed;
    static int angle;
    static double []x,y;
    static int limit;

    static double getDist(double x1,double y1,double x2,double y2){
        return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    }

    static double dp(int curr,int mask){
        if(mask==limit) return dst[curr][0];
        double minimum = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if((mask & (1<<i)) == 0){
                double ans = (dst[curr][i] + dp(i,(mask|(1<<i))));
                if(ans < minimum){
                    minimum = ans;
                }
            }
        }
        return minimum;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            angle =fs.nextInt();
            speed = fs.nextInt();
            dst = new double[n+1][n+1];
            x = new double[n+1];
            y = new double[n+1];

            x[0] = 1000 * Math.sin(Math.toRadians(angle));
            y[0] = 1000 * Math.cos(Math.toRadians(angle));

            for(int i=1;i<=n;i++){
                int hype = fs.nextInt();
                int ang = fs.nextInt();
                x[i] = hype * Math.sin(Math.toRadians(ang));
                y[i] = hype * Math.cos(Math.toRadians(ang));
            }

            for(int i=0;i<=n;i++){
                for(int j=i+1;j<=n;j++){
                    double dist = getDist(x[i],y[i],x[j],y[j]);
                    dst[i][j]=dist;
                    dst[j][i]=dist;
                }
            }
            limit = (1<<(n+1)) - 1;
            System.out.printf("%.2f\n",dp(0,1)/(speed*1.0));
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