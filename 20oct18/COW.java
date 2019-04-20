import java.util.*;
import java.io.*;

class COW{

    static FastReader fs = new FastReader();
    static int n;
    static char []txt;
    static char []key = "COW".toCharArray();
    static long memo[][];

    static long rec(int idx,int jdx){
        if(jdx==3) return 1L;
        if(idx==n) return 0L;
        if(memo[idx][jdx]!=-1) return memo[idx][jdx];
        long ans = 0L;
        if(txt[idx]==key[jdx]){
            ans+=rec(idx+1,jdx+1);
        }
        ans+=rec(idx+1,jdx);
        return memo[idx][jdx] = ans;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            txt = fs.next().toCharArray();
            memo = new long[n][3];
            for(int i=0;i<n;i++)
                Arrays.fill(memo[i],-1);
            System.out.println(rec(0,0));
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