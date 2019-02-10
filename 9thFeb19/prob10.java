import java.util.*;
import java.io.*;

class prob10 {

    static FastReader fs = new FastReader();
    static int n,W;
    static int []c,s;
    static int [][][]memo;

    
    static int rec(int i,int capacity,int W){
        if(capacity <= 0)
            return 0;
        if(i < 0)
            return 0;
        if(memo[i][capacity][W]!=-1)
            return memo[i][capacity][W];
        memo[i][capacity][W] = 0;
        for(int cap = 1; cap < capacity; cap++){
            if((W - (cap * c[i])) >= 0) {
                memo[i][capacity][W] = Math.max(memo[i][capacity][W] ,(s[i] * cap) + rec(i-1,cap,W - (cap * c[i])));
            }
        }
        return memo[i][capacity][W];
    }

    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            n = fs.nextInt();
            W = fs.nextInt();
            c = new int[n];
            s = new int[n];
            memo = new int[101][101][101];
            for(int i=0;i<101;i++)
                for(int j=0;j<101;j++)
                        Arrays.fill(memo[i][j],-1);
            for(int i=0;i<n;i++)
                c[i] = fs.nextInt();
            for(int i=0;i<n;i++)
                s[i] = fs.nextInt();

            System.out.println(rec(n-1,(W/c[n-1])+1,W));
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