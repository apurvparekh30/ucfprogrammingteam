import java.util.*;
import java.io.*;

class prob6{

    static FastReader fs = new FastReader();
    static int []arr;
    static boolean [] flag;

    public static void main(String[] args) {
        int n = fs.nextInt();
        for(int tt=1;tt<=n;tt++){
            String ln = fs.nextLine();
            arr = new int[1000000];
            flag = new boolean[1000000];
            StringTokenizer st = new StringTokenizer(ln);
            int i = 0;
            int tokens = 0;
            while(st.hasMoreTokens()){
                arr[i++] = Integer.parseInt(st.nextToken());
                tokens++;
            }
            boolean f = true;
            int idx = 0;
            for(i=0;i<arr.length;i++){
                int nx = i+arr[idx];
                //System.out.println(nx);
                if(nx >= arr.length)
                    break;
                if(flag[nx]){
                    //System.out.println("at " + nx);
                    f = false;
                    break;
                }
                flag[nx] = true;
                idx=(idx+1) % tokens;
            }
            if(f)
                System.out.println(ln + " - can be juggled" );
            else
                System.out.println(ln + " - cannot be juggled" );
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