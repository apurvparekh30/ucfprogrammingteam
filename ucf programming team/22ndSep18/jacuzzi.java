import java.util.*;
import java.io.*;

class jacuzzi{

    static FastReader fs = new FastReader();

    static int []arr;
    static int n;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            n = fs.nextInt();
            arr = new int[n];
            int mx = -1;
            int sum = 0;
            for(int i=0;i<n;i++){
                arr[i]=fs.nextInt();
                sum += arr[i];
                if(mx < arr[i]) mx = arr[i];
            }
                
            if(n == 1 || n == 2)
                System.out.printf("Jacuzzi #%d: NO\n",t);
            else if(sum - mx > mx)
                System.out.printf("Jacuzzi #%d: YES\n",t);
            else
                System.out.printf("Jacuzzi #%d: NO\n",t);
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