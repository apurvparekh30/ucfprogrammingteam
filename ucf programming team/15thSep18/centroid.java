import java.util.*;
import java.io.*;

class centroid{

    static FastReader fs = new FastReader();
    static double x,y,m;
    static int n;

    public static void main(String[] args) {
        int tc=0;
        while(true){
            tc++;
            n = fs.nextInt();
            if(n<0) break;
            x = 0.0;
            y = 0.0;
            m = 0.0;
            
            double xs = 0.0,ys=0.0,ms=0.0;

            for(int i=0;i<n;i++){
                x=fs.nextDouble();
                y=fs.nextDouble();
                m=fs.nextDouble();

                xs+=x*m;
                ys+=y*m;
                ms+=m;
            }
            
            double a = xs/ms;
            double b = ys/ms;

            System.out.printf("Case %d: %.2f %.2f\n",tc,a,b);
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