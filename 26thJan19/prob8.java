import java.util.*;
import java.io.*;

class prob8{
    
    static FastReader fs = new FastReader();
    static int n,m,k;
    static HashMap<String,Integer> map;
    static char[] temp;
    static int mr,mc;

    static boolean check(int r,int c,char[] in){
        return inBounds(r, c) && (in[r * m + c] == '.' || (int)(in[r * m + c] - '0') == k || in[r * m + c] == 'x');
    }
    static boolean inBounds(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
        
    public static void main(String[] args) {
        int cs = fs.nextInt();
        for(int tt=1;tt<=cs;tt++){
            map = new HashMap<>();
            n = fs.nextInt();
            m = fs.nextInt();
            k = fs.nextInt();
            temp = new char[n * m];
            for(int i=0;i<n;i++){
                char []in = fs.next().toCharArray();
                for(int j=0;j<m;j++){
                    temp[i*m+j] = in[j];
                    if(in[j]=='x'){
                        mr = i;
                        mc = j;
                    }
                }
            }
            String init = new String(temp);
            map.put(init,0);
            ArrayDeque<String> ad = new ArrayDeque<>();
            ad.addLast(init);
			
			int out = -1;
			while(!ad.isEmpty()){
                String curr = ad.pollFirst();
                int hr = -1, hc = -1, tr = -1, tc = -1;
                char[] temp = curr.toCharArray();
                for(int i = 0; i < n * m; ++i) {
                    if(temp[i] >= '0' && temp[i] <= '9') {
                        if(k == 1 && temp[i] == '0') {
                            hr = i / m;
                            hc = i % m;
                            temp[i] = '.';
                        }
                        else if((int)(temp[i] - '0') == k - 1) {
                            temp[i] = '.';
                            tr = i / m;
                            tc = i % m;
                        }
                        else temp[i]++;
                        
                        if(temp[i] == '1') {
                            hr = i / m;
                            hc = i % m;
                        }
                    }
                }
                if(hr==mr && hc == mc){
                    out = map.get(curr);
                    break;
                }
                for(int i=0;i<4;i++){
                    int nr = hr,nc = hc;
                    if(i==0) nr--;
                    if(i==1) nc++;
                    if(i==2) nr++;
                    if(i==3) nc--;

                    if(check(nr,nc,temp) && !(k==2 && nr==tr && nc == tc)){
                        char old = temp[nr * m + nc];
                        temp[nr * m + nc] = '0';
                        String go = new String(temp);
                        if(!map.containsKey(go)){
                            map.put(go,map.get(curr) + 1);
                            ad.addLast(go);
                        }
                        temp[nr * m + nc] = old;
                    }
                }

            }
			
			System.out.printf("Game #%d: %d%n", tt, out);
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