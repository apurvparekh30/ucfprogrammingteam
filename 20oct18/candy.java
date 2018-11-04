import java.util.*;
import java.io.*;

class candy{

    static FastReader fs = new FastReader();
    static int n;
    static int m;
    static candies cds[];
    static int memo[][];
    static final int INF = -1000000000;

    static int rec(int idx,int money){
        if(money == 0) return 0;
        if(money < 0) return INF;
        if(idx == n) return 0;
        if(cds[idx].prz > money) return 0;
        if(memo[idx][money]!=-1){
            return memo[idx][money];
        }
        int ans = 0;
        ans = Math.max(rec(idx,money-cds[idx].prz)+cds[idx].cal,rec(idx+1,money));
        return memo[idx][money] = ans;
    }

    static class candies implements Comparable<candies>{
        int cal,prz;
        candies(int c,int p){
            cal = c;
            prz = p;
        }
        public int compareTo(candies other){
            int tmp = prz - other.prz;
            if(tmp < 0) return -1;
            if(tmp > 0) return 1;
            return 0;
        }
    }

    public static void main(String[] args) {
        memo = new int[5000][10001];
        while(true){
            n = fs.nextInt();
            m = (int)(fs.nextDouble()*100);
            if(n == 0) break;
            
            for(int i=0;i<n;i++)
                for(int j=0;j<=m;j++)
                    memo[i][j]=-1;
            cds = new candies[n];
            for(int i=0;i<n;i++){
                cds[i] = new candies(fs.nextInt(),(int)(fs.nextDouble()*100));
            }
            //System.out.println(m);
            //System.out.println(Arrays.toString(prz));
            Arrays.sort(cds);
            System.out.println(rec(0,m));
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