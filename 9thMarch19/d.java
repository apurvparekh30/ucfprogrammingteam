import java.util.*;
import java.math.BigInteger;


class d {

    static Scanner fs = new Scanner(System.in);
    static BigInteger [][]mat = new BigInteger[2][2];
    static BigInteger [][]zero = {{new BigInteger("1"),new BigInteger("0")},{new BigInteger("-1"),new BigInteger("1")}};
    static BigInteger [][]one =  {{new BigInteger("1"),new BigInteger("-1")},{new BigInteger("0"),new BigInteger("1")}};

    static void multiply(BigInteger [][]a,BigInteger [][]b){
        a[0][0] = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
        a[0][1] = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
        a[1][0] = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));
        a[1][1] = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));
    }
    public static void main(String[] args) {
        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
                mat[i][j] = new BigInteger(fs.next());
        StringBuilder sb = new StringBuilder();
        while(true){
            if(mat[0][0].equals(BigInteger.valueOf(1)) && mat[0][1].equals(BigInteger.valueOf(0)) && mat[1][0].equals(BigInteger.valueOf(0)) && mat[1][1].equals(BigInteger.valueOf(1)))
                break;
            BigInteger [][]a = new BigInteger [2][2];
            for(int i=0;i<2;i++){
                a[i] = Arrays.copyOf(mat[i],mat[i].length);
            }
            multiply(a,zero);
            boolean flag = true;
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    if(a[i][j].compareTo(new BigInteger("0")) < 0){
                        flag = false;
                        break;
                    } 
                }
            }
            if(flag){
                sb.append(0);
                mat = a;
            }
            else {
                sb.append(1);
                multiply(mat,one);
            }
            //System.out.println(Arrays.toString(mat[0]) + "\n" + Arrays.toString(mat[1]));
            //System.out.println();
            
        }
        System.out.println(sb.reverse());
    }
}