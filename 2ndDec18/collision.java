import java.util.*;
import java.io.*;

class collision {

    static FastReader fs = new FastReader();
    static int n, g;
    static ArrayList<pos> p;
    static int k, xx, yy, s, t;

    static int cc(int diff) {
        if (diff < 0)
            return 0;
        return 1;
    }

    static class pos implements Comparable<pos> {
        int x, y;

        pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pos o) {
            if (this.x == o.x)
                return Integer.compare(this.y, o.y);
            return Integer.compare(this.x, o.x);
        }
        @Override
        public String toString(){
            return x+" "+y;
        }
    }

    public static void main(String[] args) {
        while (true) {
            n = fs.nextInt();
            if (n == 0)
                break;
            g = fs.nextInt();
            p = new ArrayList<pos>();
            for (int j = 0; j < g; j++) {
                k = fs.nextInt();
                xx = fs.nextInt();
                yy = fs.nextInt();
                s = fs.nextInt();
                t = fs.nextInt();
                for (int i = 0; i < k; i++) {
                    p.add(new pos(xx + i * s, yy + i * t));
                }
            }
            
            Collections.sort(p);
            //System.out.println(p.toString());
            
            int cnt = 0;
            for (int i = 0; i < p.size(); i++) {
                pos a = p.get(i);
                boolean r = false;
                boolean c = false;
                boolean d1 = false;
                boolean d2 = false;
                for (int j = i + 1; j < p.size(); j++) {
                    pos b = p.get(j);
                    if (!r) {
                        if (a.x == b.x) {
                            r = true;
                            cnt++;
                            continue;
                        }
                    }
                    if (!c) {
                        if (a.y == b.y) {
                            c = true;
                            cnt++;
                            continue;
                        }
                    }
                    if (!d1) {
                        if (Math.abs(b.x - a.x) == Math.abs(b.y - a.y) && (b.y - a.y) > 0) {
                            d1 = true;
                            cnt++;
                            continue;
                        }
                    }
                    if (!d2) {
                        if (Math.abs(b.x - a.x) == Math.abs(b.y - a.y) && (b.y - a.y) < 0) {
                            d2 = true;
                            cnt++;
                            continue;
                        }
                    }
                }
            }
            System.out.println(cnt);
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