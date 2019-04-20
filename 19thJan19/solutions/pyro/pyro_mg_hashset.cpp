// 2015 MCPC: Pyro Tubes
// Michael Goldwasser
#include <iostream>
#include <unordered_set>
using namespace std;

#define NUM_TUBES 18
#define MAX_N 1 << NUM_TUBES
int orig[MAX_N];
unordered_set<int> vals;

int count(int j) {
    int total=0;
    for (int b = 0; b < NUM_TUBES; b++) {
        for (int a = 0; a <= b; a++) {
            int other = j ^ (1<<b);
            if (a != b)
                other ^= (1<<a);
            if (other > j && vals.find(other) != vals.end())
                total++;
        }        
    }
    return total;
}

int main() {
    int lum;
    int N=0;
    while (cin >> lum && lum != -1) {
      orig[N++] = lum;
      vals.insert(lum);
    }
    for (int k=0; k < N; k++) {
        cout << orig[k] << ":" << count(orig[k]) << endl;
    }

}
