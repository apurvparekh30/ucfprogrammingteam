import java.util.*;
import java.io.*;

class tadpole {

    static FastReader fs = new FastReader();
    static int n;
    static double r;
    static int []x2,y2;
    static final double ESP = 1e-9;

    static double getDist(double x1,double y1,double x2,double y2){
        return Math.hypot(x1-x2, y1-y2);
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=0;t<tc;t++){
            n = fs.nextInt();
            r = fs.nextDouble()/2.0;
            int inside = 0;
            x2 = new int[n];
            y2 = new int[n];
            for(int i=0;i<n;i++){
                x2[i] = fs.nextInt();
                y2[i] = fs.nextInt();
            }
            for(int x1=-100;x1<=100;x1++){
                for(int y1=-100;y1<=100;y1++){
                    int tmp = 0;
                    for(int i=0;i<n;i++){
                        double dist = getDist(x1,y1,x2[i],y2[i]);
                        if((r - dist) >  ESP)
                            tmp++;
                    }
                    inside = Math.max(tmp,inside);
                }
            }
            
            System.out.println(inside);
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
