import java.util.*;
import java.io.*;

class i {
    static Scanner fs = new Scanner(System.in);
    static int n;
    public static void main(String[] args) {
        n = fs.nextInt();
        long a =(long) Math.pow(4,n);
        long b =(long) Math.pow(2,n);
        System.out.println(a*b);
    }
}