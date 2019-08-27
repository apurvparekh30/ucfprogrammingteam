import java.util.*;
import java.io.*;

class jump{

    static FastReader fs = new FastReader();
    static int b;
    static int []arr;
    static int up,down;
    static int cnt = 0;

    static boolean valid(int []perm){
        for(int i=1;i<perm.length;i++){
            if(perm[i]>perm[i-1]){
                if(perm[i]-perm[i-1] > up) return false;
            }
            else {
                if(perm[i-1] - perm[i] > down) return false;
            }
        }
        return true;
    }

    static void bk(int pos,int []perm,int mask){
        if(pos == b){
            if(valid(perm)) cnt++;
            return;
        }
        for(int i=0;i<b;i++){
            if((mask & (1<<i)) == 0){
                perm[pos]=arr[i];
                bk(pos+1,perm,mask|(1<<i));
            }
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            b =fs.nextInt();
            arr = new int[b];
            for(int i=0;i<b;i++)
                arr[i]=fs.nextInt();
            up = fs.nextInt();
            down = fs.nextInt();
            cnt = 0;
            bk(0,new int[b],0);
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