import java.util.*;
import java.io.*;

class prob13 {

    static FastReader fs = new FastReader();
    static HashMap<String, ArrayList<String>> hm;
    static HashMap<String, Integer> sale;
    static int n;
    static HashMap<String, Boolean> v;

    static int dfs(String e) {
        v.put(e, true);
        int ans = sale.get(e);
        //System.out.println(hm.get(e));
        for (String s : hm.get(e)) {
            if (v.containsKey(s) && v.get(s))
                continue;
            ans += dfs(s);
        }
        return ans;
    }

    public static void main(String[] args) {
        int cases = fs.nextInt();
        for (int tt = 1; tt <= cases; tt++) {
            System.out.println("COMPANY " + tt);
            hm = new HashMap<>();
            hm.put("ROOT",new ArrayList<String>());
            sale = new HashMap<>();
            n = fs.nextInt();
            for (int i = 0; i < n; i++) {
                String command = fs.next();
                if (command.equals("ADD")) {
                    String spon = fs.next();
                    String emp = fs.next();
                    sale.put(emp, 0);
                    hm.put(emp, new ArrayList<>());
                    ArrayList<String> al = hm.get(spon);
                    al.add(emp);
                    hm.put(spon, al);
                } else if (command.equals("SALE")) {
                    String emp = fs.next();
                    sale.put(emp, sale.get(emp) + fs.nextInt());
                } else {
                    String emp = fs.next();
                    v = new HashMap<>();
                    System.out.println(dfs(emp));
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