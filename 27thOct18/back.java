import java.util.*;
import java.io.*;

class newdeal {

    static FastReader fs = new FastReader();
    static int k, T;
    static int[] bx;
    static int negs,pos;
    static Boolean memo[][];

    static Boolean rec(int idx,int sum){
        if(sum == T)
            return true;
        if(idx == k)
            return false;
        if(memo[idx][sum+negs]!=null)
            return memo[idx][sum+negs];
        boolean res = rec(idx+1,sum+bx[idx]) || rec(idx+1,sum);
        return memo[idx][sum+negs] = res;
    }
    

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            k = fs.nextInt();
            bx = new int[k];
            pos = 0;
            negs = 0;
            for(int i=0;i<k;i++){
                bx[i] = fs.nextInt();
                if(bx[i] > 0)
                    pos+=bx[i];
                if(bx[i] < 0)
                    negs-=bx[i];
            }
            T = fs.nextInt();
            memo = new Boolean[k][negs+pos+1];

            //Arrays.sort(bx,Collections.reverseOrder());
            //System.out.println(Arrays.toString(bx));

            if(rec(0,0))
                System.out.println("Test case #"+t+": You can hit the target "+T+" and win $10M!");
            else
                System.out.println("Test case #"+t+": You can not hit the target "+T+", sorry!");
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
