import java.util.*;
import java.io.*;

class search {
    
    static FastReader fs = new FastReader();
    static int []dr = {1,1,0,-1,-1,-1,0,1};
    static int []dc = {0,-1,-1,-1,0,1,1,1};

    static char[][]grid;
    static String []toSearch;
    static int n;
    static int r,c;
    static ArrayList<position> [] al;
    static ArrayList<String> ans;

    static boolean check(String search,int nr,int nc,int at,int dir){
        if(at == search.length()) return true;
        if(nr<0 || nr>=r || nc<0 || nc>=c) return false;
        if(grid[nr][nc]==search.charAt(at)){
            return check(search,nr+dr[dir],nc+dc[dir],at+1,dir);
        }
        return false;
    }

    public static void main(String[] args) {
        int tc = 0;
        boolean flag = false;
        while(true){
            tc++;
            n = fs.nextInt();
            if(n==0) break;

            toSearch = new String[n];
            al = new ArrayList[26];
            for(int i=0;i<26;i++)
                al[i] = new ArrayList<position>();

            ans = new ArrayList<String>();

            for(int i=0;i<n;i++)
                toSearch[i]=fs.next();
            r = fs.nextInt();
            c = fs.nextInt();

            grid = new char[r][c];

            for(int i=0;i<r;i++){
                String rw = fs.next();
                grid[i] = rw.toCharArray();
                for(int j=0;j<grid[i].length;j++){
                    al[grid[i][j]-'A'].add(new position(i, j));
                }
            }
            
            for(int i=0;i<n;i++){
                char first = toSearch[i].charAt(0);
                boolean isThere = false;
                for(position pos:al[first-'A']){
                    for(int j=0;j<8;j++){
                        isThere|=check(toSearch[i],pos.r,pos.c,0,j);
                        if(isThere) break;
                    }
                    if(isThere){
                        break;
                    }
                }
                if(!isThere)
                    ans.add(toSearch[i]);
            }
            if(flag) System.out.println(); flag=true;
            System.out.printf("Puzzle number %d:\n",tc);
            if(ans.size()==0){
                System.out.println("ALL WORDS FOUND");
            }
            else{
                for(String each:ans){
                    System.out.println(each);
                }
            }

        }
    }

    static class position{
        int r,c;
        position(int x,int y){
            this.r = x;
            this.c = y;
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