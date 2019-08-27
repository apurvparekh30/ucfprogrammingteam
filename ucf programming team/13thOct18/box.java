import java.util.*;
import java.io.*;

class box {

    static FastReader fs = new FastReader();
    static int m,n;
    static char [][]map;
    static ArrayList<pair> []al;
    static ArrayDeque<pair> q;
    static int dr[] = {1,0,-1,0};
    static int dc[] = {0,-1,0,1};

    static class pair{
        int x,y,s=0;
        pair(int xx,int yy,int ss){
            x = xx;
            y = yy;
            s = ss;
        }
        public boolean equals(pair other){
            if(x==other.x && y==other.y) return true;
            return false;
        }
        @Override
        public String toString(){
            return "["+x+","+y+","+s+"]";
        }
    }

    public static void main(String[] args) {
        while(true){
            m = fs.nextInt();
            n = fs.nextInt();
            if(m==0 && n==0) break;
            map = new char[m][n];
            al = new ArrayList[10];
            for(int i=0;i<=9;i++)
                al[i] = new ArrayList<pair>();
            pair src = new pair(0,0,0);
            pair dst = new pair(0,0,0);
            for(int i=0;i<m;i++){
                map[i] = fs.next().toCharArray(); 
                for(int j=0;j<map[i].length;j++){
                    if(map[i][j]=='B'){
                        src = new pair(i,j,0);
                    }
                    if(map[i][j]=='X'){
                        dst = new pair(i,j,0);
                    }
                    if(map[i][j]>='0' && map[i][j]<='9'){
                        al[map[i][j]-'0'].add(new pair(i,j,0));
                    }
                }
            }
            //System.out.println(src.toString() + " " + dst.toString());
            q = new ArrayDeque<pair>();
            boolean vis [][] = new boolean[m][n];
            q.addLast(src);
            vis[src.x][src.y] = true;
            int ans = -1;
            while(!q.isEmpty()){
                pair curr = q.pollFirst();
                //System.out.println(curr);
                if(curr.equals(dst)){
                    ans = curr.s;
                    break;
                }
                int x = curr.x;
                int y = curr.y;
                int s = curr.s;
                int nx,ny;
                if(map[x][y]>='0' && map[x][y]<='9'){
                    for(pair p:al[map[x][y]-'0']){
                        if(curr.equals(p)) continue;
                        nx = p.x;
                        ny = p.y;
                        if(vis[nx][ny]) continue;
                        vis[nx][ny]=true;
                        q.addLast(new pair(nx,ny,s));
                    }
                }
                for(int i=0;i<4;i++){
                    nx = x+dr[i];
                    ny = y+dc[i];
                    if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                    if(map[nx][ny]=='W') continue;
                    if(vis[nx][ny]) continue;
                    vis[nx][ny] = true;
                    q.addLast(new pair(nx,ny,s+1));
                }
            }
            System.out.println("He got the Box in "+ans+" steps!");
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