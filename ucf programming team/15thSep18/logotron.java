import java.util.*;
import java.io.*;

class logotron{

    static FastReader fs = new FastReader();
    static int n,m;
    static ArrayList<stmt> []al;
    static int cnt = 0;

    static boolean process(int mask){
        for(int i=0;i<n;i++){
            for(stmt t:al[i]){
                int to=t.to;
                char val = t.val;
                if((mask&(1<<i))!=0){
                    if((val=='T' && (mask&(1<<to))==0) || (val=='C' && (mask&(1<<to))!=0))
                        return false;
                }
                else{
                    if((val=='C' && (mask&(1<<to))==0) || (val=='T' && (mask&(1<<to))!=0))
                        return false;
                }
            }
        }
        return true;
    }

    static void backtrack(int i,int mask){
        if(i==n){
            if(process(mask))
                cnt++;
            return;
        }
        backtrack(i+1,mask|(1<<i));
        backtrack(i+1,mask&(~(1<<i)));
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            n = fs.nextInt();
            al = new ArrayList[n+1];
            m = fs.nextInt();

            for(int i=0;i<=n;i++) 
                al[i] = new ArrayList<stmt>();
            
            cnt=0;

            for(int i=0;i<m;i++){
                int fm,to; char val;
                fm = fs.nextInt();
                to = fs.nextInt();
                val = fs.next().charAt(0);
                al[fm-1].add(new stmt(to-1,val));
            }

            backtrack(0,0);
            System.out.println("Case #"+t+": "+cnt);
        }
    }

    public static class stmt{
        int to;
        char val;
        stmt(int to,char val){
            this.to = to;
            this.val = val;
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