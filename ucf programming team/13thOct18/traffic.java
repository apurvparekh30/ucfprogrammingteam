import java.util.*;
import java.io.*;

class traffic {

    static FastReader fs = new FastReader();
    static int n, l;
    static int c, pt;
    static ArrayList<Integer> al[];
    static boolean vis[];

    static void dfs(int u) {
        vis[u] = true;
        for (int v : al[u]) {
            if (v == pt)
                continue;
            if (vis[v])
                continue;
            dfs(v);
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean blank = false;
        for (int t = 1; t <= tc; t++) {
            n = fs.nextInt();
            al = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                al[i] = new ArrayList<Integer>();
                l = fs.nextInt();
                for (int j = 0; j < l; j++) {
                    al[i].add(fs.nextInt());
                }
            }
            /*
             * for(int i=1;i<=n;i++) System.out.println(al[i].toString());
             */
            c = fs.nextInt();
            if (blank)
                System.out.println();
            blank = true;
            System.out.println("City #" + t);
            while (c-- > 0) {
                pt = fs.nextInt();
                vis = new boolean[n + 1];
                int cc = 0;
                for (int i = 1; i <= n; i++) {
                    if (i == pt)
                        continue;
                    // System.out.println("Before point "+i+" "+Arrays.toString(vis));
                    if (vis[i] == false) {
                        dfs(i);
                        cc++;
                    }

                }
                if (cc > 1)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }

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