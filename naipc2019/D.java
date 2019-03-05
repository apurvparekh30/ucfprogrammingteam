import java.util.*;
import java.io.*;
import java.lang.Math.*;
import java.math.BigInteger;

class Solution {

    static FastReader fs = new FastReader();

    public static void main(String[] args) {
        int w = fs.nextInt();
        Random rand = new Random();
        while(w-- > 0){
            long p = fs.nextInt();
            long q = fs.nextInt();
            long n = fs.nextInt();
            int []rems = new int[(int)q];
            long sum = 0;
            if(p==q){
                System.out.println(0);
                continue;
            }
            int i = 0;
            long r;
            for(i=1;i<=n;i++){
                //System.out.print((p*i)%q+" ");
                r = ((p%q) * (i%q))% q;
                //System.out.println(r);
                int id = (int)(r % q);
                //System.out.println("r = " + r);
                //System.out.println("at " + i + "  " + p + " " + r);
                if(rems[id]==0){
                    sum=sum+r;
                    rems[id] = 1;
                }
                else{
                    i = i - 1;
                    break;
                }
            }
            
            //System.out.println();
            //System.out.println("sum " + sum);
            long times = n / i;
            long rem = n % i;
            //System.out.println("rems = " + rem + " i = " + i);
            sum  = sum * times;
            for(int k=1;k<=rem;k++){
                r = (p%q) * k;
                r = r % q;
                sum+=r;
            }
            System.out.println(sum);
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