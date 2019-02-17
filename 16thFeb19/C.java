import java.util.*;
import java.io.*;

class C {

    static FastReader fs = new FastReader();
    static TreeSet<Integer> ts;
    static int[] arr;
    static int w, n;

    public static void main(String[] args) {
        w = fs.nextInt();
        n = fs.nextInt();
        n = n + 2;
        ts = new TreeSet<>();
        arr = new int[n];
        arr[0] = 0;
        for (int i = 1; i < n-1; i++) {
            arr[i] = fs.nextInt();
            ts.add(arr[i]);
        }
        arr[n-1]  = w;
        ts.add(w); 
        for (int i = 1; i < n; i++) {
            for (int k = 0; k + i < n; k++) {
                ts.add(arr[k+i] - arr[k]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int key:ts){
            sb.append(key).append(' ');
        }
        System.out.println(sb);
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