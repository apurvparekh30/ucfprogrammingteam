import java.util.*;
import java.io.*;

class rug{

    static FastReader fs = new FastReader();
    static int n,s;
    static int [][] g;
    static TreeMap<Integer,Integer> hm = new TreeMap<>(); 

    public static void main(String[] args) {
        n = fs.nextInt();
        s = fs.nextInt();
        g = new int[n][n];
        for(int i=0;i<n;i++){
            char [] ch=fs.next().toCharArray();
            for(int j=0;j<ch.length;j++){
                if(ch[j]=='D'){
                    g[i][j] = 1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>0)
                    g[i][j]+=g[i-1][j];
                if(j>0)
                    g[i][j]+=g[i][j-1];
                if(i>0 && j>0)
                    g[i][j]-=g[i-1][j-1];
            }
        }

        /* for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(g[i]));
        } */
        s--;
        for(int i=0;(i+s)<n;i++){
            for(int j=0;(j+s)<n;j++){
                int sum = g[i+s][j+s];
                if(i>0)
                    sum-=g[i-1][j+s];
                if(j>0)
                    sum-=g[i+s][j-1];
                if(i>0 && j>0)
                    sum+=g[i-1][j-1];
                if(hm.containsKey(sum)){
                    int val = hm.get(sum);
                    hm.put(sum,val+1);
                }
                else{
                    hm.put(sum,1);
                }
            }
        }
        for(Integer x:hm.keySet()){
            int val = hm.get(x);
            System.out.println(x+" "+val);
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