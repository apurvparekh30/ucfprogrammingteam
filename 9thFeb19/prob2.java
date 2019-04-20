import java.util.*;
import java.io.*;

class prob2 {

    static FastReader fs = new FastReader();
    static int n;
    static long[][] g;

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n==0)
                break;
            g = new long [n+1][n+1];
            for(int i=0;i<=n;i++){
                g[i][n] = 1;
            }
            for(int i=n-1;i>=0;i--){
                for(int j=n-1;j>=i;j--){
                    g[i][j] = g[i+1][j] + g[i][j+1];
                }
            }
            System.out.println(g[0][0]);
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