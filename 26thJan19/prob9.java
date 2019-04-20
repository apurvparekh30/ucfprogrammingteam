import java.util.*;
import java.io.*;

class prob9 {

    static FastReader fs = new FastReader();
    static double [] width;
    static int n,t;

    static double solve(){
        double low = 0;
        double high = 1e9;
        double mid = 0.0;
        int loops = 1000;

        for(int i=0;i<=loops;i++){
            mid = (low+high)/2.0;
            int tmp = 0;
            for(int j=0;j<n;j++){
                tmp+=Math.max((width[j]/mid)-1,0);
            }
            if(tmp < t)
                high = mid;
            else
                low = mid;
        }
        return mid;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            n = fs.nextInt();
            t = fs.nextInt();
            width = new double[n];
            for(int i=0;i<n;i++)
                width[i] = fs.nextDouble();
            System.out.printf("%.3f\n",solve());
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