import java.util.*;
import java.io.*;

class sculpture {

    static FastReader fs = new FastReader();
    static int n,m;
    static int[][]g;
    static int[][]d;

    static int []dr = {1,0,-1,0};
    static int []dc = {0,-1,0,1};

    public static void main(String[] args) {
        n = fs.nextInt();
        m = fs.nextInt();
        g = new int[n][m];
        d = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                g[i][j] = fs.nextInt();
        }
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                d[i][j] = 1;
                for(int k=0;k<4;k++){
                    //System.out.println(j+dc[k]);
                    if(g[i][j] >= g[i+dr[k]][j+dc[k]]){
                        d[i][j] = 0;
                        break;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            boolean flag = false;
            for(int j=0;j<m;j++){
                if(flag)
                    System.out.print(" ");
                flag = true;
                System.out.print(d[i][j]);
            }
            System.out.println();
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