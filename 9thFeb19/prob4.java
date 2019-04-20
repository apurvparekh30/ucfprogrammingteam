import java.util.*;
import java.io.*;

class prob4 {

    static FastReader fs = new FastReader();
    static TreeSet<Integer> ts;
    static int n,m;

    static void smallestDivisor(int n) {
        if (n % 2 == 0){
            ts.add(2);
            ts.add(n/2);
            return;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0){
                ts.add(i);
                ts.add(n/i);
                return;
            }
        }
        ts.add(n);
    }

    public static void main(String[] args) {
        int cases = fs.nextInt();
        
        for (int tt = 1; tt <= cases; tt++) {
            //System.out.println(tt);
            ts = new TreeSet<>();
            n = fs.nextInt();
            System.out.println(n);
            m = fs.nextInt();
            for(int i=0;i<m;i++){
                smallestDivisor(fs.nextInt());
            }
            int i = 0;
            for(int p:ts){
                System.out.print(p + " ");
                i++;
                if(i%5 == 0)
                    System.out.println();
            }
            if(ts.size()%5!=0)
                System.out.println();
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