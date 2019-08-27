import java.util.*;
import java.io.*;

class centroid{

    static FastReader fs = new FastReader();
    static double [] x,y,m;
    static int n;

    static double bsx(int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            double md = mid/100.0;
            double sum = 0.0;
            for(int i=0;i<n;i++){
                sum+= m[i]*(md-x[i]);
            }
            if(sum == 0.0) {
                //System.out.println(md);
                return md;
            }
            if(sum>0) return bsx(low,mid-1);
            else return bsx(mid+1,high);
        }
        return low/100.0;
    }
    static double bsy(int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            double md = mid/100.0;
            double sum = 0.0;
            for(int i=0;i<n;i++){
                sum+= m[i]*(md-y[i]);
            }
            //System.out.println(sum);
            if(sum == 0.0) return md;
            if(sum>0) return bsy(low,mid-1);
            else  return bsy(mid+1,high);
        }
        return low/100.0;
    }

    public static void main(String[] args) {
        int tc=0;
        while(true){
            tc++;
            n = fs.nextInt();
            if(n<0) break;
            x = new double[n];
            y = new double[n];
            m = new double[n];

            for(int i=0;i<n;i++){
                x[i]=fs.nextDouble();
                y[i]=fs.nextDouble();
                m[i]=fs.nextDouble();
            }
            double a = bsx(0.0,5000.00);
            double b = bsy(0.0,5000.00);

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