import java.util.*;
import java.io.*;

class Main{
    static int []a,b;
    static char[]c;
    static int n,m;
    static FastReader fs = new FastReader();

    static void add(int idx,int n,int m,int carry){
        if(idx < 0)
            return;
        int temp = 0;
        if(n>=0)
            temp += a[n];
        if(m>=0)
            temp += b[m];
        temp = temp + carry;
        carry = temp % 10;
        temp = temp / 10;
        c[idx] =(char) ('0' + carry);
        add(idx-1,n-1,m-1,temp);
    }

    public static void main(String[] args) {
        n = fs.nextInt();
        m = fs.nextInt();
        a = new int[n];
        b = new int[m];
        c = new char[Math.max(n,m)+1];
        for(int i=0;i<n;i++){
            a[i] = fs.nextInt();
        }
        for(int i=0;i<m;i++){
            b[i] = fs.nextInt();
        }
        add(Math.max(n,m),n-1,m-1,0);
        System.out.println(new String(c));
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