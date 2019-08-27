import java.util.*;
import java.io.*;

class seating{

    static FastReader fs = new FastReader();
    static int c;
    static int cnt;

    static int permute(int couples,int mask){
        if(couples==0){
            return 1;
        }
        int sum=0;
        for(int i=0;i<2*c;i++){
            if((mask&(1<<i))== 0){
                mask=mask|(1<<i);
                for(int j=i+2;j<2*c;j++){
                    if((mask&(1<<j))==0){
                        sum+=permute(couples-1,mask|(1<<j));
                    }
                }
                mask=mask&(~(1<<i));
                break;
            }
        }
        return sum;
    }   

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            c = fs.nextInt();
            if(c==1) {
                System.out.println(0);
                continue;
            }
            cnt = 0;
            
            System.out.println(permute(c,0));
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