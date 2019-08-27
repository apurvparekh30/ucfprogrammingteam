import java.util.*;
import java.io.*;

class back{
    
    static int b;
    static FastReader fs = new FastReader();
    static long []memo;

    

    public static void main(String []args){
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            b = fs.nextInt();
            long  cnt = 0;
            for(int i=1;i<(1<<b);i++){
                for(int j=0;j<(1<<b);j++){
                    if((j&i)==0) cnt++;
                }
            }
            System.out.println(cnt);
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