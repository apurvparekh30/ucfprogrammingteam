import java.util.*;
import java.io.*;

class family {

    static FastReader fs = new FastReader();
    static int n;

    static HashMap<String, Integer> hm;
    static ArrayList<Integer> al[];
    static boolean vis[];

    static void dfs(int u) {
        vis[u] = true;
        for (int v : al[u]) {
            if (vis[v])
                continue;
            dfs(v);
        }
    }

    public static void main(String[] args) {
        int tc = 0;
        while (true) {
            tc++;
            n = fs.nextInt();
            if (n == 0)
                break;
            hm = new HashMap<String, Integer>();
            al = new ArrayList[300];
            vis = new boolean[300];
            for (int i = 0; i < 300; i++)
                al[i] = new ArrayList<Integer>();
            int cnt = 0;
            while (n-- > 0) {
                String a, b, c;
                a = fs.next();
                b = fs.next();
                c = fs.next();
                int u, v, w;
                if (hm.containsKey(a))
                    u = hm.get(a);
                else {
                    u = cnt++;
                    hm.put(a, u);
                }

                if (hm.containsKey(b))
                    v = hm.get(b);
                else {
                    v = cnt++;
                    hm.put(b, v);
                }
                if (hm.containsKey(c))
                    w = hm.get(c);
                else {
                    w = cnt++;
                    hm.put(c, w);
                }
                al[u].add(w);
                al[w].add(u);
                al[v].add(w);
                al[w].add(v);
            }
            String sc, de;
            String ans = "Not related";
            int u = -1, v = -1;
            sc = fs.next();
            de = fs.next();
            if (hm.containsKey(sc))
                u = hm.get(sc);
            if (hm.containsKey(de))
                v = hm.get(de);

            if (u != -1 && v != -1) {
                dfs(u);
                if (vis[v])
                    ans = "Related";
            }

            System.out.printf("Family #%d: %s.\n", tc, ans);
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