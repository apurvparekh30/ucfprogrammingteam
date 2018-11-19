import java.util.*;
import java.io.*;

class illiteracy {

    static FastReader fs = new FastReader();
    static String s, d;
    static HashMap<String, Boolean> hm = new HashMap<>();
    static ArrayDeque<state> q = new ArrayDeque<state>();
    static char[] change;
    static int n;

    static char[] copy(String s) {
        char[] ch = new char[n + 1];
        for (int i = 1; i <= n; i++)
            ch[i] = s.charAt(i - 1);
        return ch;
    }

    static String A(String s, int i) {
        char[] ch = copy(s);
        if (i == 1)
            ch[i + 1] = change[ch[i + 1]];
        else if (i == n)
            ch[n - 1] = change[ch[n - 1]];
        else {
            ch[i - 1] = change[ch[i - 1]];
            ch[i + 1] = change[ch[i + 1]];
        }
        return new String(ch, 1, n);
    }

    static String B(String s, int i) {
        char[] ch = copy(s);
        if (i != 1 && i != n) {
            ch[i + 1] = ch[i - 1];
        }
        return new String(ch, 1, n);
    }

    static String C(String s, int i) {
        char[] ch = copy(s);
        int nn = n + 1;
        ch[nn - i] = change[ch[nn - i]];
        return new String(ch, 1, n);
    }

    static String D(String s, int i) {
        char[] ch = copy(s);
        int d1 = i - 1;
        int d2 = n - i;
        if (d1 < d2) {
            for (int j = i - 1; j >= 1; j--) {
                ch[j] = change[ch[j]];
            }
        } else {
            for (int j = i + 1; j <= n; j++) {
                ch[j] = change[ch[j]];
            }
        }
        return new String(ch, 1, n);
    }

    static String E(String s, int i) {
        
        char[] ch = copy(s);
        if (i != 1 && i != 8) {
            int d1 = i - 1;
            int d2 = n - i;
            if (d1 < d2) {
                ch[i-d1] = change[ch[i-d1]];
                ch[i + d1] = change[ch[i + d1]];
            } else {
                ch[i+d2] = change[ch[i+d2]];
                ch[i - d2] = change[ch[i - d2]];
            }
        }
        return new String(ch, 1, n);
    }

    static String F(String s, int i) {
        char[] ch = copy(s);
        int nn = n + 1;
        if (i % 2 == 0) {
            int no = i / 2;
            ch[no] = change[ch[no]];
        } else {
            int no = (i + nn) / 2;
            ch[no] = change[ch[no]];
        }
        return new String(ch, 1, n);
    }

    static String g(int i, String s) {
        switch (s.charAt(i)) {
        case 'A':
            return A(s, i + 1);
        case 'B':
            return B(s, i + 1);
        case 'C':
            return C(s, i + 1);
        case 'D':
            return D(s, i + 1);
        case 'E':
            return E(s, i + 1);
        case 'F':
            return F(s, i + 1);
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
        int ii = 0;
        while (!q.isEmpty()) {
            // if(ii==1) break;
            state curr = q.pollFirst();
            String st = curr.s;
            int c = curr.c;
            if (st.equals(d)) {
                ans = c;
                break;
            }
            for (int i = 0; i < n; i++) {
                String nw = g(i, st);
                //System.out.println(st + " " + nw);
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