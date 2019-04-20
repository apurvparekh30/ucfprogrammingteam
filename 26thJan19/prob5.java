import java.util.*;
import java.io.*;

class prob5 {

    static FastReader fs = new FastReader();
    static int n, c, s, b, r;
    

    static class cp implements Comparable<cp>{
        String name;
        int h,m,s;
        cp(String nm,int h,int m,int s){
            name = nm;
            this.h = h;
            this.m = m;
            this.s = s;
        }
        @Override
        public String toString(){
            return name + " " + h + " hour(s) " + m + " minute(s) " + s + " second(s)";
        }

        @Override
        public int compareTo(cp o){
            if(h == o.h){
                if(m == o.m){
                    return Integer.compare(s,o.s);
                }
                else{
                    return Integer.compare(m, o.m);
                }
            }
            return Integer.compare(h,o.h);
        }
    }

    public static void main(String[] args) {
        n = fs.nextInt();
        for (int tt = 1; tt <= n; tt++) {
            System.out.printf("Triathlon #%d\n", tt);
            c = fs.nextInt();
            s = fs.nextInt();
            b = fs.nextInt();
            r = fs.nextInt();
            String nm;
            double sec;
            cp [] cc = new cp[c];
            for (int i = 0; i < c; i++) {
                nm = fs.next();
                double ss = fs.nextDouble();
                double sb = fs.nextDouble();
                double sr = fs.nextDouble();
                sec = 0.0f;
                sec += (s / ss);
                sec += (b / sb);
                sec += (r / sr);
                int hours, minutes;

                minutes = (int) (sec / 60);
                sec = sec % 60;
                hours = minutes / 60;
                minutes = minutes % 60;
                cc[i] = new cp(nm,hours,minutes,(int) sec);
                //System.out.printf("%s %d hour(s) %d minutes(s) %d second(s)\n", nm, hours, minutes, (int) sec);
            }
            Arrays.sort(cc);
            for(int i=0;i<cc.length;i++)
                System.out.println(cc[i]);

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