import java.util.*;
import java.io.*;

class mirror {

    static FastReader fs = new FastReader();
    static char []word;
    static char []repl = new char[200];
    static StringBuilder ans;

    static StringBuilder replace(){
        StringBuilder b = new StringBuilder();
        if(!valid())
            return new StringBuilder("INVALID");
        for(int i = word.length-1;i>=0;i--){
            char c = word[i];
            b.append(repl[c]);
        }
        return b;
    }

    public static void main(String[] args) {
        for(char c='a';c<='z';c++){
            repl[c] = c;
            if(c=='b')
                repl[c] = 'd';
            if(c=='d')
                repl[c] = 'b';
            if(c=='p')
                repl[c] = 'q';
            if(c=='q')
                repl[c] = 'p';
        }
        while(true){
            word = fs.nextLine().toCharArray();
            ans = new StringBuilder();
            if(word[0]=='#')
                break;
            //System.out.println(repl);
            ans = replace();
            System.out.println(ans.toString());
        }
        
    }
    static boolean valid(){
        for(char c:word){
            if(c!='b' && c!='d' && c!='i' && c!='o' && c!='v' && c!='w' && c!='x' && c!='p' && c!='q')
                return false;
        }
        return true;
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