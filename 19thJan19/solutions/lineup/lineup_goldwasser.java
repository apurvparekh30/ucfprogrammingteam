/*  MCPC 2015: Line Them Up
    Java Solution by Michael Goldwasser
*/
import java.util.Scanner;
import java.util.ArrayList;

public class lineup_goldwasser {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        String data[] = new String[N];
        for (int j=0; j < N; j++)
            data[j] = in.next();

        if (data[0].compareTo(data[1]) < 0) {
            for (int j=2; j < N; j++) {
                if (data[j-1].compareTo(data[j]) > 0) {
                    System.out.println("NEITHER");
                    return;
                }
            }
            System.out.println("INCREASING");
        } else {
            for (int j=2; j < N; j++) {
                if (data[j-1].compareTo(data[j]) < 0) {
                    System.out.println("NEITHER");
                    return;
                }
            }
            System.out.println("DECREASING");

        }

    }

}
