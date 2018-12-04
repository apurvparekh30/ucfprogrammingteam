import java.util.*;
import java.io.*;

class voting {

    static FastReader fs = new FastReader();
    static String vote;
    static int []cnt;

    public static void main(String[] args) {
        while(true){
            vote = fs.nextLine();
            if(vote.equals("#"))
                break;
            cnt = new int[100];
            for(char c:vote.toCharArray()){
                cnt[c]++;
            }
            if(vote.length()%2==0)
                cnt['A'] ++;
            String ans = "no";
            if(cnt['A'] > (vote.length()/2)){
                ans = "need quorum";
            }
            else if(cnt['Y']==cnt['N']){
                ans = "tie";
            }
            else if(cnt['Y'] > cnt['N']){
                ans = "yes";
            }
            System.out.println(ans);
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