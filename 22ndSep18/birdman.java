import java.util.*;
import java.io.*;

class birdman{

    static FastReader fs = new FastReader();
    static final double EPS = 1e-9;

    static class point{
        int x,y;
        point(int x,int y){
            this.x=x;
            this.y=y;
        }
        public point getVect(point other){
            return new point(other.x-x,other.y-y); 
        }
        public double dot(point other){
            return x*other.x + y*other.y;
        }
        public double cross(point other){
            return x*other.y-other.x*y;
        }
    }

    static class line{
        point start;
        point dir;
        point end;

        line(point st,point en){
            start = st;
            end = en;
            dir = start.getVect(end);
        }

        boolean intersect(line other,boolean areSegment){
            double den = det(dir.x,-other.dir.x,dir.y,-other.dir.y);
            // parallel or coincidental
            if(den==0){
                point vect = start.getVect(other.start);
                if(vect.cross(dir)!=0) return false;
                double lambda1 = getLambda(other.start);
                double lambda2 = getLambda(other.end);
                return !((lambda1 > 1 && lambda2 > 1) || (lambda1 < 0 && lambda2 < 0));
            }
            if(areSegment){
                double num1 = det(other.start.x-start.x,-other.dir.x,other.start.y-start.y,-other.dir.y);
                double num2 = det(dir.x,other.start.x-start.x,dir.y,other.start.y-start.y);
                return -EPS<=(num1/den) && (num1/den)<=(1+EPS) && -EPS<=(num2/den) && (num2/den)<=(1+EPS);
            }
            return true;
        }

        static double det(double a,double b,double c,double d){
            return a*d-c*b;
        }
        public double getLambda(point dest) {

            // Make sure we don't divide by 0.
            if (dir.x != 0)
                return 1.0*(dest.x - start.x)/dir.x;
            // Use only if dx is 0...we assume no directional vector is 0.
            else
                return 1.0*(dest.y - start.y)/dir.y;
        }
    }

    public static void main(String[] args) {
        int n = fs.nextInt();
        while(n-- > 0){
            int x1,y1,x2,y2;
            x1 = fs.nextInt();
            y1 = fs.nextInt();
            x2 = fs.nextInt();
            y2 = fs.nextInt();
            line l1 = new line(new point(x1,y1),new point(x2,y2));
            x1 = fs.nextInt();
            y1 = fs.nextInt();
            x2 = fs.nextInt();
            y2 = fs.nextInt();
            line l2 = new line(new point(x1,y1),new point(x2,y2));

            if(l1.intersect(l2, true))
                System.out.println("Move to the left or right!");
            else    
                System.out.println("Good picture, Birdman!");
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