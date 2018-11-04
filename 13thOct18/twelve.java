import java.util.*;
import java.io.*;

class twelve {

    static FastReader fs = new FastReader();
    static int n;
    static int[][] cost;
    static int s, d, c;

    static void fw(){
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    cost[i][j] = Math.min(cost[i][j],cost[i][k]+cost[k][j]);
    }

    public static void main(String[] args) {
        n = fs.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = fs.nextInt();
            }
        }
        fw();
        int paths = fs.nextInt();
        for (int j = 0; j < paths; j++) {
            s = fs.nextInt();
            d = fs.nextInt();
            c = fs.nextInt();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 1) {
                    if (cost[s][i] + cost[i][d] + 134 <= c)
                        cnt++;
                }
            }
            System.out.println(cnt);
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