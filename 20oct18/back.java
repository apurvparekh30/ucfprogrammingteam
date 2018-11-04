import java.util.*;
import java.io.*;

class countseq {

    static FastReader fs = new  FastReader();
    static char[] str,seq;
    static long memo[][];

    static long rec(int idx,int jdx){
        if(jdx==seq.length) return 1L;
        if(idx==str.length) return 0L;
        if(memo[idx][jdx]!=-1) return memo[idx][jdx];
        long ans = 0L;
        if(str[idx]==seq[jdx]){
            ans+=rec(idx+1,jdx+1);
        }
        ans+=rec(idx+1,jdx);
        return memo[idx][jdx] = ans;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            memo = new long[1000][1000];
            str = fs.next().toCharArray();
            seq = fs.next().toCharArray();
            for(int i=0;i<str.length;i++)
                Arrays.fill(memo[i],-1);
            System.out.println(rec(0,0));
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