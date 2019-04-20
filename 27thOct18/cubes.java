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
    
    static final int FIRST = 'A', LAST = 'Z';


    static boolean valid(int pos,char ch){
        for(int i=pos-(pos%SIDES);i<pos;i++){
            if(inSame[sol[i]][ch])
                return false;
        }
        return true;
    }

    static void rec(Character []toTry,int pos,int iTry){
       
        if(pos == nch){
            String s = new String(sol);
            for (int i = SIDES; i < nch; i+= SIDES)
                System.out.print(s.substring(i-SIDES, i) + " ");
            System.out.println(s.substring(nch-SIDES));
            return;
        }
        int offset = pos % SIDES;
        if(offset==0){  // new die
            Character [] newTry; 
            if(pos==0){
                newTry = toTry;
            }
            else{
                newTry = new Character[toTry.length-SIDES];
                int sOffs = pos - SIDES, iOffs = 0;
                for (char c: toTry) 
                    if (c == sol[sOffs]) 
                        sOffs++;
                    else 
                        newTry[iOffs++] = c;
            }
            sol[pos] = newTry[0];
            rec(newTry,pos+1,1);
            return;
        }
        if(valid(pos,toTry[iTry])){
            sol[pos] = toTry[iTry];
            rec(toTry,pos+1,iTry+1);
        }
        iTry++;
        if(iTry + SIDES - offset <= toTry.length)
            rec(toTry,pos,iTry);
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
            //System.out.println(Arrays.toString(used) + " " +nDice);
            sol = new char[nch];
            rec(used,0,0);
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
