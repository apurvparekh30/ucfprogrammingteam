import java.util.*;
import java.io.*;

class acm{

    static FastReader fs = new FastReader();
    static boolean []solved;

    public static void main(String[] args) {
        int penalty = 0;
        int no = 0;
        solved = new boolean[100];
        int [] wrongs = new int [100];
        while(true){
            int m = fs.nextInt();
            if(m==-1)
                break;
            char c = fs.next().charAt(0);
            String res = fs.next();
            if(!solved[c]){
                if(res.equals("wrong"))
                    wrongs[c]++;
                else{
                    penalty+=m;
                    penalty+=wrongs[c] * 20;
                    solved[c] = true;
                    no++;
                }
            }
        }
        System.out.println(no+" "+penalty);
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