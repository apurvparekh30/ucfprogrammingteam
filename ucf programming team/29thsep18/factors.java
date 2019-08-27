import java.util.*;
import java.io.*;

class factors{

    static final long max = (long)1e15;
    static FastReader fs = new FastReader();
    static int d;
    static long mul2[] = new long[64];
    static long mul3[] = new long[64];

    static void exponent(long arr[],int n){
        arr[0] = 1;
        for(int i=1;i<arr.length;i++){
            arr[i] = arr[i-1]*n;
            if(arr[i]>=max) break;
        }
    }
    public static void main(String[] args) {
        exponent(mul2,2);
        exponent(mul3,3);
        int tc = fs.nextInt();
        while(tc-- > 0){
            d = fs.nextInt();

            long ans = (long)1e15;
            for(int i=0;i<64;i++){
                if(mul3[i]==0) break;
                for(int j=0;j<64;j++){
                    if(mul2[j]==0) break;
                    if((i+1)*(j+1)==d){
                        ans = Math.min(ans,mul3[i] *mul2[j]);
                    }
                }
            }
            System.out.println(ans);
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