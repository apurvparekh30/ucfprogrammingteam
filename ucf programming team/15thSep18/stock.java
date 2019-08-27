import java.util.*;
import java.io.*;

class stock{

    static FastReader fs = new FastReader();
    static int days;
    static double tCost,money;
    static double [][]st;

    static double bk(int currDay,double currAmt,int qt,int num){
        if(currDay == days-1){
            if(qt>0){
                currAmt = currAmt + (st[num][currDay] * qt) - tCost;
            }
            return currAmt;
        }
        double ans = -1;
        ans = Math.max(ans,bk(currDay+1, currAmt, qt, num));
        if(qt == 0){    
            for(int i=0;i<2;i++){
                int newQt = (int) ((currAmt-tCost)/st[i][currDay]);
                ans = Math.max(ans,bk(currDay+1, currAmt-(newQt*st[i][currDay])-tCost, newQt, i));
            }
        }
        else{
            currAmt+=(qt*st[num][currDay])-tCost;
            ans = Math.max(ans,bk(currDay+1, currAmt, 0, num));
            int nqt = (int) ((currAmt-tCost)/st[1-num][currDay]);
            ans = Math.max(ans,bk(currDay+1, currAmt-(nqt*st[1-num][currDay])-tCost, nqt, 1-num));
        }
        return ans;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            days = fs.nextInt();
            tCost = fs.nextDouble();
            money = fs.nextDouble();

            st = new double[2][days];

            for(int i=0;i<2;i++)
                for(int j=0;j<days;j++)
                    st[i][j]=fs.nextDouble();

            System.out.printf("%.2f\n",bk(0,money,0,0));

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