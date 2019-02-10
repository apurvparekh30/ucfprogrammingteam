import java.util.*;
import java.io.*;
import java.math.BigInteger;

class prob1{

    static FastReader fs = new FastReader();
    static String n;
    static BigInteger src,tar;

    public static void main(String[] args) {
        while(true){
            n = fs.next();
            if(n.equals("0"))
                break;
            src = new BigInteger(n);
            tar = BigInteger.ZERO;
            for(int i=0;i<n.length();i++){
                int exp = i + 1;
                BigInteger b = new BigInteger(n.substring(i,i+1));
                tar = tar.add(b.pow(exp));
            }
            //System.out.println(src);
            //System.out.println(tar);
            if(tar.equals(src)){
                System.out.println(n + " is a powerful number.");
            }
            else{
                System.out.println(n + " is not a powerful number.");
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