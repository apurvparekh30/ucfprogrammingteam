import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static double r;
    static int it;
    static final double pi = Math.PI;
    public static void main(String[] args) {
        //System.out.println(pi);
        Random rand = new Random();
        n = rand.nextInt() % 50; //.nextInt();
        while(n-- > 0){
            r = rand.nextDouble();//.nextDouble();
            it = rand.nextInt() % 50;
            System.out.println(it);
            double area = pi * r * r;
            it--;
            if(it > 0){
                r = r / 2.0;
                area = area + (4 * pi * r * r);
                it--;
            }
            int curr = 4;
            while(it-- > 0){
                curr = curr * 3;
                r = r / 2.0;
                area = area + (curr * pi * r * r);
            }
            String ans = new Double(area).toString();
            System.out.println(ans.substring(0,17));
        }
    }
}