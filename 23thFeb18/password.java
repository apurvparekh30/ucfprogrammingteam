import java.util.*;
import java.io.*;

class password{

    static FastReader fs = new FastReader();
    static int n;
    static double []values;
    public static void main(String[] args) {
        n = fs.nextInt();
        values = new double[n];
        for(int i=0;i<n;i++){
            fs.next();
            values[i] = fs.nextDouble();
        }
        Arrays.sort(values);
        double d = 0.0;
        int p = 1;
        for(int i=n-1;i>=0;i--){
            
            d = d + (p * values[i]);
            p++;
        }
        System.out.printf("%.4f\n",d);
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