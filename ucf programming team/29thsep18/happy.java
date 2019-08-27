import java.util.*;
import java.io.*;

class happy{

    static FastReader fs = new FastReader();
    static int k;
    static int []arr;

    static boolean valid(int []arr){
        long val=arr[0];
        for(int i=1;i<k;i++){
            int op = i%4;
            if(op==0){
                if(arr[i]==0) return false;
                if(val%(arr[i]*1L)!=0) return false;
                val = val / (arr[i]*1L);
            } 
            else if(op==1)
                val=val+arr[i];
            else if(op==2)
                val=val-arr[i];
            else if(op==3)
                val=val*arr[i];
        }
        return true;
    } 

    static boolean rec(int pos,int mask,int perm[]){
        if(pos == k){
            return valid(perm);
        }
        for(int i=0;i<k;i++){
            if((mask&(1<<i))==0){
                perm[pos]=arr[i];
                if(rec(pos+1,mask|(1<<i),perm))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int tc =fs.nextInt();
        for(int t=1;t<=tc;t++){
            k = fs.nextInt();
            arr = new int[k];
            for(int i=0;i<k;i++)
                arr[i] = fs.nextInt();
            
            if(rec(0,0,new int[k]))
                System.out.printf("Set %d is a Happy Set =)\n",t);
            else
                System.out.printf("Set %d is a Sad Set =(\n",t);
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