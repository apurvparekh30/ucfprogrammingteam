import java.util.*;
import java.io.*;

class passwords{

    static FastReader fs = new FastReader();
    static int n;
    static int cnt;
    static int target;
    static String []str;
    static char []ans;
    static boolean [][]used;

    static boolean permute(int pos,char[]ans){
        if(pos == n){
            cnt++;
            if(cnt==target){
                System.out.println(new String(ans));
                return true;
            }
                
            return false;
        }
        for(int i=0;i<str[pos].length();i++){
            if(used[pos][i]) continue;
            used[pos][i]=true;
            ans[pos] = str[pos].charAt(i);
            if(permute(pos+1,ans))
                return true; 
            used[pos][i]=false;
        }
        return false;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            cnt = 0;
            n = fs.nextInt();
            str = new String[n];
            ans = new char[n];
            used = new boolean[n][];
            for(int i=0;i<n;i++){
                str[i]=fs.next();
                used[i]=new boolean[str[i].length()];
            }
            target= fs.nextInt();
            permute(0,ans);
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