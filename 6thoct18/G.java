import java.util.*;
import java.io.*;

class G {

    static FastReader fs = new FastReader();
    static int n;
    static String dir;
    static ArrayDeque<Integer> st;
    static ArrayDeque<Integer> tmp;

    public static void main(String[] args) {
        n = fs.nextInt();
        dir = fs.next();
        st = new ArrayDeque<Integer>();
        tmp = new ArrayDeque<Integer>();
        st.addLast(1);
        /*
         * if (dir.charAt(0) == 'R')
         * 
         * else st.addLast(0);
         */
        char last = 'R';
        int currTop, lastTop = -1;
        for (char c : dir.toCharArray()) {
            if (c == 'L') {
                if (last == 'R') {
                    lastTop = st.pollLast();
                    tmp.addLast(-1);
                    last = 'L';
                } else {
                    tmp.addLast(tmp.peekLast() - 1);
                }
            } else {
                if (last == 'L') {
                    lastTop += tmp.size();
                    st.addLast(lastTop);
                    while (!tmp.isEmpty()) {
                        st.addLast(lastTop + tmp.pollFirst());
                    }
                    st.addLast(lastTop + 1);
                    last = 'R';
                } else {
                    st.addLast(st.peekLast() + 1);
                }
            }
        }
        if (last == 'L') {
            lastTop += tmp.size();
            st.addLast(lastTop);
            while (!tmp.isEmpty()) {
                st.addLast(lastTop + tmp.pollFirst());
            }
        }

        // System.out.println(st.size());
        while (!st.isEmpty()) {
            int no = st.pollFirst();
            if (no == 0)
                continue;
            System.out.println(no);
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