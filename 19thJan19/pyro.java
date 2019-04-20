import java.util.*;
import java.io.*;

class pyro {

    static FastReader fs = new FastReader();
    static List<Integer> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {

        while (true) {
            int n = fs.nextInt();
            if (n == -1)
                break;
            list.add(n);
            set.add(n);
        }
        // System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        for (int val : list) {
            int count = 0;
            for (int i = 0; i < 18; i++) {
                int tmp = val ^ (1 << i);
                if (tmp > val && set.contains(tmp)) {
                    count++;
                }
            }

            for (int i = 0; i < 18; i++) {
                for (int j = i+1; j < 18; j++) {
                    int tmp = val ^ (1 << i);
                    //System.out.println(tmp);
                    tmp = tmp ^ (1 << j);
                    //System.out.println(tmp);
                    if (tmp > val && set.contains(tmp)) {
                        count++;
                    }
                }
            }

            sb.append(val).append(':').append(count).append('\n');
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