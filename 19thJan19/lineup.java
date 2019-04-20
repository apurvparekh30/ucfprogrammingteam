import java.util.*;
import java.io.*;

class lineup{

    static FastReader fs = new FastReader();
    static String []names;
    public static void main(String[] args) {
        int n = fs.nextInt();
        names = new String[n];
        for(int i=0;i<n;i++){
            names[i] = fs.next();
        }
        int cnt = 0;
        for(int i=1;i<n;i++){
            int cmp = names[i].compareTo(names[i-1]);
            if(cmp > 0)
                cnt++;
            else
                cnt--;
        }
        //System.out.println(cnt);
        if(cnt==(n-1))
            System.out.println("INCREASING");
        else if(cnt == -(n-1))
            System.out.println("DECREASING");
        else
            System.out.println("NEITHER");
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