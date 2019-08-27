import java.util.*;
import java.io.*;

class fowl{

    static FastReader fs = new FastReader();
    static int a,b,c;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            a = fs.nextInt();
            b = fs.nextInt();
            c = fs.nextInt();

            if(c < a){
                int tmp = a;
                a = c;
                c = tmp;
            }
            if(c < b){
                int tmp = b;
                b = c;
                c = tmp;
            }
            String ans = "NO";
            double tmp = Math.sqrt(a*a+b*b);
            if(Math.round(tmp) == tmp){
                if(tmp == c) ans ="YES";
                else ans = "NO";
            }
            System.out.printf("Target #%d: %s\n",t,ans);
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