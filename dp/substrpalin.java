import java.util.*;
import java.io.*;

class substrpalin {

    static FastReader fs = new FastReader();
    static String str;
    static char[] arr;
    static int memo[][];
    static int ans = 0;

    static int dp(int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (memo[i][j] != -1){
            return memo[i][j];
        }
            
        if (arr[i] == arr[j] && dp(i + 1, j - 1) != 0) {
            return memo[i][j] = 1;
        }
        dp(i + 1, j);
        dp(i, j - 1);
        return memo[i][j] = 0;
    }

    public static void main(String[] args) {
        while (true) {
            str = fs.nextLine();
            if (str == null || str.isEmpty())
                break;
            ans = 0;
            arr = str.toCharArray();
            memo = new int[arr.length][arr.length];
            for (int i = 0; i < arr.length; i++)
                Arrays.fill(memo[i], -1);
            dp(0, arr.length - 1);
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    if(memo[i][j]==1)
                        ans = Integer.max(ans, Math.abs((i-j))+1);
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