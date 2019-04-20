import java.util.*;
import java.io.*;

class composition {

    static FastReader fs = new FastReader();
    static int n;
    static int[] d, r;
    static boolean vis[];
    static int memo[];

    static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }

    static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }

    static int dfs(int i,int cnt) {
        if(vis[i])
            return cnt;
        vis[i] = true;
        memo[i] = dfs(r[i],cnt+1);
        return memo[i];
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while (tc-- > 0) {
            n = fs.nextInt();
            d = new int[n + 1];
            r = new int[n + 1];
            vis = new boolean[n + 1];
            memo = new int[n+1];
            
            for (int i = 0; i < n; i++) {
                d[i] = fs.nextInt();
                r[d[i]] = fs.nextInt();
            }
            int ans = 0;
            memo[d[0]] = dfs(d[0],0);
            ans = memo[d[0]];
            for(int i=1;i<n;i++){
                if(memo[d[i]]==0){
                    memo[d[i]] = dfs(d[i],0);
                    ans = LCM(ans,memo[d[i]]);
                }
            }
            /* for(int i=0;i<n;i++)
                System.out.println(memo[d[i]]); */
            System.out.println(ans);
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
