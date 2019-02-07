import java.util.*;
import java.io.*;

class socks{

    static FastReader fs = new FastReader();
    static int n;
    static int []arr;

    public static void main(String[] args) {
        n = fs.nextInt();
        long sum = 0;
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = fs.nextInt();
            sum+=arr[i];
        }
        Arrays.sort(arr);
        long ans = sum/2;
        if(arr[n-1] > sum - arr[n-1])
            ans = sum - arr[n-1];
        System.out.println(ans);
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