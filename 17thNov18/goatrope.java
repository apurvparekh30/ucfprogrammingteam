import java.util.*;
import java.io.*;

class goatrope{

    static FastReader fs = new FastReader();
    static int x,y;
    static int x1,y1,x2,y2,x3,y3,x4,y4;
    static double d=Double.MAX_VALUE;

    static double g(double a,double b,double c,double d){
        return Math.hypot(a-c,b-d);
    }

    public static void main(String[] args) {
        x = fs.nextInt();
        y = fs.nextInt();
        x1 = fs.nextInt();
        y1 = fs.nextInt();
        x2 = fs.nextInt();
        y2 = fs.nextInt();
        d = Double.MAX_VALUE;
        
        for(int i=y1;i<=y2;i++){
            d = Math.min(d,g(x,y,x1,i));
        }
        for(int i=x1;i<=x2;i++){
            d = Math.min(d,g(x,y,i,y2));
        }
        for(int i=y1;i<=y2;i++){
            d = Math.min(d,g(x,y,x2,i));
        }
        for(int i=x1;i<=x2;i++){
            d = Math.min(d,g(x,y,i,y1));
        }
        System.out.printf("%.3f\n",d);
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