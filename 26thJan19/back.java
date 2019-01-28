import java.util.*;
import java.io.*;

class prob10{
    static FastReader fs = new FastReader();
    static int []set;
    static int [][]memo;
    static int []arr;
    static int []arrs;
    static int target;
    static HashMap<Integer,Integer> hm;

    static int dp(int idx,int sum){
        if(idx >= 100)
            return 0;
        if(sum > target)
            return 0;
        if(sum == target)
            return 1;
        if(memo[idx][sum]!=0)
            return memo[idx][sum];
        memo[idx][sum] = dp(idx+1,sum);
        memo[idx][sum] +=dp(idx+2,sum+set[idx]);
        return memo[idx][sum];
    }
    public static void main(String[] args) {
        set = new int[100];
        for(int i=1;i<=100;i++){
            set[i-1] = i*i;
        }
        arr = new int[k+1];
        arrs = new int[k+1];
        int k = fs.nextInt();
        for(int i=1;i<=k;i++){
            arr[i] = fs.nex
        }

        memo = new int[100][10001];
            target = fs.nextInt();
            System.out.println(dp(0,0));
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