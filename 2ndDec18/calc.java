import java.util.*;
import java.io.*;

class calc {

    static FastReader fs = new FastReader();
    static int sh, sm, dh, dm;
    static StringBuilder[] sb;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for (int tt = 1; tt <= tc; tt++) {
            sh = fs.nextInt();
            sm = fs.nextInt();
            dh = fs.nextInt();
            dm = fs.nextInt();
            int cnt = 1+((sm + (dh * 60) + dm)/60); 
            sb = new StringBuilder[cnt];
            for (int i = 0; i <cnt; i++) {
                sb[i] = new StringBuilder();
            }
            String s1 = new String("------+---------");
            String s2 = new String(" time | elapsed ");
            String s3 = new String("------+---------");
            int curr = sh;
            for (int i = 0; i <cnt; i++) {
                int tmp = curr;
                if (curr > 12) {
                    curr = curr % 12;
                }
                if (curr < 10) {
                    sb[i].append(" ");
                }
                sb[i].append(curr);
                sb[i].append(":XX | XX ");
                int a = (tmp - sh) * 60 - sm;
                String st = new Integer(a).toString();
                //System.out.println(st);
                if (st.charAt(0) == '-') {
                    sb[i].append("- ");
                    sb[i].append(st.substring(1));
                } else {
                    if(st.charAt(0)>'0'){
                        sb[i].append("+ ");
                        sb[i].append(st.substring(0));
                    }
                }
                
                for (int j = 16 - sb[i].length(); j >= 0; j--) {
                    sb[i].append(" ");
                }
                curr = tmp + 1;
                //System.out.println(curr);
            }
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            for (int i = 0; i <cnt; i++) {
                System.out.println(sb[i].toString());
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