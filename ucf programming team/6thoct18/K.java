import java.util.*;
import java.io.*;

class K {

    static FastReader fs = new FastReader();
    static String op,input;

    public static void main(String[] args) {
        op = fs.next();
        input = fs.next();
        if(op.equals("E")){
            int st=0,en=0;
            char last=' ';
            StringBuilder ans = new StringBuilder();
            int i;
            for(i=0;i<input.length();i++){
                if(i==0){
                    last = input.charAt(i);
                    ans.append(last);
                    st=0;
                    continue;
                }
                if(input.charAt(i)==last) {
                    continue;
                }
                else{
                    ans.append((i-st));
                    ans.append(input.charAt(i));
                    st=i;
                    last = input.charAt(i);
                }
            }
            ans.append(i-st);
            System.out.println(ans.toString());
        }   
        else{
            StringBuilder ans = new StringBuilder();
            char prev=' ';
            for(char c:input.toCharArray()){
                if(c>='0' && c<='9'){
                    for(int i=1;i<c-'0';i++){
                        ans.append(prev);
                    }
                }
                else{
                    prev=c;
                    ans.append(c);
                }
            }
            System.out.println(ans.toString());
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