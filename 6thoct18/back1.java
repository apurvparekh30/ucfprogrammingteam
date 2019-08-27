import java.util.*;
import java.io.*;

class A {

    static FastReader fs = new FastReader();
    static HashMap<Integer,pair> hm;

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
        hm = new HashMap<Integer,pair>();
        int n = fs.nextInt();
        
        //System.out.println(al.toString());
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    int no = fs.nextInt();
                    if(hm.containsKey(no)){
                        hm.put(i,hm.get(no));
                    }
                }
            }
        }


        
        int c1=101,c2=102;
        for(pair val:hm.values()){
            if(val.x < c1){
                c1=val.x;
                c2=val.y;
            }
            else if(val.x==c1){
                if(val.y < c2){
                    c2 = val.y;
                }
            }
        }
        
        if(c1==101 && c2==102)
            System.out.println("no ties");
        else    
            System.out.println(c1+" "+c2);


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