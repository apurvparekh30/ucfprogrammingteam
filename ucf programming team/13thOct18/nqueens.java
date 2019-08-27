import java.util.*;
import java.io.*;

class nqueens {

    static FastReader fs = new FastReader();
    static int n;
    static int cols[];

    static boolean valid(int r,int c){
        for(int prev = 0; prev<r;prev++){
            if(cols[prev]==c || (Math.abs(cols[prev]-c)==Math.abs(prev-r))) return false;
        }
        return true;
    }

    static boolean rec(int r){
        if(r==n){
            //print
            boolean flag = false;
            for(int i=0;i<n;i++){
                if(flag) System.out.print(" "); flag=true;
                System.out.print(cols[i]+1);
            }
            System.out.println();
            return true;
        }
        for(int c=0;c<n;c++){
            if(valid(r,c)){
                cols[r]=c;
                if(rec(r+1))   
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int tc =fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            cols = new int[n];
            Arrays.fill(cols,-1);
            rec(0);
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