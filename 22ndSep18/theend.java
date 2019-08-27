import java.util.*;
import java.io.*;

class theend{

    static FastReader fs = new FastReader();
    static String s;

    /* static int done(String ss,char end){
        int i=ss.length()-1;
        while(i>=0 && ss.charAt(i)==end) i--;
        return i;
    } */
    public static int done(String s, char end) {
		int i = s.length();
        while (i>0 && s.charAt(i-1) == end) i--;
        System.out.println("i="+i);
		return i;
	}
    static long rec(String s,char st,char end){
        int value = done(s, end);
		if (value < 2)
            return value;
        char other = (char)(3 - (end - 'A') - (s.charAt(value-1) - 'A') + 'A');
        return rec(s.substring(0,value-1), s.charAt(value-1), other) + (1L << (value-1));
    }

    public static void main(String[] args) {
        while(true){
            s = fs.next();
            if(s.equals("X")) break;
            System.out.println(rec(s,'A','B'));
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