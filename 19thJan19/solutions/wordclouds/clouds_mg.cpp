// Word Clouds Revisited, MCPC 2015
// C++ version by Michael Goldwasser

#include <iostream>
using namespace std;

#define MAXN 5000
#define INF MAXN*150

int w[MAXN];
int h[MAXN];
int opt[MAXN+1];

int main() {
    int N,W;
    cin >> N >> W;
    for (int j=0; j < N; j++)
        cin >> w[j] >> h[j];

    opt[N] = 0;   // sentinel base case with no words
    for (int j=N-1; j >= 0; j--) {
        // decide how much should go on line starting with entry j
        int rowH = 0;
        int rowW = 0;
        int best = INF;
        for (int k=j; k < N; k++) {
            rowH = max(rowH, h[k]);
            rowW += w[k];
            if (rowW <= W) {
                // consider breaking row just after k
                best = min(best, rowH + opt[k+1]);
            } else
                break;  // nothing else fits on the line
        }
        opt[j] = best;
    }

    cout << opt[0] << endl;
}
