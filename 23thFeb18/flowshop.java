import java.util.*;
import java.io.*;

class flowshop {

    static FastReader fs = new FastReader();
    static int [][]p,ans;
    static int n,m;
    public static void main(String[] args) {
        n = fs.nextInt();
        m = fs.nextInt();
        p = new int[n+1][m+1];
        ans = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++)
                p[i][j] = fs.nextInt();
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                ans[j][i] = p[j][i] + Math.max(ans[j-1][i],ans[j][i-1]);
            }
        }
        boolean space = false;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            if(space)
                sb.append(' ');
            space = true;
            sb.append(ans[i][m]);
        }
        System.out.println(sb);
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