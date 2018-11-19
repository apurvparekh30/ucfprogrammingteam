import java.util.*;
import java.io.*;

class illiteracy {

    static FastReader fs = new FastReader();
    static String s, d;
    static HashMap<String, Boolean> hm = new HashMap<>();
    static ArrayDeque<state> q = new ArrayDeque<state>();
    static char []change;
    static int n;

    static String A(String s,int i){
        char [] ch = s.toCharArray();
        StringBuilder ch = new StringBuilder();
        ch.insert(1,s);
        if(i==0)
            ch[1] = change[ch[1]];
        else if(i==n-1)
            ch[n-2] = change[ch[n-2]];
        else{
            ch[i-1] = change[ch[i-1]];
            ch[i+1] = change[ch[i+1]];
        }
        return new String(ch);
    }
    static String B(String s,int i){
        char [] ch = s.toCharArray();
        if(i!=0 && i!=n-1){
            ch[i+1] = ch[i-1];
        }
        return new String(ch);
    }
    static String C(String s,int i){
        char [] ch = s.toCharArray();
        ch[n-(i+1)] = change[ch[n-(i+1)]];
        return new String(ch);
    }
    static String D(String s,int i){
        char [] ch = s.toCharArray();
        if(Math.abs(i) < Math.abs(n-i)){
            for(int j = i-1;j>=0;j--){
                ch[j] = change[ch[j]];
            }
        }
        else{
            for(int j=i+1;j<n;j++){
                ch[j] = change[ch[j]];
            }
        }
        return new String(ch);
    }
    static String E(String s,int i){
        char [] ch = s.toCharArray();
        int d1 = i;
        int d2 = (n-1) - i;
        if(d1 < d2){
            ch[0] = change[ch[0]];
            ch[i+d1] = change[ch[i+d1]];
        }
        else{
            ch[n-1] = change[ch[n-1]];
            ch[i-d2] = change[ch[(n-1)-d2]];
        }
        return new String(ch);
    }
    static String F(String s,int i){
        char [] ch = s.toCharArray();
        if((i+1)%2==0){
            int no = ((i+1)/2)-1;
            ch[no] = change[ch[no]];
        }
        else{
            int no = (((i+1)+(n+1))/2)-1;
            ch[no] = change[ch[no]];
        }
        return new String(ch);
    }

    static String g(int i, String s) {
        switch (s.charAt(i)) {
        case 'A':
            return A(s,i);
        case 'B':
            return B(s,i);
        case 'C':
            return C(s,i);
        case 'D':
            return D(s,i);
        case 'E':
            return E(s,i);
        case 'F':
            return F(s,i);
        }
        return s;
    }

    public static void main(String[] args) {
        s = fs.next();
        d = fs.next();
        n = s.length();
        change = new char[100];
        change['A'] = 'B';
        change['B'] = 'C';
        change['C'] = 'D';
        change['D'] = 'E';
        change['E'] = 'F';
        change['F'] = 'A';
        q.addLast(new state(s, 0));
        hm.put(s, true);
        int ans = -1;
        int ii=0;
        while (!q.isEmpty()) {
            //if(ii==1) break;
            state curr = q.pollFirst();
            String st = curr.s;
            int c = curr.c;
            if (st.equals(d)) {
                ans = c;
                break;
            }
            for (int i = 0; i < n; i++) {
                String nw = g(i, st);
                //System.out.println(nw + " " + st);
                if (hm.containsKey(nw) == true)
                    continue;
                hm.put(nw, true);
                q.addLast(new state(nw, c + 1));
            }
            ii++;
        }
        System.out.println(ans);
    }

    static class state {
        String s;
        int c;

        state(String s, int c) {
            this.s = s;
            this.c = c;
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