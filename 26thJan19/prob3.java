import java.util.*;
import java.io.*;

class prob3{

    static FastReader fs = new FastReader();
    static HashMap<Integer,String> hm;
    public static void main(String[] args) {
        hm = new HashMap<>();
        hm.put(3,"Mercer");
        hm.put(4,"Bears");
        hm.put(18,"Grrrr");
        hm.put(33,"Bite");
        int tc = 0;

        while(true){
            tc++;
            int l = fs.nextInt();
            int h = fs.nextInt();
            if(l > h)
                break;
            System.out.printf("Case %d:\n",tc);
            for(int i=l;i<=h;i++){
                StringBuilder sb = new StringBuilder();
                if(i%3 == 0)
                    sb.append(hm.get(3));
                if(i%4 == 0)
                    sb.append(hm.get(4));
                if(i%18==0)
                    sb.append(hm.get(18));
                if(i%33==0)
                    sb.append(hm.get(33));
                if(sb.length()==0)
                    sb.append(i);
                System.out.println(sb);
            }
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