import java.util.*;
import java.io.*;

class timelimits{
    
    static FastReader fs = new FastReader();
    static int n,s;
    static int mx;

    public static void main(String[] args) {
        n = fs.nextInt();
        s = fs.nextInt();
        mx = -1;
        for(int i=0;i<n;i++){
            mx = Math.max(mx,fs.nextInt());
        }
        mx = mx * s;
        int ans = (int)Math.ceil((mx/1000.0));
        System.out.println(ans);
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