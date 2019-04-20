import java.util.*;
import java.io.*;

class prob10{
    static FastReader fs = new FastReader();
    static int [][]memo = new int[101][10001];
    static int target;

    static int dp(int i,int sum){
        if(sum == 0)
            return 1;
        if(i*i > sum)
            return 0;
        if(memo[i][sum]!=0)
            return memo[i][sum];
        return memo[i][sum] = dp(i+1,sum) + dp(i+2,sum-i*i);
    }
    public static void main(String[] args) {
        int k = fs.nextInt();
        while(k-- > 0){
            System.out.println(dp(1,fs.nextInt()));
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