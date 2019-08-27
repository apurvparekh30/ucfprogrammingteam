import java.util.*;
import java.io.*;

class circles{

    static FastReader fs = new FastReader();

    static int c;
    static double x[];
    static double y[];
    static double r[];

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            c = fs.nextInt();
            x = new double[c];
            y = new double[c];
            r = new double[c];
            for(int i=0;i<c;i++){
                x[i] = fs.nextDouble();
                y[i] = fs.nextDouble();
                r[i] = fs.nextDouble();
            }
            double area = 0.0;
            for(int i=1;i<c;i++){
                double dist = Math.hypot(x[i]-x[i-1], y[i]-y[i-1]);
                if(dist<=(r[i]+r[i-1])){
                    area+=r[i]*r[i]*Math.acos((dist*dist+r[i]*r[i]-r[i-1]*r[i-1])/(2*dist*r[i]));
                    area+=r[i-1]*r[i-1]*Math.acos((dist*dist+r[i-1]*r[i-1]-r[i]*r[i])/(2*dist*r[i-1]));
                    area-=(0.5)*Math.sqrt((-dist+r[i]+r[i-1])*(dist+r[i]-r[i-1])*(dist-r[i]+r[i-1])*(dist+r[i]+r[i-1]));
                }
            }
            System.out.printf("Set #%d %.2f\n\n",t,area);
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