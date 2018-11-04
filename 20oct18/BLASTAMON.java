import java.util.*;
import java.io.*;

class BLASTAMON {

    static FastReader fs = new FastReader();
    static int n;
    static card []cards;

    static class card implements Comparable<card>{
        String name;
        int pt;
        card(String n,int p){
            name = n;
            pt = p;
        }
        @Override
        public int compareTo(card other){
            int tmp = this.pt-other.pt;
            if(tmp<0) return -1;
            if(tmp>0) return 1;
            return 0;
        }
    }

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n==0) 
                break;
            cards = new card[n];
            for(int i=0;i<n;i++){
                cards[i] = new card(fs.next(),fs.nextInt());
            }
            Arrays.sort(cards);
            for(int i=0;i<n;i++)
                System.out.println(cards[i].name);
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