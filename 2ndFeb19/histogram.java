import java.util.*;
import java.io.*;

class histogram{

    static FastReader fs = new FastReader();
    

    public static void main(String[] args) {
        int cases = fs.nextInt();
        while(cases-- > 0){
            int n = fs.nextInt();
            StringBuilder sb = new StringBuilder();
            while(n-- > 0){
                sb.append('=');
            }
            System.out.println(sb.toString());
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