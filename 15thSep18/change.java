import java.util.*;
import java.io.*;

class change {

    static FastReader fs = new FastReader();
    static int n;
    static int [] coins = {25,10,5,1};
    static int [] count;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            n = fs.nextInt();
            count = new int[4];
            for(int i=0;i<4;i++){
                if(n==0) break;
                if(n < coins[i]) continue;
                count[i] = n/coins[i];
                n = n % coins[i];
            }
            System.out.println
            (t+" "+count[0]+" QUARTER(S), "+count[1]+" DIME(S), "+count[2]+" NICKEL(S), "+ count[3]+" PENNY(S)" );
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