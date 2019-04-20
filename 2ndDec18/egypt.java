import java.util.*;
import java.io.*;

class egypt {

    static FastReader fs = new FastReader();
    static int m,n;
    static int []perm;
    static int till;

    static int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }

    static boolean rec(int nm,int dm,int pos){
        if(nm == 1){
            if(dm < 1000000){
                till = pos;
                return true;
            }
            return false;
        }
        for(int i=2;i<=dm;i++){
            int nnm, ddm;
            int lcm = (dm*i)/gcd(Math.max(dm,i),Math.min(dm,i));
            ddm = lcm;
            nnm = Math.abs((nm * (lcm/dm)) - ((lcm/i)));
            perm[pos] = i;
            if(rec(nnm,ddm,pos+1))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        while(true){
            m = fs.nextInt();
            n = fs.nextInt();
            if(m==0 && n==0)
                break;
            perm = new int[100000];
            if(rec(m,n,0)){
                boolean flag = false;
                for(int i=0;i<till;i++){
                    if(flag)
                        System.out.print(" ");
                    flag = true;
                    System.out.print(perm[i]);
                }
                System.out.println();
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