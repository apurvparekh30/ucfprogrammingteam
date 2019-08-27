import java.util.*;
import java.io.*;

class A {

    static FastReader fs = new FastReader();
    static PriorityQueue<Integer> []hs;
    
    public static void main(String[] args) {
        hs = new PriorityQueue[3001];
        int n = fs.nextInt();

        for(int i=0;i<=3000;i++)
            hs[i] = new PriorityQueue<Integer>();

        for(int i=1;i<=n;i++){
            for(int j=0;j<5;j++)
                for(int k=0;k<5;k++)
                    hs[fs.nextInt()].add(i);
        }

        int c1=101,c2=101;
        for(int i=0;i<=3000;i++){
            if(hs[i].size()>=2){
                if(c1==hs[i].peek()){
                    c1 = hs[i].poll();
                    c2 = Math.min(c2,hs[i].poll());
                }
                else    
                    c1 = Math.min(c1,hs[i].poll());
            }
        }
        if(c1==101 && c2==101){
            System.out.println("no ties");
        }
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