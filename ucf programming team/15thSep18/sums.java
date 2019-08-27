import java.util.*;
import java.io.*;

class sums{

    static FastReader fs = new FastReader();
    static int n;

    static int getNum(int k){
        return (k*(k+1))/2;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            n = fs.nextInt();
            int res = 0;
            for(int i=1;i<=n;i++){
                res+=i*getNum(i+1);
            }
            System.out.println(t+" "+n+" "+res);
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