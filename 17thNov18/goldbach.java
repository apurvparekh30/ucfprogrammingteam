import java.util.*;
import java.io.*;

class goldbach{

    static FastReader fs = new FastReader();
    static int x;
    static ArrayList<Integer> primes;
    static boolean isPrime[];

    static void generate(){
        for(int i=2;i<x;i++){
            boolean flag = true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                primes.add(i);
                isPrime[i] = true;
            }
           
        }
    }

    public static void main(String[] args) {
        x = fs.nextInt();
        isPrime = new boolean[x];
        primes = new ArrayList<>();
        generate();
        int cnt = 0;
        while(x>=3){
            cnt++;
            for(int a:primes){
                if(isPrime[x-a]){
                    x = (x-a) - a;
                    break;
                }
            }
        }
        System.out.println(cnt);
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