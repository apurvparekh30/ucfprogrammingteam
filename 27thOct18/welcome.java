import java.util.*;
import java.io.*;

class welcome {

    static FastReader fs = new FastReader();
    static HashMap<Character,HashSet<Character>> hm;
    static int n;


    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n==0)
                break;

            hm = new HashMap<Character,HashSet<Character>>();
            for(int i=0;i<n;i++){
                char first = fs.next().charAt(0);
                char last = fs.next().charAt(0);
                if(!hm.containsKey(last))
                    hm.put(last, new HashSet<Character>());
                hm.get(last).add(first);
            }
            Character[] allLast = hm.keySet().toArray(new Character[0]);
            //System.out.println(Arrays.toString(allLast));
            int nLast = allLast.length;
            int nSet = (1<<nLast);
            int min = nLast;
            int groups = 0;
            for(int mask=0;mask<nSet;mask++){
                HashSet<Character> firsts = new HashSet<Character>();
                groups = 0;
                for(int i=0;i<nLast;i++){
                    if((mask&(1<<i))==0)
                        firsts.addAll(hm.get(allLast[i]));
                    else
                        groups++;
                }
                groups += firsts.size();
                if(min > groups)
                    min = groups;
            }
            System.out.println(min);
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
