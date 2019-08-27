import java.util.*;
import java.io.*;

class fourtowers{

    static FastReader fs = new FastReader();
    static int n;
    static long []memo;

    static long solve(int n){
        if(memo[n]!=-1) return memo[n];
        long res = -1;
        for(int left=1;left<=62 && left<=n;left++){
            long tmp = ((1L<<left)-1) + 2 * solve(n-left);
            if(res==-1 || (tmp<res && tmp>0)){
                res = tmp;
            }  
        }
        return (memo[n] = res);
    }

    public static void main(String[] args) {
        memo = new long[1000+1];
        Arrays.fill(memo,-1);
        memo[0]=0;
        memo[1]=1;
        memo[2]=3;
        int tc = 0;
        while(true){
            tc++;
            String s = fs.nextLine();
            if(s==null || s.isEmpty()) break;
            n = Integer.parseInt(s);
            System.out.printf("Case %d: %d\n",tc,solve(n)); 
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