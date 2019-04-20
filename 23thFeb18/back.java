import java.util.*;
import java.io.*;

class traffic{
    static FastReader fs = new FastReader();
    static int n;
    static double d[][];
    public static void main(String[] args) {

        int ii = fs.nextInt();
        int jj = fs.nextInt();

        int g = 1;

        if(ii > jj){
            g = 0;
        }

        d = new double[2][1000001];

        d[0][0] = ii;
        d[1][0] = jj;

        int n,curr,last,run;

        boolean running[] = new boolean[2];
        int max[] = new int[2];

        
        for(int k = 0 ; k < 2;k++){
            n = fs.nextInt();
            last = 0;
            run = 0;
            for(int i = 0;i<n;i++){
                curr = fs.nextInt();
                max[k] = curr;
                for(int j = last + 1;j<=curr;j++){
                    d[k][j] = (run == 1) ? d[k][j-1] + 1.0 : d[k][j-1];
                }
                last = curr;
                run = 1 - run;
            }
            for(int i = last+1;i<1000006;i++)
                d[k][i] =  d[k][j] = (run == 1) ? d[k][j-1] + 1.0 : d[k][j-1];
        } 

        /* System.out.println(max[0] + " " + max[1]);
        for(int i=0;i<=max[0];i++)
            System.out.print(d[0][i] + " ");

        System.out.println();
        
        for(int i=0;i<=max[1];i++)
            System.out.print(d[1][i]+ " ");
        
        System.out.println();
        System.out.println(running[0] + " " + running[1]); */
        
        int collideTime = -1;
        double a = 0.0;
        double b = 0.0;
        for(int time = 1; time < 1000001; time++){
            if(time > max[g] && time > max[1-g]){
                if(running[g] && running[1-g])
                    break;
            }
            if(time > max[1-g] && !running[1-g])
                break;
            if(time > max[g] && running[g]){
                break;
            }
            if(time > max[g] && !running[g]){
                collideTime = max[1-g] + (int) Math.ceil(d[g][max[g]] - (d[1-g][max[1-g]]+4.4));
                break;
            }
            
            if(time > max[g] && running[g]){
                a = a + 1.0;
            }
            else if(time <= max[g]){
                a = d[g][time];
            }
            if(time > max[1-g] && running[1-g]){
                b = b + 1.0;
            }
            else if(time <= max[1-g]){
                b = d[1-g][time];
            }
            //System.out.println("at time " + time + " " + a + " " + b);
            if(Double.compare(a,b+4.4)< 0){
                collideTime = time;
                break;
            } 
        }
        if(collideTime != -1){
            System.out.println("bumper tap at time " + collideTime);
        }
        else {
            System.out.println("safe and sound");
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