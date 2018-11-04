import java.util.*;
import java.io.*;

class sortme {

    static FastReader fs = new FastReader();
    static int n;
    static String perm;
    static int arr[];
    static MyString strings[];

    static class MyString implements Comparable<MyString> {
        String s;

        MyString(String ss) {
            s = ss;
        }

        @Override
        public int compareTo(MyString other) {
            for (int i = 0; i < s.length() && i < other.s.length(); i++) {
                int tmp = arr[s.charAt(i)] - arr[other.s.charAt(i)];
                if (tmp < 0)
                    return -1;
                if (tmp > 0)
                    return 1;
            }
            if (other.s.length() < s.length())
                return 1;
            if (other.s.length() > s.length())
                return -1;
            return 0;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    public static void main(String[] args) {
        int tc = 0;
        while (true) {
            tc++;
            n = fs.nextInt();
            if (n == 0)
                break;
            perm = fs.next();
            arr = new int[100];
            strings = new MyString[n];
            for (int i = 0; i < perm.length(); i++) {
                arr[perm.charAt(i)] = i;
            }
            for (int i = 0; i < n; i++) {
                strings[i] = new MyString(fs.next());
            }
            Arrays.sort(strings);
            System.out.printf("year %d\n", tc);
            for (int i = 0; i < n; i++) {
                System.out.println(strings[i]);
            }
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
