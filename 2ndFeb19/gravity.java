import java.util.*;
import java.io.*;

class gravity{

    static FastReader fs = new FastReader();
    static int r,c;
    static char [][]g;

    public static void main(String[] args) {
        r = fs.nextInt();
        c = fs.nextInt();
        g = new char[r][];
        for(int i=0;i<r;i++){
            g[i] = fs.next().toCharArray();
        }
        for(int i=r-1;i>=0;i--){
            for(int j=0;j<c;j++){
                if(g[i][j]=='o'){
                    int rr = i+1;
                    while(rr < r && g[rr][j]!='#' && g[rr][j]!='o'){
                        rr++;
                    }
                    if(rr - i > 1){
                        g[i][j] = '.';
                        g[rr-1][j] = 'o';
                    }
                }
            }
        }
        for(int i=0;i<r;i++){
            System.out.println(new String(g[i]));
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