// MCPC 2015: Dance Recital
// Author: Michael Goldwasser
#include <iostream>
#include <set>
#include <algorithm>
using namespace std;

#define MAX_R 10

int cost[MAX_R][MAX_R];
string team[MAX_R];
int perm[MAX_R];

int main() {

    int R;
    cin >> R;
    for (int j=0; j<R; j++) {
        cin >> team[j];
        perm[j] = j;
    }

    // calculate all-pairs costs
    for (int a=0; a < R; a++)
        for (int b=0; b < a; b++) {
            string combined = team[a]+team[b];
            int overlap = combined.size() - set<char>(combined.begin(), combined.end()).size();
            cost[a][b] = cost[b][a] = overlap;
        }

    // determine best permutation
    int best = 27*R;
    do {
        int count=0;
        for (int j=0; j < R-1; j++)
            count += cost[perm[j]][perm[j+1]];
        best = min(best,count);
    } while (next_permutation(perm,perm+R));

    cout << best << endl;
}
