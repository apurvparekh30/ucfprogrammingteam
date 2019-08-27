import java.util.*;
import java.io.*;

class B {

    static FastReader fs = new FastReader();
    static int p,q,s;

    static int gcd(int a,int b){
        return b==0 ? a:gcd(b,a%b);
    }
    public static void main(String[] args) {
        p = fs.nextInt();
        q = fs.nextInt();
        s = fs.nextInt();
        if(p*q<=s){
            System.out.println("yes");
        }
        else {
            int div = gcd(Math.max(p,q),Math.min(p,q));
            int lcm = (p*q)/div;
            //System.out.println(div + " " + lcm);
            if(lcm <= s)
                System.out.println("yes");
            else
                System.out.println("no");
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