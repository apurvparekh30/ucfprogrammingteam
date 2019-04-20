import java.util.*;
import java.io.*;

class prob1 {

    static FastReader fs = new FastReader();
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        n = fs.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int no = fs.nextInt();
            arr[i] = arr[i - 1] + no;
        }
        n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            int s = fs.nextInt();
            int t = fs.nextInt();
            int ans = arr[t] - arr[s - 1];
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