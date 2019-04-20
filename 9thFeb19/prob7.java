import java.util.*;
import java.io.*;

class prob7 {

    static FastReader fs = new FastReader();
    static int n;
    static HashMap<String,Integer> hm;

    static class word implements Comparable<word>{
        String w;
        int c;
        word(String w,int c){
            this.w = w;
            this.c = c;
        }
        @Override
        public int compareTo(word other){
            if(c == other.c){
                return w.compareTo(other.w);
            }
            return Integer.compare(other.c, c);
        }
        @Override
        public String toString(){
            return c + " " + w;
        }
    }
    public static void main(String[] args) {
        n = fs.nextInt();
        hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            sb = new StringBuilder();
            while(true){
                String line = fs.nextLine();
                if(line == null || line.isEmpty())
                    break;
                sb.append(line);
            }
            //System.out.println(sb.toString());
            StringTokenizer st = new StringTokenizer(sb.toString());
            while(st.hasMoreTokens()){
                String token = st.nextToken();
                //System.out.println(token);
                if(token.charAt(0) == '#'){
                    if(Character.isLetter(token.charAt(token.length()-1))){
                        token = token.substring(1);
                    }
                    else{
                        token= token.substring(1,token.length()-1);
                    }
                    token = token.toLowerCase();
                    if(hm.containsKey(token)){
                        hm.put(token,hm.get(token)+1);
                    }
                    else{
                        hm.put(token,1);
                    }
                }
            }
        }
        ArrayList<word> al = new ArrayList<>();
        for(String w:hm.keySet()){
            al.add(new word(w,hm.get(w)));
        }
        Collections.sort(al);
        for(word w:al){
            System.out.println(w);
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