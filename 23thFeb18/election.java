import java.util.*;
import java.io.*;

class election {

    static FastReader fs = new FastReader();
    static int n;
    static int got;
    static int notgot;
    static int w;
    static long [][]pascal;
    
    public static void main(String[] args) {
        pascal = new long[51][51];
        pascal[0][0] = 1;
        for(int i=0;i<51;i++)
            pascal[i][0] = 1;
        for(int i=1;i<51;i++){
            for(int j=1;j<=i;j++){
                pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
            }
        }
        //for(int i=0;i<51;i++)
        //    System.out.println(Arrays.toString(pascal[i]));
        //System.out.println();
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            int got = fs.nextInt();
            int notgot = fs.nextInt();
            int w = fs.nextInt();
            int needed = n/2+1;
            needed = needed - got;
            if(needed < 0){
                System.out.println("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!");
                continue;
            }
            if(needed > n-got-notgot){
                System.out.println("RECOUNT!");
                continue;
            }
            int remain = n - got - notgot;
            double sum = 0;
            for(int i=needed;i<=remain;i++){
                sum += pascal[remain][i];
            }
            long total = (1L << remain);
            sum = sum / (total * 1.0);
            if(sum * 100 > w){
                System.out.println("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!");
            }
            else {
                System.out.println("PATIENCE, EVERYONE!");
            }
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