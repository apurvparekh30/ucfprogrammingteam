import java.util.*;
import java.io.*;

class dancerecital{

    static FastReader fs = new FastReader();
    static int []routines;
    static int []perm;
    static int cost = (int)1e9;

    static void bk(int idx,int mask){
        if(idx == routines.length){
            int cnt = 0;
            for(int i = 1; i < idx; i++){
                cnt+=Integer.bitCount(perm[i] & perm[i-1]);
            }
            cost = Math.min(cost,cnt);
            return;
        }
        for(int i=0;i<routines.length;i++){
            if((mask & (1<<i)) == 0){
                perm[idx] = routines[i];
                bk(idx+1,mask|(1<<i));
            }
        }

    }
    public static void main(String[] args) {
        int r = fs.nextInt();
        routines = new int[r];
        perm = new int[r];
        
        for(int i=0;i<r;i++){
            char [] s = fs.next().toCharArray();
            for(char c:s){
                int v = c - 'A';
                routines[i] |= (1<<v);
            }
        }
        bk(0,0);
        System.out.println(cost);
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