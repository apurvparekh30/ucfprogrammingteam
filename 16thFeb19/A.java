import java.util.*;
import java.io.*;

class A{

    static FastReader fs = new FastReader();
    static int []row,col;
    
    static String isValid(){
        for(int q=1;q<row.length;q++){
            for(int i=0;i<q;i++){
                if(row[i] == row[q] || col[i]==col[q]){
                    return "invalid";
                }
            }
            for(int i=0;i<q;i++){
                if(Math.abs(row[i] - row[q]) == Math.abs(col[i]-col[q]))
                    return "invalid"; 
            }
        }
        return "valid";
    }

    public static void main(String[] args) {
        row = new int[8];
        col = new int[8];
        int cnt = 0;
        for(int i=0;i<8;i++){
            char []r = fs.next().toCharArray();
            for(int j=0;j<r.length;j++){
                if(r[j] == '*'){
                    if(cnt < 8){
                        row[cnt] = i;
                        col[cnt] = j;
                    }
                    cnt++;
                }
            }
        }
        if(cnt > 8)
            System.out.println("invalid");
        else
            System.out.println(isValid());
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