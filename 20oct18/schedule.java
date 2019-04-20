import java.util.*;
import java.io.*;

class schedule {

    static FastReader fs = new FastReader();
    static int k;
    static int []st,en;
    static meeting mt[];
    static int memo[][];

    static class meeting implements Comparable<meeting>{
        int st,en;
        meeting(int st,int en){
            this.st = st;
            this.en = en;
        }
        @Override
        public int compareTo(meeting other){
            int tmp = en - other.en;
            if(tmp<0) return -1;
            if(tmp>0) return 1;
            return 0;
        }
    }

    static int rec(int i,int end){
        if(i==k)
            return 0;
        if(memo[i][end]!=-1) 
           return memo[i][end];
        int ans = 0;
        if(mt[i].st>=end && mt[i].st>=480 && mt[i].st<=1020 && mt[i].en>=480 && mt[i].en<=1020){
            ans=rec(i+1,mt[i].en)+(mt[i].en-mt[i].st);
        }
        ans = Math.max(ans,rec(i+1,end));
        return memo[i][end] = ans;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            k = fs.nextInt();

            st = new int[k];
            en = new int[k];
            mt = new meeting[k];
            memo = new int[k][1021];
            for(int i=0;i<k;i++){
                Arrays.fill(memo[i],-1);
                /* st[i] = fs.nextInt();
                en[i] = fs.nextInt(); */
                mt[i] = new meeting(fs.nextInt(), fs.nextInt());
            }
            Arrays.sort(mt);
            System.out.println(rec(0,480));
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