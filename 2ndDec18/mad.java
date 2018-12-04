import java.util.*;
import java.io.*;

class mad{

    static FastReader fs = new FastReader();
    static int k;
    static int []sq;

    public static void main(String[] args) {
        while(true){
            k = fs.nextInt();
            if(k==0)
                break;
            sq = new int[k+1];
            for(int i=1;i<=k;i++){
                sq[i] = fs.nextInt();   
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=1;i<=k;i++){
                int diff = sq[i] - sq[i-1];
                for(int j=0;j<diff;j++){
                    ans.add(i);
                }
            }
            boolean flag = false;
            for(int c:ans){
                if(flag)
                    System.out.print(" ");
                flag = true;
                System.out.print(c);
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