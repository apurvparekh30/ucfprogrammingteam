import java.util.*;
import java.io.*;

class periodic{

    static FastReader fs = new FastReader();
    static String s;

    static boolean compare(char []a,char []b){
        //System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));
        int n = a.length;
        int i = 0;
        int j = n-1;
        for(;i<b.length;i++,j=(j+1)%n){
            if(a[j]!=b[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        s = fs.next();
        int ans = s.length();
        for(int k=1;k<=s.length();k++){
            boolean flag = true;
            boolean entered = false;
            for(int i=0;i+k+k<=s.length();i+=k){
                entered = true;
                flag &= compare(s.substring(i,i+k).toCharArray(),s.substring(i+k,i+k+k).toCharArray());
            }
            if(flag && entered){
                ans = k;
                break;
            }
        }
        System.out.println(ans);
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