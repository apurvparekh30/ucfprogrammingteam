import java.util.*;
import java.io.*;

class prob4{

    static FastReader fs = new FastReader();
    static int k;
    static HashMap<Character,String> hm1,hm2;


    public static void main(String[] args) {
        hm1 = new HashMap<>();
        hm2 = new HashMap<>();

        for(int i=0;i<26;i++){
            String ln = fs.nextLine();
            char c = ln.charAt(0);
            String nm = ln.substring(2);
            hm1.put(c,nm);
        }
        for(int i=0;i<26;i++){
            String ln = fs.nextLine();
            char c = ln.charAt(0);
            String nm = ln.substring(2);
            hm2.put(c,nm);
        }
        k = fs.nextInt();
        for(int i=0;i<k;i++){
            String first = fs.next();
            String last = fs.next();
            StringBuilder sb = new StringBuilder();
            sb.append(first + " " + last + " = ");
            sb.append(hm1.get(first.charAt(0)) + " ");
            sb.append(hm2.get(last.charAt(0)));
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