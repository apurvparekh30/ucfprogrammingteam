// 2015 MCPC: Pyro Tubes
// Michael Goldwasser
#include <iostream>
#include <set>
using namespace std;

#define NUM_TUBES 18

set<int> vals;

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
    while (cin >> lum && lum != -1) {
        vals.insert(lum);
    }
    for (set<int>::iterator it = vals.begin(); it != vals.end(); ++it) {
        cout << *it << ":" << count(*it) << endl;
    }

}
