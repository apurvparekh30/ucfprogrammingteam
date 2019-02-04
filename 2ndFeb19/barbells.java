import java.util.*;
import java.io.*;

class barbells{

    static FastReader fs = new FastReader();
    static int b,p;
    static int [] bw,pw;
    static TreeSet<Integer> ts;

    public static void main(String[] args) {
        b = fs.nextInt();
        p = fs.nextInt();
        bw = new int[b];
        pw = new int[p];
        ts = new TreeSet<>();
        for(int i=0;i<b;i++){
            bw[i] = fs.nextInt();
            ts.add(bw[i]);
        }
        for(int i=0;i<p;i++){
            pw[i] = fs.nextInt();
        }
        for(int i=1;i<(1<<p);i++){
            int sum = 0;
            int size = p - Integer.bitCount(i);
            int []remain = new int[size];
            int idx = 0;
            for(int j=0;j<p;j++){
                if((i & (1<<j))!=0)
                    sum+=pw[j]; 
                else    
                    remain[idx++] = pw[j]; 
            }

            for(int mask=1;mask < (1<<size);mask++){
                int tmp = 0;
                for(int j=0;j<size;j++){
                    if((mask & (1<<j))!=0){
                        tmp+=remain[j];
                    }
                }
                if(tmp == sum){
                    for(idx = 0;idx < bw.length;idx++){
                        ts.add(bw[idx] + (2 * sum));
                    }
                    break;
                }
            }
        }
        for(int ans:ts){
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