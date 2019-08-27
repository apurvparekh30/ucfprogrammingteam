import java.util.*;
import java.io.*;

class upwards {

    static FastReader fs = new FastReader();
    static int n,k,r;
    static int cnt;

    static boolean permute(int pos,char []str){
        if(pos == n){
            cnt++;
            //System.out.println(cnt + " " + new String(str));
            if(cnt==r){
                System.out.println(new String(str));
                return true;
            }
            return false;
        }

        char c ='a';
        if(pos>0)
            c = (char)(str[pos-1]+k+1);

        for(;c<='z';c++){
            str[pos]=c;
            if(permute(pos+1,str))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            k = fs.nextInt();
            n = fs.nextInt();
            r = fs.nextInt();
            cnt=0;
            permute(0,new char[n]);
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