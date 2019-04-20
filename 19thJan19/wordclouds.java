import java.util.*;
import java.io.*;

class wordclouds {

    static FastReader fs = new FastReader();
    static int n;
    static int mw;
    static int []w,h;
    static int memo[];
    static int oo = 987654321;

    public static void main(String[] args) {
        n = fs.nextInt();
        mw = fs.nextInt();
        w = new int[n];
        h = new int[n];
        memo = new int[n+1];

        Arrays.fill(memo,-1);

        for(int i=0;i<n;i++){
            w[i] = fs.nextInt();
            h[i] = fs.nextInt();
        }
        System.out.println(rec(0));
    }

    static int rec(int pos){
        if(pos >= n)
            return 0;
        if(memo[pos]!=-1)
            return memo[pos];
        int rw = 0;
        int rh = 0;
        int ans = oo;
        for(int i=pos;i<n;i++){
            if(rh < h[i])
                rh = h[i];
            rw = rw + w[i];
            if(rw <= mw){
                int tmp = rh + rec(i+1);
                if(tmp < ans)
                    ans = tmp;
            }
            else{
                break;
            }
        }
        return memo[pos] = ans;
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