import java.util.*;
import java.io.*;

class maze {

    static FastReader fs = new FastReader();
    static final int []dx = {1,0,-1,0};
    static final int []dy = {0,-1,0,1};

    static char grid[][];
    static boolean vis[][];

    static int r,c;
    
    static class co{
        int x,y;
        int cost;
        co(int xx,int yy,int c){
            x=xx;
            y=yy;
            cost = c;
        }
    }

    static int bfs(int x,int y){
        Deque<co> q = new ArrayDeque<co>();
        q.add(new co(x,y,0));
        vis[x][y]=true;
        while(!q.isEmpty()){
            co curr = q.poll();
            x = curr.x;
            y = curr.y;
            int cost = curr.cost;

            if(grid[x][y]=='~')
                return cost;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(vis[nx][ny]) continue;
                if(grid[nx][ny]=='X') continue;
                vis[nx][ny]=true;
                q.add(new co(nx,ny,cost+1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            r = fs.nextInt();
            c = fs.nextInt();
            grid = new char[r][c];
            vis = new boolean[r][c];
            int sx=0,sy=0;
            for(int i=0;i<r;i++){
                grid[i] = fs.next().toCharArray();
                for(int j=0;j<c;j++){
                    if(grid[i][j]=='S'){
                        sx = i;
                        sy = j;
                    }
                }
            }
            int ans = -1;
            ans = Math.max(ans,bfs(sx,sy));
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