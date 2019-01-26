import java.util.*;
import java.io.*;

class hidden{

    static FastReader fs = new FastReader();
    
    public static void main(String[] args) {
        char []pass = fs.next().toCharArray();
        char []mes = fs.next().toCharArray();
        int []temp = new int[100];
        Arrays.fill(temp,-1);
        for(int i = 0;i<pass.length;i++){
            char c = pass[i];
            temp[c] = i;
        }
        int idx = 0;
        int midx = 0;
        for(;idx<pass.length && midx<mes.length;midx++){
            //System.out.println(mes[midx] + " " + pass[idx]);
            if(mes[midx] == pass[idx]){
                idx++;
            }
            else if(temp[mes[midx]] > idx){
                //System.out.println(idx + " " + midx);
                break;
            }
        }
        if(idx < pass.length)
            System.out.println("FAIL");
        else
            System.out.println("PASS");
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