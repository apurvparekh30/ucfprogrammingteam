import java.util.*;
import java.io.*;

class doubleland {

    static FastReader fs = new FastReader();
    static int n,k;
    static int []land;
    static boolean []desire;
    static int tot,matched;
    static long totLand;

    static void process(int num){
        int cnt = 0;
        long sum = 0;
        long target = totLand/2;

        for(int i=0;i<n;i++){
            if(sum > target) return;
            if((num&(1<<i))==0) continue;
            sum+=land[i];
            if(desire[i]==true) cnt++;
        }
        if(sum==(totLand/2)){
            tot++;
            if(cnt==k)
                matched++;
        }
    }

    
    static int gcd(int tot,int matched){
        int tmp;
        if(tot < matched) {
            tmp = tot;
            tot = matched;
            matched = tmp;
        }
        while(matched > 0){
            tmp = tot % matched;
            tot = matched;
            matched = tmp;
        }
        return tot;
    }
    public static void main(String[] args) {
        int tc =fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            land = new int[n];
            totLand = 0;
            for(int i=0;i<n;i++){
                land[i]=fs.nextInt();
                totLand+=land[i];
            }
                
            k = fs.nextInt();
            desire = new boolean[n];
            for(int i=0;i<k;i++)
                desire[fs.nextInt() - 1]=true;
            tot = 0;
            matched = 0;
            for(int i=0;i<(1<<n);i++){
                process(i);
            }
            int div;
            while((div=gcd(tot,matched))!=1){
                matched = matched/div;
                tot = tot/div;
            }
            System.out.println(matched+"/"+tot);
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