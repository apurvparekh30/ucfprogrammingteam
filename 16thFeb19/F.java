import java.util.*;
import java.io.*;

class F{

    static FastReader fs = new FastReader();
    static int a,b;
    public static void main(String[] args) {
        while(true){
            a = fs.nextInt();
            b = fs.nextInt();
            if(a==0 && b==0)
                break;
            StringBuilder sb = new StringBuilder();
            sb.append(a/b).append(' ');
            sb.append(a%b).append(' ');
            sb.append('/').append(' ');
            sb.append(b);
            System.out.println(sb);
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