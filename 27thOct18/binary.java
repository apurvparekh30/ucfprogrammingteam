import java.util.*;
import java.io.*;

class binary {

    static FastReader fs = new FastReader();
    static int base;
    static String inp;

    public static void main(String[] args) {
       int tc = fs.nextInt();
       for(int t=0;t<tc;t++){
           base = fs.nextInt();
           inp = fs.next();
           int value = Integer.parseInt(inp,2);
           String ans = Integer.toString(value, base);
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
