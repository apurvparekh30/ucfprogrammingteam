import java.util.*;
import java.io.*;

class zigzag{

    static FastReader fs = new FastReader();
    static int []arr,ll,lg,rl,rg;
    static int n;

    public static void main(String[] args) {
        n = fs.nextInt();
        arr = new int[n];
        ll = new int[n];
        lg = new int[n];
        rl = new int[n];
        rg = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = fs.nextInt();
            if(i > 0){
                if(arr[i] > arr[i-1]){
                    ll[i] = ll[i-1] + 1;
                }
                if(arr[i] < arr[i-1]){
                    lg[i] = lg[i-1] + 1;
                }
            }
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i] < arr[i+1]){
                rg[i] = rg[i+1] + 1;
            }
            if(arr[i] > arr[i+1]){
                rl[i] = rl[i+1] + 1;
            }
        }
        /* System.out.println(Arrays.toString(ll));
        System.out.println(Arrays.toString(lg));
        System.out.println(Arrays.toString(rl));
        System.out.println(Arrays.toString(rg)); */
        int ans = 1;
        for(int i=0;i<n;i++){
            int tmp;
            tmp = 2 * Math.min(ll[i],rl[i]) + 1;

            if(ans < tmp){
                ans = tmp;
            }
            tmp = 2 * Math.min(lg[i],rg[i]) + 1;
            if(ans < tmp){
                ans = tmp;
            }
        }
        System.out.println(ans);
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