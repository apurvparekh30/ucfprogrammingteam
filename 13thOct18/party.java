import java.util.*;
import java.io.*;

class party {

    static FastReader fs = new FastReader();
    static int rules;
    static char mat[][];
    static ArrayDeque<Character> m, w;
    static boolean added[];
    static Character[] mn, wn;
    static int memo[][];

    static int permute(int msk, int wsk) {
        if (Integer.bitCount(msk) == mn.length || Integer.bitCount(wsk) == wn.length)
            return 0;
        if (memo[msk][wsk] != -1)
            return memo[msk][wsk];
        int score = 0;
        for (int i = 0; i < mn.length; i++) {
            if ((msk & (1 << i)) != 0)
                continue;
            for (int j = 0; j < wn.length; j++) {
                if ((wsk & (1 << j)) != 0)
                    continue;
                int tmp=0;
                if (mat[wn[j]][mn[i]] == 'L' && mat[mn[i]][wn[j]] == 'L')
                    tmp = 4;
                else if ((mat[wn[j]][mn[i]] == 'L' || mat[wn[j]][mn[i]] == 'T')
                        && (mat[mn[i]][wn[j]] == 'L' || mat[mn[i]][wn[j]] == 'T'))
                    tmp = 3;
                else if (mat[wn[j]][mn[i]] == 'L' || mat[wn[j]][mn[i]] == 'T')
                    tmp = 2;
                else if (mat[mn[i]][wn[j]] == 'L' || mat[mn[i]][wn[j]] == 'T')
                    tmp = 1;
                score = Math.max(score,
                        permute(msk | (1 << i), wsk | (1 << j)) + tmp);
            }
        }
        return memo[msk][wsk] = score;
    }

    public static void main(String[] args) {
        int tc = 0;
        while (true) {
            tc++;
            rules = fs.nextInt();
            if (rules == 0)
                break;
            char[] rule = new char[3];
            m = new ArrayDeque<>();
            w = new ArrayDeque<>();
            added = new boolean[150];
            mat = new char[150][150];
            memo = new int[1 << 10][1 << 10];
            for (int i = 0; i < (1 << 10); i++)
                Arrays.fill(memo[i], -1);
            for (int i = 0; i < rules; i++) {
                rule = fs.next().toCharArray();
                mat[rule[0]][rule[2]] = rule[1];
                if (!added[rule[0]]) {
                    if (Character.isUpperCase(rule[0]))
                        w.add(rule[0]);
                    else
                        m.add(rule[0]);
                    added[rule[0]] = true;
                }
                if (!added[rule[2]]) {
                    if (Character.isUpperCase(rule[2]))
                        w.add(rule[2]);
                    else
                        m.add(rule[2]);
                    added[rule[2]] = true;
                }
            }
            mn = m.toArray(new Character[m.size()]);
            wn = w.toArray(new Character[w.size()]);

            System.out.printf("Party %d has a maximum happiness quotient of %d\n", tc, permute(0, 0));

            // System.out.println(Arrays.toString(mn));
            // System.out.println(Arrays.toString(wn));
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