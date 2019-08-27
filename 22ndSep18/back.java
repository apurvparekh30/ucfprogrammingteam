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
            for(int i=0;i<n;i++)
                arr[i]=fs.nextInt();
            if(n == 1 || n == 2){
                System.out.printf("Jacuzzi #%d: NO\n",t);
                continue;
            }
            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));
            String ans = "YES";
            int sum = 0;
            for(int i=0;i<n-1;i++){
                sum+=arr[i];
            }
            if(arr[n-1] > sum)
                ans = "NO";
            System.out.printf("Jacuzzi #%d: %s\n",t,ans);
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