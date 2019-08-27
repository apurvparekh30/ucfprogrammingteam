import java.util.*;
import java.io.*;

class lock{
    
    static int b;
    static FastReader fs = new FastReader();
    static long []memo;

    static long dp(int mask){
        if(memo[mask]!=0) return memo[mask];
        long sum = 0;
        for(int i=1;i<(1<<b);i++){
            if((mask & i) == 0){
                sum+=dp(mask|i) + 1L;
            }
        }
        return memo[mask]=sum;
    }

    public static void main(String []args){
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            b = fs.nextInt();
            memo = new long[(1<<b)];
            System.out.println(t+" "+b+" "+dp(0));
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