// Word Clouds Revisited, MCPC 2015
// Java version by Michael Goldwasser

import java.util.Scanner;

public class clouds_mg {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAXN=5000;
        final int INF=MAXN*150;

        int w[] = new int[MAXN];
        int h[] = new int[MAXN];
        int opt[] = new int[MAXN+1];

        int N,W;
        N = sc.nextInt();
        W = sc.nextInt();

        for (int j=0; j < N; j++) {
            w[j] = sc.nextInt();
            h[j] = sc.nextInt();
        }

        opt[N] = 0;   // sentinel base case with no words
        for (int j=N-1; j >= 0; j--) {
            // decide how much should go on line starting with entry j
            int rowH = 0;
            int rowW = 0;
            int best = INF;
            for (int k=j; k < N; k++) {
                rowH = Math.max(rowH, h[k]);
                rowW += w[k];
                if (rowW <= W) {
                    // consider breaking row just after k
                    best = Math.min(best, rowH + opt[k+1]);
                } else
                    break;  // nothing else fits on the line
            }
            opt[j] = best;
        }

        System.out.println(opt[0]);
    }
}
