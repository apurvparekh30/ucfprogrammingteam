import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static gear []g;
    
    static class gear implements Comparable<gear> {
        long f,b;
        gear(long f,long b){
            this.f = f;
            this.b = b;
        }
        @Override
        public int compareTo(gear o) {
            long c = f * o.b;
            long d = o.f * b;
            if(c == d){
                return Long.compare(f,o.f);
            }
            return Long.compare(c, d);
        }
        @Override
        public String toString() {
            return "("+f+","+b+")";
        }
    }
    public static void main(String[] args) {
        int n,m;
        n = fs.nextInt();
        m = fs.nextInt();
        g = new gear[n*m];
        int []a = new int[n];
        int []b = new int[m];
        for(int i=0;i<n;i++)
            a[i] = fs.nextInt();
        for(int i=0;i<m;i++)
            b[i] = fs.nextInt();
        int k = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                g[k++] = new gear(a[i],b[j]);
            }
        }
        Arrays.sort(g);
        for(int i=0;i<g.length;i++){
            System.out.println(g[i]);
        }
    }

}