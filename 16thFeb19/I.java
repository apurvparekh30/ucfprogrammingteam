import java.util.*;
import java.io.*;

class I {

    static FastReader fs = new FastReader();
    static int a,b;
    static Set<Long> vis;

    static long g(int i){
        return (1L<<(i-1));
    }

    static class state{
        long x,y;
        int n;
        state(long x,long y,int n){
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            a = fs.nextInt();
            b = fs.nextInt();
            a++;
            b++;
            int shifts = 0;
            long total = 0;

            while(true){
                long toadd = (1<<shifts);
                
                long sub1=0;
                if(toadd > a)
                    sub1 = toadd - a;
                
                long sub2=0;
                if(toadd > b)
                    sub2 = toadd -b;
                
                if(toadd - sub2 - sub1 <= 0)
                    break;
                total += toadd - sub1 - sub2;
                shifts++;
            }
            System.out.println(total);
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