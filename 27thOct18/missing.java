import java.util.*;
import java.io.*;

class missing {

    static FastReader fs = new FastReader();
    static int n, p;

    public static void main(String[] args) {
        while (true) {
            n = fs.nextInt();
            if(n==0)
                break;
            p = fs.nextInt();
            
            int L = p, R = p;
            if (p <= (n / 2)) {
                if (p % 2 == 0) {
                    L = p - 1;
                }
                int tmp = L / 2;
                R = n - (2 * tmp);
            } else {
                if (p % 2 == 1) {
                    R = p + 1;
                }
                int tmp = (n - R) / 2;
                L = 1 + (2 * tmp);
            }
            boolean flag = false;
            for (int i = 0; i < 2; i++) {
                if (L+i == p)
                    continue;
                if (flag)
                    System.out.print(" ");
                flag = true;
                System.out.print(L+i);
                
            }
            for (int i = 1; i >= 0; i--) {
                if (R-i == p)
                    continue;
                if (flag)
                    System.out.print(" ");
                flag = true;
                System.out.print(R-i);
            }
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
