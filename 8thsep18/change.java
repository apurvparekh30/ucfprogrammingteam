import java.util.*;
import java.io.*;

class change {

    static FastReader fs = new FastReader();
    static int noCoins;
    static int [] coins;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            noCoins = fs.nextInt();
            coins = new int[noCoins];
            for(int i=0;i<noCoins;i++)
                coins[i]=fs.nextInt();
            Arrays.sort(coins);
            //System.out.println(Arrays.toString(coins));
            int res = 1;
            for(int coin:coins){
                //System.out.println(res);
                if(coin > res)
                    break;
                res=res+coin;
            }
            System.out.printf("Set #%d: %d\n\n",t,res);
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