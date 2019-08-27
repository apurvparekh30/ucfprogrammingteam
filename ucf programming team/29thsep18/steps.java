import java.util.*;
import java.io.*;

class steps {

    static FastReader fs = new FastReader();
    static int n;
    static int cost[][];
    static int t;
    static String path;

    public static void main(String[] args) {
        n = fs.nextInt();
        cost = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cost[i][j] = fs.nextInt();
        
        /* for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    cost[i][j] = Math.min(cost[i][j],cost[i][k]+cost[k][j]); */
        t = fs.nextInt();
        for(int i=0;i<t;i++){
            path =fs.next();
            char []pathArray = path.toCharArray();
            int noOfSteps=0;
            for(int j=1;j<pathArray.length;j++){
                noOfSteps+=cost[pathArray[j-1]-'A'][pathArray[j]-'A'];
            }
            System.out.println(noOfSteps);
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