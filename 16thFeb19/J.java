import java.util.*;
import java.io.*;

class J {

    static FastReader fs = new FastReader();
    static String units[];
    static Map<String, ArrayList<unit>> list;
    static Map<String, ArrayList<unit>> ans;
    static Set<String> visited;

    static class unit implements Comparable<unit> {
        String to;
        int val;

        unit(String to, int val) {
            this.to = to;
            this.val = val;
        }

        @Override
        public int compareTo(unit o) {
            return Integer.compare( this.val,o.val);
        }

        @Override
        public String toString() {
            return val+to;
        }
    }

    static void dfs(unit curr, String origin) {
        //System.out.println(curr);
        String s = curr.to;
        int val = curr.val;
        //System.out.println(curr);
        visited.add(s);
        for (unit u : list.get(s)) {
            if (visited.contains(u.to))
                continue;
            unit nu = null;
            if (u.val < 0) {
                if (val / (-u.val) <= 0) {

                    continue;
                } else {
                    nu = new unit(u.to, val / (-u.val));
                }
            } else
                nu = new unit(u.to, val * u.val);
            
            ArrayList<unit> al = ans.get(origin);
            al.add(nu);
            ans.put(origin, al);
            dfs(nu, origin);
        }
    }

    public static void main(String[] args) {
        while (true) {
            int n = fs.nextInt();
            if (n == 0)
                break;
            units = new String[n];
            list = new HashMap<>();
            ans = new HashMap<>();
            for (int i = 0; i < n; i++) {
                units[i] = fs.next();
                list.put(units[i], new ArrayList<unit>());
                ans.put(units[i], new ArrayList<unit>());
            }
            for (int i = 0; i < n - 1; i++) {
                String a = fs.next();
                fs.next();
                int q = fs.nextInt();
                String b = fs.next();

                ArrayList<unit> al = list.get(b);
                al.add(new unit(a, -q));
                list.put(b, al);

                al = list.get(a);
                al.add(new unit(b, q));
                list.put(a, al);
            }

            /* visited = new HashSet<>();
            dfs(new unit("C",1),"C");
            System.out.println(ans.get("C")); */
            for (int i = 0; i < n; i++) {

                visited = new HashSet<>();
                //System.out.println(ans);
                //System.out.println();
                dfs(new unit(units[i], 1), units[i]);
                //System.out.println(ans.get(units[i]));
                if(ans.get(units[i]).size()==n-1){
                    ArrayList<unit> al = ans.get(units[i]);
                    Collections.sort(al);
                    StringBuilder sb = new StringBuilder();
                    sb.append("1").append(units[i]).append(" ");
                    for(unit u:al){
                        sb.append("= ").append(u).append(" ");
                    }
                    System.out.println(sb);
                
                }
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