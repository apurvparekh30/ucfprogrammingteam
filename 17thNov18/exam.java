import java.util.*;
import java.io.*;

class exam {

    static FastReader fs = new FastReader();
    static int r,w;
    static char[] a,b;

    public static void main(String[] args) {
        r = fs.nextInt();
        a = fs.next().toCharArray();
        b = fs.next().toCharArray();
        int n = a.length;
        w = n - r;
        int rt = n;
        for(int i=0;i<n;i++){
            if(a[i]==b[i]) 
                continue;
            if(w>0)
                w--;
            else
                rt--;
        }
        rt = rt - w;
        System.out.println(rt);
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