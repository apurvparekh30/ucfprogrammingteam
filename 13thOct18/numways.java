import java.util.*;
import java.io.*;

class numways {

    static FastReader fs = new FastReader();
    static int x,d;
    static int []coins;
    static int memo[][];

    static final int MOD = 1000000007;

    static int dp(int idx,int x){
        if(x == 0) return 1;
        if(x < 0 || idx>=d) return 0;
        if(memo[idx][x]!=-1) return memo[idx][x];
        return memo[idx][x]  = ((dp(idx+1,x)%MOD)+(dp(idx,x-coins[idx])%MOD)%MOD);
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            x = fs.nextInt();
            d = fs.nextInt();
            memo = new int[10][10000];
            for(int i=0;i<d;i++)
                Arrays.fill(memo[i],-1);
            coins = new int[d]; 
            for(int i=0;i<d;i++)
                coins[i]=fs.nextInt();
            //System.out.println(Arrays.toString(coins));
            System.out.println(dp(0,x)%MOD);
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