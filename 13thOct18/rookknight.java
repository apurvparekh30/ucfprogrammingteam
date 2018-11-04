import java.util.*;
import java.io.*;

class rookknight {

    static FastReader fs = new FastReader();
    static int n, k;
    static int[] perm;

    static boolean valid(int c, int r,boolean []used) {
        int col = c - 1;
        if (col >= 0) {
            if (perm[c - 1] == r + 2 || perm[c - 1] == r - 2)
                return false;
        }
        col = c - 2;
        if (col >= 0) {
            if (perm[c - 2] == r + 1 || perm[c - 2] == r - 1)
                return false;
        }
        if(used[r]) return false;

        return true;
    }

    static boolean rec(int c,boolean used[]) {
        if (c == n) {
            if (k == 1) {
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (flag)
                        System.out.print(" ");
                    flag = true;
                    System.out.print(perm[i] + 1);
                }
                System.out.println();
                return true;
            }
            k--;
            return false;
        }
        for (int r = 0; r < n; r++) {
            if (valid(c, r,used)) {
                perm[c] = r;
                used[r] = true;
                if (rec(c + 1,used))
                    return true;
                used[r] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while (tc-- > 0) {
            n = fs.nextInt();
            k = fs.nextInt();
            perm = new int[n];
            rec(0,new boolean [n]);
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