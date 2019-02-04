import java.util.*;
import java.io.*;

class threesq{

    static FastReader fs = new FastReader();
    static int w1,h1,w2,h2,w3,h3;
    static int area = 0;

    static int solve(){
        int tmp;
        for(int i=0;i<2;i++){
            tmp = w1; w1 = h1; h1 = tmp; 
            for(int j=0;j<2;j++){
                tmp = w2; w2 = h2; h2 = tmp;
                for(int k=0;k<2;k++){
                    tmp = w3; w3 = h3; h3 = tmp;
                    if(h1==h2 && h2==h3){
                        if((w1+w2+w3) == h1)
                            return 1;
                    }   
                    if(h1==h2){
                        if((w1+w2) == w3 && w3==(h1+h3))
                            return 1;
                    }
                    if(h2==h3){
                        if((w2+w3) == w1 && w1==(h2+h1))
                            return 1;
                    }
                    if(h1 == h3){
                        if((w1+w3) == w2 && w2==(h1+h2))
                            return 1;
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        w1 = fs.nextInt();
        h1 = fs.nextInt();
        w2 = fs.nextInt();
        h2 = fs.nextInt();
        w3 = fs.nextInt();
        h3 = fs.nextInt();
        area = ((w1 * h1) + (w2 * h2) + (w3 * h3));
        int tmp = (int)Math.sqrt(area);
        if((tmp * tmp) == area){
            System.out.println(solve());
        }
        else{
            System.out.println(0);
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