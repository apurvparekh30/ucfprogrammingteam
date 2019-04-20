// MCPC'15: Kitchen Measurements
// Author: Per Austrin
#include <iostream>
#include <vector>
#include <set>
#include <map>
#include <algorithm>
using namespace std;
typedef vector<int> vi;

int main(void) {
    int n, goal;
    cin >> n;
    vi C(n), init(n);
    C.resize(n);
    for (int i = 0; i < n; ++i) cin >> C[i];
    cin >> goal;
    init[0] = C[0];

    map<vi, int> dist;
    set<pair<int, vi> > q;
    dist[init] = 1;
    q.insert(make_pair(1, init));
    int vis = 0, solved = false;
    while (!q.empty()) {
        vi S = q.begin()->second;
        int d = q.begin()->first;
        if (S[0] == goal) {
            cout << d-1 << endl;
            return 0;
        }
        q.erase(q.begin());
        for (int i = 0; i < n; ++i)
            if (S[i] > 0)
                for (int j = 0; j < n; ++j) {
                    if (j == i) continue;
                    int v = min(S[i], C[j]-S[j]);
                    if (v > 0) {
                        S[i] -= v; S[j] += v;
                        int nd = d + v, &od = dist[S];
                        if (nd < od || !od) {
                            if (od) q.erase(make_pair(od, S));
                            q.insert(make_pair(nd, S));
                            od = nd;
                        }
                        S[i] += v; S[j] -= v;
                    }
                }

    }
    cout << "impossible" << endl;
}
