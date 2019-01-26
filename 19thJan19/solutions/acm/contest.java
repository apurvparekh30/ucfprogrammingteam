/*  ACM Mid-Central Programming competition 2015 Problem A: Contest
    solution by Andy Harrington
*/

import java.util.*;

class contest {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int[] penalties = new int[26];
      int count = 0, time = 0;
      while (true) {
          int t = in.nextInt();
          if (t < 0 ) break;
          int ip = in.next().charAt(0)-'A';
          if (in.next().equals("right")) {
              time += t + penalties[ip];
              count++;
          }
          else
               penalties[ip] += 20;
      }
      System.out.println(count + " " + time);       
    }
}
