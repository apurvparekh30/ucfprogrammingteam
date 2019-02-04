import java.util.*;
import java.io.*;

class islands{

    static FastReader fs = new FastReader();
    static int r,c;
    static char g[][];
    static boolean vis[][];
    static int []dx = {1,0,-1,0};
    static int []dy = {0,-1,0,1};

    static void dfs(int i,int j){
        vis[i][j] = true;
        for(int idx=0;idx<4;idx++){
            int ii = i + dx[idx];
            int jj = j + dy[idx];
            if(ii < 0 || ii >= r || jj < 0 || jj >=c)
                continue;
            if(vis[ii][jj])
                continue;
            if(g[ii][jj]=='W')
                continue;
            if(g[ii][jj]=='C'){
                g[ii][jj] = 'L';
            }
            dfs(ii,jj);
        }
    }
    public static void main(String[] args) {
        r = fs.nextInt();
        c = fs.nextInt();
        g = new char[r][];
        vis = new boolean[r][c];
        for(int i=0;i<r;i++){
            g[i] = fs.next().toCharArray();
        }
        int cc = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(vis[i][j] || g[i][j]!='L')
                    continue;
                cc++;
                dfs(i,j);
            }
        }
        System.out.println(cc);
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