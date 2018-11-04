import java.util.*;
import java.io.*;

class bunnies {

    static FastReader fs = new FastReader();
    static int r, c;
    static char grid[][];
    static boolean vis[][];
    static int dr[] = { 1, 0, -1, 0 };
    static int dc[] = { 0, -1, 0, 1 };

    static class cell {
        int x, y, c;

        cell(int xx, int yy, int cc) {
            x = xx;
            y = yy;
            c = cc;
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while (tc-- > 0) {
            r = fs.nextInt();
            c = fs.nextInt();
            grid = new char[r][c];
            vis = new boolean[r][c];
            cell st = new cell(0, 0, 0);
            for (int i = 0; i < r; i++) {
                grid[i] = fs.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == 'C')
                        st = new cell(i, j, 0);
                }
            }
            ArrayDeque<cell> q = new ArrayDeque<cell>();
            q.addLast(st);
            vis[st.x][st.y] = true;
            String ans = "no";
            while (!q.isEmpty()) {
                cell curr = q.pollFirst();
                int x = curr.x;
                int y = curr.y;
                int ct = curr.c;
                
                if (grid[x][y] == 'P') {
                    ans = "yes";
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dr[i];
                    int ny = y + dc[i];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c)
                        continue;
                    if (grid[nx][ny] == '#')
                        continue;
                    
                    if (vis[nx][ny])
                        continue;
                    vis[nx][ny] = true;
                    
                    q.addLast(new cell(nx, ny, ct + 1));
                }
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