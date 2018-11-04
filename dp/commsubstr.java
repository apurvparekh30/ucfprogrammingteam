import java.util.*;
import java.io.*;

class commsubstr {

    static FastReader fs = new FastReader();
    static char[] s1, s2;
    static int memo[][];

    static int dp(int i,int j){
        if(i>=s1.length || j>=s2.length)
            return 0;
        if(memo[i][j]!=-1)
            return memo[i][j];
        if(s1[i]==s2[j])
            return memo[i][j]=1+dp(i+1,j+1);
        dp(i+1,j);
        dp(i,j+1);
        return memo[i][j]=0;
    }

    public static void main(String[] args) {
        while (true) {
            String next = fs.nextLine();
            if (next == null || next.isEmpty())
                break;
            s1 = next.toCharArray();
            next = fs.nextLine();
            s2 = next.toCharArray();
            memo = new int[s1.length][s2.length];
            for(int i=0;i<s1.length;i++)
                Arrays.fill(memo[i],-1);
            dp(0, 0);
            int ans = 0;
            String sub="";
            for (int i = 0; i < s1.length; i++) {
                for (int j = 0; j < s2.length; j++) {
                    if(ans<memo[i][j]){
                        ans = memo[i][j];
                        sub = new String(s1).substring(i,i+ans);
                    }
                    ans = Math.max(memo[i][j], ans);
                }
            }
            System.out.printf("Longest substring between %s and %s is %s\n",
                    Arrays.toString(s1),Arrays.toString(s2),sub);
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