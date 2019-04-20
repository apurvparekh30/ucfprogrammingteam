import java.util.*;
import java.io.*;

class rollercoaster {

    static FastReader fs = new FastReader();
    static int n, k, l;
    static int[] f, d;
    static int memo[][];
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        while (true) {
            n = fs.nextInt();
            k = fs.nextInt();
            l = fs.nextInt();

            if (n == 0)
                break;

            f = new int[n];
            d = new int[n];
            int maxFun = 0;
            for (int i = 0; i < n; i++) {
                f[i] = fs.nextInt();
                maxFun += f[i];
                d[i] = fs.nextInt();
            }

            memo = new int[n][maxFun + 1];
            for (int i = 0; i < n; i++)
                Arrays.fill(memo[i], INF);

            memo[0][0] = 0;
            if(d[0] <= l) 
                memo[0][f[0]] = d[0];
            
            for(int section=1;section<n;section++){
                for(int fun=0;fun<=maxFun;fun++){
                    if(memo[section-1][fun]!=INF){
                        memo[section][fun] = Math.max(memo[section-1][fun]-k,0);
                    }
                    if(fun - f[section] >= 0 && memo[section-1][fun-f[section]]!=INF 
                        && memo[section-1][fun-f[section]]+d[section] <=l){
                        memo[section][fun] =
                            Math.min(memo[section-1][fun-f[section]]+d[section],memo[section][fun]);
                    }
                }
            }

            for(int fun=maxFun;fun>=0;fun--){
                if(memo[n-1][fun] != INF){
                    System.out.println(fun);
                    break;
                }
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
