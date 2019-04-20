import java.util.*;
import java.io.*;

class prob2{

    static FastReader fs = new FastReader();
    static int n;

    public static void main(String[] args) {
        n = fs.nextInt();
        for(int i=0;i<n;i++){
            int tmp = fs.nextInt();
            System.out.printf("%d feet, %d inches of snow is the equivalent of %d inches of rain\n",
                                tmp/12,tmp%12,tmp/10);
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