import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n,m;
    static boolean [][]g;
    static int match[];
    static boolean done[];

    static boolean rec(int u){
        for(int i=1;i<=m;i++){
            if(g[u][i] && !done[i]){
                done[i] = true;
                if(match[i] < 0 || rec(match[i])){
                    match[i] = u;
                    return true;
                } 
            }
        }
        return false;
    }

    public static void main(String[] args) {
        n = fs.nextInt();
        m = fs.nextInt();
        g = new boolean[n][m+1];
        for(int i=0;i<n;i++){
            int t = fs.nextInt();
            while(t-- > 0){
                g[i][fs.nextInt()] = true;
            }
        }
        match = new int[m+1];
        Arrays.fill(match,-1);
        int count = 0;
        for(int u=0;u<n;u++){
            done = new boolean[m+1];
            if(rec(u)){
                count++;
            }
        }
        System.out.println(count);
    }
}