import java.util.*;
import java.io.*;

class cubes {

    static FastReader fs = new FastReader();

    static int n;
    static String[] words;
    static char[] sol;
    static TreeSet<Character> hs;
    static char unused;
    static Character[] used;

    static int nDice;
    static final int SIDES = 6;
    static int nch;
    static boolean inSame[][];

    static int nmask;
    
    static final int FIRST = 'A', LAST = 'Z';


    static boolean valid(ArrayList<Character> al){
        for(int i=0;i<al.size();i++){
            char a = al.get(i);
            for(int j=i+1;j<al.size();j++){
                char b = al.get(j);
                if(inSame[a][b] || inSame[b][a])
                    return false;
            }
        }
        return true;
    }

    static ArrayList<Character> getList(int mask){
        ArrayList<Character> al = new ArrayList<Character>();
        for(int i=0;i<nch;i++){
            if((mask & (1<<i))!=0){
                al.add(used[i]);
            }
        }
        return al;
    }


    static boolean rec(int currMask,int pos,ArrayList<Character> ans){
        if(currMask == 0){
            /// print
            for(char c:ans){
                System.out.print(c);
            }
            System.out.println();
            return true;
        }
        for(int mask = 1;mask<=currMask;mask++){
            int bits = Integer.bitCount(mask);
            if(bits!=SIDES || (mask|currMask)!=currMask)
                continue;
            ArrayList<Character> lst = getList(mask);
            //System.out.println(lst);
            if(valid(lst)){
                //System.out.println(ans.toString());
                ans.addAll(pos, lst);

                if(rec(currMask-mask,pos+SIDES,ans)){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        while (true) {
            n = fs.nextInt();
            if (n == 0)
                break;
            unused = fs.next().charAt(0);
            words = new String[n];
            hs = new TreeSet<Character>();
            inSame = new boolean[LAST+1][LAST+1];
            for(int i=0;i<n;i++){
                words[i] = fs.next();
            }
            nDice = words[0].length();
            for(int i=0;i<n;i++){
                for(int j=0;j<nDice-1;j++){
                    char ch1 = words[i].charAt(j);
                    hs.add(ch1);
                    for(int k=j+1;k<nDice;k++){
                        char ch2 = words[i].charAt(k);
                        hs.add(ch2);
                        inSame[ch1][ch2] = inSame[ch2][ch1] = true;
                    }
                }
            }
            if(unused != '-')
                hs.add(unused);
            nch = hs.size();
            used = hs.toArray(new Character[0]);
            System.out.println(used.length);
            nmask = (1<<nch)-1;
            rec(nmask,0,new ArrayList<Character>());
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
