import java.util.*;
import java.io.*;

class j {

    static Scanner fs = new Scanner(System.in);
    static int c,m;
    static int [][]p;
    static int dp[][];
    static boolean sold[];

    static int rec(int i,int rem){
        if(rem <= 0){
            return 0;
        }
        if(i>m){
            return 0;
        }
        if(dp[i][rem]!=-1)
            return dp[i][rem];
        dp[i][rem] = 0;
        int ans = 0;
        for(int j=0;j<=rem;j++){
            int temp = p[i][j] + rec(i+1,rem-j);
            if(ans < temp)
                ans = temp;
        }
        return dp[i][rem] = ans;
    }
    public static void main(String[] args) {
        c = fs.nextInt();
        m = fs.nextInt();
        p = new int[m+1][c+1];
        dp = new int[m+1][c+1];
        sold = new boolean[c];
        for(int i=1;i<=m;i++){
            Arrays.fill(dp[i],-1);
            for(int j=1;j<=c;j++){
                p[i][j] = fs.nextInt();
            }
        }
        System.out.println(rec(1,c));
    }
}