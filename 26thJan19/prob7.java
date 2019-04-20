import java.util.*;
import java.io.*;

class prob7 {

    static FastReader fs = new FastReader();
    static int n, m;
    static int[][] in, sc;
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, -1, 0, 1 };
    static int mod = 1000;
    

    static int dp(int i, int j) {
        if (i == n - 1 && j == m - 1)
            return 1;
        if (sc[i][j] != 0)
            return sc[i][j];
        
        for (int id = 0; id < 4; id++) {
            int ni = i + dr[id];
            int nj = j + dc[id];
            if (ni < 0 || ni >= n || nj < 0 || nj >= m)
                continue;
            if (in[ni][nj] > in[i][j])
                continue;
            sc[i][j] = (sc[i][j] + (dp(ni,nj))%mod)%mod;
        }
        return sc[i][j]%mod;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for (int tt = 0; tt < tc; tt++) {
            n = fs.nextInt();
            m = fs.nextInt();
            in = new int[n][m];
            sc = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    in[i][j] = fs.nextInt();
                }
            }
            
            System.out.println(dp(0,0));
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