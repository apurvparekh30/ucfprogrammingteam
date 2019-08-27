import java.util.*;
import java.io.*;

class towers{

    static FastReader fs = new FastReader();
    static long k;
    static int n,tc=0;;

    public static void main(String []args){
        
        while(true){
            tc++;
            k = fs.nextLong();
            n = fs.nextInt();
            if(k==0 && n==0) break;
            System.out.println(rec(k,n,0,2));
        }
    }

    static String rec(long moves,int disks,int st,int en){
        if(moves==(1L<<(disks-1))){
            return "Case "+tc+": "+disks+" "+(char)(st+'A')+" "+(char)(en+'A');
        }
        if(moves < (1L<<(disks-1)))
            return rec(moves,disks-1,st,3-st-en);
        else
            return rec(moves-(1L<<(disks-1)),disks-1,3-st-en,en);
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