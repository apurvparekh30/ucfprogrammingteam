import java.util.*;
import java.io.*;

class panoptes {

    static FastReader fs = new FastReader();
    static int n, p;
    static double[] arr;

    public static void main(String[] args) {
        n = fs.nextInt();
        p = fs.nextInt();
        arr = new double[n];
        double tmp = 0.0;
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextDouble();
            tmp += arr[i];
        }
        tmp = tmp / (1.0 * n);
        tmp = (4.0 / 5.0) * tmp;
        //System.out.println(tmp);
        //System.out.println(Arrays.toString(arr));
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Double.compare(tmp, arr[i]) > 0)
                idx.add(i);
        }
        //System.out.println(idx);
        if (idx.size() == 0) {
            System.out.println("-1");
            return;
        }
        int ans = -1;
        for (int i = Math.max(Math.max(idx.get(0),1),p); i < n; i++) {
            for (int id : idx) {
                if(id - i >= 0)
                    break;
                int count = 0;
                boolean flag = true;
                for (int j = id;; j = j + i) {
                    
                    if (j >= n) {
                        break;
                    }
                    if (Double.compare(tmp, arr[j]) <= 0) {
                        flag = false;
                        break;
                    }
                    count++;
                    
                }
                if (flag && count > 0) {
                    ans = i;
                    break;
                }
            }
            if(ans!=-1)
                break;
        }
        System.out.println(ans);
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