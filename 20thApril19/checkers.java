import java.util.*;

class checkers {

    static Scanner fs = new Scanner(System.in);
    static char [][]grid;
    static Boolean [][][]dp;


    static int dr[] = {1,-1,-1,1};
    static int dc[] = {-1,-1,1,1};

    static int n;

    static boolean dfs(int i,int j,int cnt) {
        if(cnt == 0){
            return true;
        }
        if(dp[i][j][cnt]!=null)
            return dp[i][j][cnt];
        for(int k=0;k<4;k++){
            int ii = i + dr[k];
            int jj = j + dc[k];
            int iii = ii + dr[k];
            int jjj = jj + dc[k];
            if(ii<0 || ii>=n || jj<0 || jj>=n)
                continue;
            if(iii<0 || iii>=n || jjj<0 || jjj>=n)
                continue;
            if(grid[ii][jj]=='W' && grid[iii][jjj]=='_'){
                grid[ii][jj] = '_';
                grid[i][j] = '_';
                grid[iii][jjj] = 'B';
                boolean curr = dfs(iii,jjj,cnt-1);
                grid[ii][jj] = 'W';
                grid[i][j] = 'B';
                grid[iii][jjj] = '_';
                if(curr){
                    return dp[i][j][cnt] = true;
                }
                    
            }
        }
        return dp[i][j][cnt] = false;
    }

    public static void main(String[] args) {
        n = fs.nextInt();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        int cnt = 0;
        grid = new char[n][];
        for(int i=0;i<n;i++){
            grid[i] = fs.next().toCharArray();
            for(int j=0;j<grid[i].length;j++){
                char c = grid[i][j];
                if(c=='W'){
                    cnt++;
                    continue;
                }
                if(c=='B'){
                    x.add(i);
                    y.add(j);
                }
            }
        }
        int ans = 0;
        dp = new Boolean[n][n][cnt+1];
        for(int i=0;i<x.size();i++){
            if(dfs(x.get(i),y.get(i),cnt)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}