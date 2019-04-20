import java.util.*;
import java.io.*;

class Solution {

    static FastReader fs = new FastReader();
    static char []s,t;
    static int [][]memo;


    static int dp(int i,int j){
        //System.out.println(i+" "+j);
        if(j<0)
            return i+1;
        if(i<0)
            return -2;
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(s[i]==t[j]){
            memo[i][j] = dp(i-1,j-1);
            dp(i-1,j);
        }
        else {
            memo[i][j] = dp(i-1,j);
        }
        return memo[i][j];
    }
    
    public static void main(String[] args) {
        s = fs.next().toCharArray();
        t = fs.next().toCharArray();
        memo = new int [s.length][t.length];
        for(int i=0;i<s.length;i++)
            Arrays.fill(memo[i],-1);
        dp(s.length-1,t.length-1);
        long sum = 0;
        int j = t.length - 1;
        
        for(int i=0;i<s.length;i++){
        //    System.out.print(memo[i][j]+" ");
            if(memo[i][j]>=0){
                sum+=memo[i][j]+1;
            }
        }
        //System.out.println();
        System.out.println(sum);
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