/*  Hidden Password, MCPC 2015
    Java Solution by Michael Goldwasser
*/
import java.util.Scanner;

class hidden_mg {

    // return index of first occurrence of charset within substring of
    // original starting at index pos (or return -1 otherwise)
    static int find_first_of(String original, String charset, int pos) {
        for (int k=pos; k < original.length(); k++) {
            if (charset.indexOf(original.charAt(k)) != -1)
                return k;
        }
        return -1;
    }

    static boolean valid(String password, String message) {
        int pos=0;
        for (int j=0; j < password.length(); j++) {
            pos = find_first_of(message, password.substring(j), pos);

            //--------------- debug code ---------------
            System.err.print("Search for " + password.charAt(j) + " resulted in pos " + pos);
            if (pos == -1)
                System.err.println(" (end of string)");
            else
                System.err.println(" (found " + message.charAt(pos) + ")");
            //------------------------------------------

            if (pos == -1 || message.charAt(pos)!= password.charAt(j))
                return false;
            pos++;  // start search at next location
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((valid(sc.next(),sc.next()) ? "PASS" : "FAIL"));
    }
}
