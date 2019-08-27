import java.util.*;
import java.io.*;

class morecombos {

    static FastReader fs = new FastReader();
    static int [][] chocs;
    static int b,k;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            b = fs.nextInt();
            k = fs.nextInt();
            
            chocs = new int[b][];
            for(int i=0;i<b;i++){
                int m =fs.nextInt();
                chocs[i] = new int[m];
                for(int j=0;j<m;j++){
                    chocs[i][j] = fs.nextInt();
                }
            }
            //System.out.println("b = " + b + " k = " + k + " " + Arrays.toString(uniques));
            int res = 0;
            for(int num=0;num<(1<<b);num++){
                if(Integer.bitCount(num)==k){
                    int tmp=0;c
                    boolean []used = new boolean[32];
                    for(int i=0;i<b;i++){
                        if((num&(1<<i))==0) continue;
                        for(int chc:chocs[i]){
                            if(used[chc]) continue;
                            used[chc]=true;
                            tmp++;
                        }
                    }
                    if(res < tmp) res = tmp;
                    if(res == 31) break;
                }
            }
            System.out.println(res);
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