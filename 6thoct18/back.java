import java.util.*;
import java.io.*;

class A {

    static FastReader fs = new FastReader();
    static int arr[];

    static class pair implements Comparable<pair> {
        int x, y;

        pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
        @Override
        public int compareTo(pair other) {
            if (x == other.x) {
                int diff = y - other.y;
                if (diff < 0)
                    return -1;
                if (diff > 0)
                    return 1;
                return 0;
            }
            int diff = x - other.x;
            if (diff < 0)
                return -1;
            if (diff > 0)
                return 1;
            return 0;
        }
        @Override
        public String toString(){
            return x+" "+y;
        }
    }

    public static void main(String[] args) {
        arr = new int[3001];
        int n = fs.nextInt();
        int c1 = 101;
        int c2 = 102;
        ArrayList<pair> al = new ArrayList<pair>();
        //System.out.println(al.toString());
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    int no = fs.nextInt();
                    if (arr[no] == 0) {
                        arr[no] = i;
                        continue;
                    }
                    if (i == 1)
                        continue;
                    if(arr[no]!=0){
                        //System.out.println(arr[no]+" " +i);
                        al.add(new pair(arr[no],i));
                    }
                }
            }
        }
        //System.out.println(al.toString());
        Collections.sort(al);
        if (al.isEmpty())
            System.out.println("no ties");
        else
            System.out.println(al.get(0));
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