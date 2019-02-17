import java.util.*;
import java.io.*;

class D {

    static FastReader fs = new FastReader();
    static char []grid;
    static int []dr = {1,0,-1,0};
    static int []dc = {0,-1,0,1};
    static Set<String> v;

    static class node{
        String state;
        int cost;
        node(String state,int cost){
            this.state = state;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            grid = new char[9];
            v = new HashSet<>();
            for(int i=0;i<3;i++){
                char []r = fs.next().toCharArray();
                for(int j=0;j<3;j++){
                    char c = r[j];
                    if(c=='*')
                        grid[i*3+j] = '1';
                    else
                        grid[i*3+j] = '0';
                }
            }
            Deque<node> q = new ArrayDeque<>();
            q.add(new node("000000000",0));
            int ans = -1;
            //System.out.println(String.valueOf(grid));
            //System.out.println();
            while(!q.isEmpty()){
                node curr = q.poll();
                char []st = curr.state.toCharArray();
                //System.out.println(String.valueOf(st));
                int cost = curr.cost;
                if(Arrays.equals(st, grid)){
                    ans = cost;
                    break;
                }
                if(v.contains(String.valueOf(st)))
                    continue;
                v.add(String.valueOf(st));
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        st = curr.state.toCharArray();
                        st[i*3+j] = (char) ('1' - st[i*3+j] + '0');
                        for(int k=0;k<4;k++){
                            int ii = i + dr[k];
                            int jj = j + dc[k];
                            //System.out.println(ii + " " + jj);
                            if(ii >= 0 && ii < 3 && jj >= 0 && jj < 3){
                                //System.out.println(ii + " " + jj);
                                st[ii*3+jj] = (char) ('1' - st[ii*3+jj]+'0');
                            }
                        }
                        //System.out.println("with " + i + " " + j + " " + String.valueOf(st));
                        q.add(new node(String.valueOf(st),cost+1));
                    }
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