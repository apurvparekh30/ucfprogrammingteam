import java.util.*;
import java.io.*;

class fizzbuzz {

    static FastReader fs = new FastReader();
    static int n;
    static int a,b;

    public static void main(String[] args) {
        a = fs.nextInt();
        b = fs.nextInt();
        n = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=1;i<=n;i++){
            if(flag)
                sb.append('\n');
            flag = true;
            if(i%a==0 && i%b==0)
                sb.append("FizzBuzz");
            else if(i%a == 0)
                sb.append("Fizz");
            else if(i%b == 0)
                sb.append("Buzz");
            else
                sb.append(i);
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