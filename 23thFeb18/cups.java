import java.util.*;
import java.io.*;

class cups {

    static FastReader fs = new FastReader();
    static int n;
    static Map<Integer,String> mp;
    static int []arr;

    /* static class cup implements Comparable<cup> {
        int r;
        String color;
        cup(int r,String color){
            this.r = r;
            this.color = color;
        }
        @Override
        public int compareTo(cup o){
            return Integer.
        }
        @Override
        public String toString() {
            return color;
        }
    } */
    public static void main(String[] args) {
        n = fs.nextInt();
        arr = new int[n];
        mp = new HashMap<>();
        for(int i=0;i<n;i++){
            String a = fs.next();
            String b = fs.next();
            try {
                arr[i] = Integer.parseInt(a);
                arr[i] = arr[i]/2;
                mp.put(arr[i],b);
            }
            catch(Exception e){
                arr[i] = Integer.parseInt(b);
                mp.put(arr[i],a);
            }
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            System.out.println(mp.get(arr[i]));
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