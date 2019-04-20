import java.util.*;

import java.io.*;

//@thanks andy

class railroad{

    static FastReader fs = new FastReader();
    static int n1,n2;
    static int []t1,t2,t;
    static boolean [][]memo;

    static boolean rec(int i1,int i2){
        if(i1==t1.length && i2==t2.length) return true;
        if(memo[i1][i2]) return false;
        if(i1<t1.length && t1[i1]==t[i1+i2] && rec(i1+1,i2)) return true;
        if(i2<t2.length && t2[i2]==t[i1+i2] && rec(i1,i2+1)) return true;
        memo[i1][i2] = true;
        return false;
    }

    public static void main(String[] args) {
        while(true){
            n1 = fs.nextInt();
            n2 = fs.nextInt();

            if(n1==0 && n2==0) break;
            t1 = new int[n1];
            t2 = new int[n2];
            t = new int[n1+n2];

            memo = new boolean[n1+1][n2+1];

            for(int i=0;i<n1;i++)
                t1[i]=fs.nextInt();
            for(int i=0;i<n2;i++)
                t2[i]=fs.nextInt();
            for(int i=0;i<(n1+n2);i++)
                t[i] = fs.nextInt();
            if(rec(0,0)) 
                System.out.println("possible");
            else    
                System.out.println("not possible");
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