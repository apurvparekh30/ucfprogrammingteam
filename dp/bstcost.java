import java.util.*;
import java.io.*;

class bstcost{

    static FastReader fs = new FastReader();
    static int []freq;
    static int n;
    static int memo[][][];

    static int dp(int st,int en,int lvl){
        if(st>en)
            return 0;
        if(memo[st][en][lvl]!=-1) {
            //System.out.println("memo used");
            return memo[st][en][lvl];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=st;i<=en;i++){
            ans = Math.min(ans,dp(st,i-1,lvl+1)+dp(i+1,en,lvl+1) + lvl*freq[i]);
        }
        return memo[st][en][lvl] = ans; 
    }

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n==0)
                break;
            freq = new int[n];
            memo = new int[n][n][n+1];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    Arrays.fill(memo[i][j],-1);
            for(int i=0;i<n;i++)
                freq[i] = fs.nextInt();
            System.out.println(dp(0,freq.length-1,1));
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