import java.util.*;
import java.io.*;

class relatives {

    static FastReader fs = new FastReader();
    static int n, m;
    static int[][] grid;
    static HashMap<String, Integer> hm;

    public static void main(String[] args) {
        int tc = 0;
        while (true) {
            tc++;
            n = fs.nextInt();
            m = fs.nextInt();
            if (n == 0 && m == 0)
                break;
            hm = new HashMap<String, Integer>();
            grid = new int[n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(grid[i], (int) 1e6);
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                String s1, s2;
                int u, v;
                s1 = fs.next();
                s2 = fs.next();
                if (hm.containsKey(s1))
                    u = hm.get(s1);
                else {
                    u = cnt++;
                    hm.put(s1, u);
                }
                if (hm.containsKey(s2))
                    v = hm.get(s2);
                else {
                    v = cnt++;
                    hm.put(s2, v);
                }
                grid[u][u] = 0;
                grid[v][v] = 0;
                grid[u][v] = 1;
                grid[v][u] = 1;
            }

            for (int k = 0; k < n; k++)
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);

            /*
             * System.out.println("After"); for(int i=0;i<n;i++)
             * System.out.println(Arrays.toString(grid[i]));
             */
            int ans = -1;

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    ans = Math.max(ans, grid[i][j]);

            if (ans >= (int) 1e6)
                System.out.printf("Network %d: DISCONNECTED\n\n", tc);
            else
                System.out.printf("Network %d: %d\n\n", tc, ans);

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