import java.util.*;
import java.io.*;

class newdeal {

    static FastReader fs = new FastReader();
    static int k, T;
    static int[] bx;
    static int []pos,negs;
    static Boolean memo[][];

    static Boolean rec(int idx,int sum){
       
    }
    

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            k = fs.nextInt();
            pos = new int[k];
            negs = new int[k];
            int pidx = 0;
            int nidx = 0;
            int psum = 0,nsum = 0;
            for(int i=0;i<k;i++){
                int no = fs.nextInt();
                if(no > 0){
                    pos[pidx++] = no;
                    psum+=no;
                }
                else{
                    negs[nidx++] = no;
                    nsum-=no;
                }
            }
            T = fs.nextInt();
            boolean []posArray = rec(0,0,new posArray[psum+1]);
            boolean []negArray = rec(0,0,new negArray[nsum+1]);

            boolean can = false;
            
            for(int j=T;j<posArray.length;j++){
                if(j-T < negArray.length && posArray[j] && negArray[j-target]){
                    can = true;
                    break;
                }
            }

            if(can)
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
