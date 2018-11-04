import java.util.*;
import java.io.*;

class kingdom {

    static FastReader fs = new FastReader();
    static int n;
    static ArrayList<Integer> al[];
    static int memo[][];

    static final int RED = 0;
    static final int BLACK = 1;
    static final int MOD = 1000000007;

    static int rec(int n,int ally){
        if(al[n].isEmpty()){
           if(ally==1)
            return 1;
            return 0;
        }
        if(memo[n][ally]!=-1) return memo[n][ally];
        int ans=1;
        for(int node:al[n]){
            int tmp = ((rec(node,0)%MOD)+(rec(node,1)%MOD))%MOD;
            ans = (ans * tmp) % MOD;
        }
        if(ally==0) 
            ans = ans - 1;
        return memo[n][ally]=ans;
    }
    public static void main(String[] args) {
        n = fs.nextInt();
        al = new ArrayList[n+1];
        
        memo = new int[n+1][2];
   
        for(int i=1;i<=n;i++){
            
            al[i] = new ArrayList<>();
            
            Arrays.fill(memo[i],-1);
            
        }
        
        for(int i=0;i<n-1;i++){
            int u = fs.nextInt();
            int v = fs.nextInt();
            al[Math.min(u,v)].add(Math.max(u,v));
        }

        /* for(int i=1;i<=n;i++)
            System.out.println(al[i].toString()); */

        System.out.println(rec(1,0));
        /* for(int i=1;i<=n;i++){
            System.out.println("i="+i);
            for(int j=0;j<2;j++){
                System.out.println("j="+j);
                System.out.println(Arrays.toString(memo[i][j]));
            }
        } */
        //System.out.println(rec(1,BLACK,BLACK));
        //System.out.println(Math.max(rec(1,1,RED,RED),rec(1,1,BLACK,BLACK)));

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