import java.util.*;
import java.io.*;

class minion{

    static FastReader fs = new FastReader();
    static int t;
    static HashMap<String,Boolean> hm;
    static int map[][];
    static int n,m;

    static boolean vis[];
    
    static void dfs(int s){
        vis[s] = true;
        for(int i=0;i<n;i++){
            if(vis[i]) continue;
            if(map[s][i]==0 || map[s][i]==-1) continue;
            dfs(i);
        }
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            t = fs.nextInt();
            hm = new HashMap<String,Boolean>();
            for(int i=0;i<t;i++){
                hm.put(fs.next(),true);
            }
            n = fs.nextInt();
            m = fs.nextInt();

            map = new int[n][n];
            vis = new boolean[n];
            for(int i=0;i<m;i++){
                int u = fs.nextInt();
                int v = fs.nextInt();
                String trial = fs.next();
                if(hm.containsKey(trial)) map[u][v]=-1;
                else map[u][v]=1;
            }
            int ans = 0;
            dfs(0);
            if(vis[n-1]) ans = 1;

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