import java.util.*;
import java.io.*;

class D {

    static FastReader fs = new FastReader();
    static int L,W;
    static int O,I;
    static int dir[];
    static ArrayList<Integer> cars[];
    //static int cars[][];
    static int x=0,y;
    static int []speed;
    static String sim;

    static boolean squished(int x,int y,int t){
        int st,en;
        for(int i=0;i<cars[x].size();i++){
            st = cars[x].get(i)+((t-1)*speed[x]*dir[x%2]);
            en = st + (speed[x]*dir[x%2]);
            if(st==en && y==st) {
                return true;
            }
            if(dir[x%2]==-1){
                if(y>=en && y<st){
                    return true;
                }
            }
            else{
                if(y>st && y<=en) {
                    return true;
                }
            }
        }
        return false;
    }

    static String process(){
        int t = 0;
        for(char c:sim.toCharArray()){
            t++;
            if(c=='U'){
                x = x + 1;
                if(squished(x,y,t)){
                    return "squish";
                }
            }
            else if(c=='D'){
                x = x - 1;
                //x = Math.max(1,x);
                if(squished(x,y,t)){
                    return "squish";
                }
            }
            else if(c=='L'){
                y = y - 1;
                //y = Math.max(1,y);
                if(squished(x,y,t)){
                    return "squish";
                }
            }
            else{
                y = y + 1;
                //y = Math.min(y,W);
                if(squished(x,y,t)){
                    return "squish";
                }
            }
        }
        if(x>L) return "safe";
        return "squish";
    }

    public static void main(String[] args) {
        L = fs.nextInt();
        W = fs.nextInt();
        dir = new int[2];
        cars = new ArrayList[L+2];
        speed = new int[L+2];

        dir[L%2]=1;
        dir[1-(L%2)]=-1;
        //System.out.println(Arrays.toString(dir));

        cars[0] = new ArrayList<Integer>();
        cars[L+1] = new ArrayList<Integer>();

        for(int i=L;i>0;i--){
            cars[i] = new ArrayList<Integer>();
            O = fs.nextInt();
            I = fs.nextInt();
            speed[i] = fs.nextInt();
            if(dir[i%2]==-1){
                O = W-1-O;
                while(O>=0){
                    cars[i].add(O);
                    O-=I;
                }
            }
            else{
                while(O<W){
                    cars[i].add(O);
                    O+=I;
                }
            }
        }
        x = 0;
        y = fs.nextInt();
        sim = fs.next();
        System.out.println(process());
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