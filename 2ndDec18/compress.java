import java.util.*;
import java.io.*;

class compress {

    static FastReader fs = new FastReader();
    static int w,t;
    static char [][]brd;

    static int score(int sx,int ex,int sy,int ey){
        int wc = 0,bc=0;
        //System.out.println(sx + " " + ex + " " + sy + " " + ey);
        int total = (ex-sx)*(ey-sy);
        //System.out.println(total);
        for(int i=sx;i<ex;i++){
            for(int j=sy;j<ey;j++){
                if(brd[i][j] == '0')
                    wc++;
                else
                    bc++;
            }
        }
        //System.out.println(wc+ " " + total);
        int bp = (int) ((bc*100)/total);
        int wp = (int) ((wc*100)/total);
        if(bp >= t)
            return 1;
        if(wp >= t)
            return 0;
        return -1;
    }

    static void color(int sx,int ex,int sy,int ey,int col){
        for(int i=sx;i<ex;i++){
            for(int j=sy;j<ey;j++){
                brd[i][j] =(char) ('0' + col);
            }
        }
    }

    static void rec(int sx,int ex,int sy,int ey){
        //System.out.println(sx + " " + ex + " " + sy + " " + ey);
        if((ex-sx)==1 && (ey-sy)==1)
            return;
        int tmp = score(sx,ex,sy,ey);
        //System.out.println(wper);
        if(tmp==0){
            color(sx,ex,sy,ey,0);
            return;
        }
        if(tmp==1){
            color(sx,ex,sy,ey,1);
            return;
        }
        int move = (ex-sx) / 2;
        rec(sx,sx+move,sy,sy+move);
        rec(sx,sx+move,sy+move,ey);
        rec(sx+move,ex,sy,sy+move);
        rec(sx+move,ex,sy+move,ey);
    }

    public static void main(String[] args) {
        int tc = 0;
        while(true){
            tc++;
            w = fs.nextInt();
            if(w==0)
                break;
            t = fs.nextInt();
            brd = new char[w][];
            for(int i=0;i<w;i++){
                brd[i] = fs.next().toCharArray();
            }
            rec(0,w,0,w);
            System.out.printf("Image %d:\n",tc);
            for(int i=0;i<w;i++){
                System.out.println(new String(brd[i]));
            }
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