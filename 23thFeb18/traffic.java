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
        //int max[] = new int[2];

        
        for(int k = 0 ; k < 2;k++){
            n = fs.nextInt();
            last = 0;
            run = 0;
            for(int i = 0;i<n;i++){
                curr = fs.nextInt();
                //max[k] = curr;
                for(int j = last + 1;j<=curr;j++){
                    d[k][j] = (run == 1) ? d[k][j-1] + 1.0 : d[k][j-1];
                }
                last = curr;
                run = 1 - run;
            }
            if(run==1)
                running[k] = true;
            for(int i = last+1;i<1000001;i++)
                d[k][i] =  (run == 1) ? d[k][i-1] + 1.0 : d[k][i-1];
        } 
        
        int collideTime = -1;
        for(int time = 1; time < 1000001; time++){
            Double a = d[g][time];
            Double b = d[1-g][time] + 4.4;
            if(Double.compare(a,b)< 0){
                collideTime = time;
                break;
            } 
        }
        if(collideTime != -1){
            System.out.println("bumper tap at time " + collideTime);
        }
        else {
            if(!running[g] && !running[1-g]){
                System.out.println("safe and sound");
            }
            else if(running[g] && running[1-g]){
                System.out.println("safe and sound");
            }
            else if(running[g] && !running[1-g]){
                System.out.println("safe and sound");
            }
            else {
                collideTime = 1000000 + (int) Math.ceil(d[g][1000000] - (d[1-g][1000000]+4.4));
                System.out.println("bumper tap at time " + collideTime);
            }
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