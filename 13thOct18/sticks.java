import java.util.*;
import java.io.*;

class sticks {

    static FastReader fs = new FastReader();
    static int L;
    static int c;
    static int []cuts;
    static int memo[][];

    static int dp(int L,int R){
        if(R-L==1) return 0;
        if(memo[L][R]!=0) return memo[L][R];
        int cost = Integer.MAX_VALUE;
        for(int i=L+1;i<R;i++){
            cost=Math.min(cost,dp(L,i)+dp(i,R)+cuts[R]-cuts[L]);
        }
        return memo[L][R]=cost;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            L = fs.nextInt();
            c = fs.nextInt();
            cuts = new int[c+2];
            cuts[0] = 0;
            for(int i=1;i<=c;i++){
                cuts[i]=fs.nextInt();
            }
            cuts[c+1]=L;
            memo = new int[cuts.length][cuts.length];

            System.out.println(dp(0,cuts.length-1));
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