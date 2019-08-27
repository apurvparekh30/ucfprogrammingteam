import java.util.*;
import java.io.*;

class sequences {

    static FastReader fs = new FastReader();
    static int n,k;
    static int []arr;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            k = fs.nextInt();

            arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=fs.nextInt();
            
            for(int i=0;i<k;i++){
                for(int j=1;j<n-i;j++){
                    arr[j-1]+=arr[j];
                }
            }
            boolean flag =false;
            for(int i=0;i<n-k;i++){
                if(flag) System.out.print(" "); flag =true;
                System.out.print(arr[i]);
            }
            System.out.println();
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