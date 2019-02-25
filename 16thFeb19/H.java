import java.util.*;
import java.io.*;

class H{

    static FastReader fs = new FastReader();
    static int n,k;
    static int [][]mat;
    static boolean [][] vis;
    static int oo = 987654321;
    static int [][][] memo;

    static int rec(int i,int k,int last){
        if(k == 0)
            return 0;
        if(i > n)
            return oo;
        if(memo[i][k][last]!=-1){
            //System.out.println(" at " + i + " " + k + " " + memo[i][k]);
            return memo[i][k][last];
        }
            
        memo[i][k][last] = 0;
        int ans = oo;
        ans = Math.min(ans,rec(i+1,k,0));
        if(last == 0){
            ans = Math.min(ans,Math.min(mat[i][0] + rec(i+1,k-1,1), mat[i][1] + rec(i+1,k-1,2)));
        }
        else if(last == 1){
            ans = Math.min(ans,mat[i][0] + rec(i+1,k-1,1));
        }
        else if(last == 2){
            ans = Math.min(ans,mat[i][1] + rec(i+1,k-1,2));
        }
        return memo[i][k][last] = ans;
    }
    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            k = fs.nextInt();
            if(n==0 && k==0)
                break;
            mat = new int [n+1][2];
            vis = new boolean [n+1][2];
            memo = new int [n+1][k+1][3];
            int sum = 0;
            for(int i=1;i<=n;i++){
                for(int j=0;j<2;j++){
                    mat[i][j] = fs.nextInt();
                    sum += mat[i][j];
                }
            }
            for(int i=0;i<=n;i++){
                for(int j=0;j<=k;j++){
                    Arrays.fill(memo[i][j],-1);
                }
            }   
            int a = rec(1,k,0);
            //System.out.println(sum + " " + a);
            System.out.println(sum - a);
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