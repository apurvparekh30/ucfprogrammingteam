// MCPC'15: Kitchen Measurements
// Author: Michael Goldwasser
#include <iostream>
#include <queue>
#include <map>
#include <sstream>
using namespace std;

//#define ACCOUNT   // use only for debugging
//#define VERBOSE // use only for debugging

#ifdef ACCOUNT
int pushes(1),pops(0);
#endif

#define MAXN 5
#define MAXV 64

typedef unsigned long long ULL;

const ULL MASK = ((1ULL<<7)-1);  // 2^7 - 1

struct Move {
    int cost;
    ULL result;
    bool operator<(const Move& other) const {
        return (cost > other.cost);  // INTENTIONALLY INVERTED FOR MAX HEAP
    }
};

map<ULL,ULL> cost;   // cost[state] represents min quantity of water to reach state

int cap[MAXN];  // capacities of jars
int N,V;

// return volume of jar j for given state
int volume(ULL state, int j) {
    return (state >> (7*j)) & MASK;
}

// return new state that results when setting
// volume of jar j to v.
ULL setVolume(ULL state, int j, int v) {
    ULL temp = MASK << (7*j);
    return (state ^ (state & temp) ^ (ULL(v) << (7*j)));
}

bool isGoal(ULL state) {
    return (volume(state, 0) == V);
}

// for debug only
string dump(ULL state) {
    stringstream ss;

//     for (int j=N-1; j >= 0; j--) {
//         for (int k=6; k >= 0; k--) {
//             ss << ((state & (1ULL<<(7*j+k))) ? 1 : 0);
//         }
//         ss << " ";
//     }

    for (int j=0; j < N; j++) {
        if (j != 0) ss << ",";
        ss << volume(state, j);
    }
    return ss.str();
}

vector<Move> neighbors(ULL state) {
    vector<Move> results;
    for (int j=0; j<N; j++)
        for (int k=0; k<N; k++) {
            if (j != k) {
                // consider pouring from j to k
                int vj = volume(state,j);
                int vk = volume(state,k);
                int quantity = min(vj, cap[k] - vk);
                if (quantity > 0) {
                    Move temp;
                    temp.cost = quantity;

                    /*
                    cout << j << "->" << k << " " << quantity << endl;
                    cout << dump(state) << endl;
                    cout << dump(setVolume(state,j,vj-quantity)) << endl;
                    cout << dump(setVolume(setVolume(state,j,vj-quantity), k, vk+quantity)) << endl;
                    */

                    temp.result = setVolume(setVolume(state, j, vj-quantity), k, vk+quantity);
                    results.push_back(temp);
                }
            }
        }
    return results;
}

int solve() {
    priority_queue<Move> fringe;
    Move initial = {0, cap[0]};  // first jar full; rest are empty
    fringe.push(initial);
    while (!fringe.empty()) {
        Move next = fringe.top();
        fringe.pop();
#ifdef ACCOUNT
    pops++;
#endif
        if (isGoal(next.result))
            return next.cost;
        if (cost.find(next.result) == cost.end()) {  // this is new
#ifdef VERBOSE
            cerr << "With cost " << next.cost << " can reach state " << dump(next.result) << endl;
#endif

            cost[next.result] = next.cost;
            vector<Move> nbrs = neighbors(next.result);
            for (int j=0; j < nbrs.size(); j++) {
                if (cost.find(nbrs[j].result) == cost.end()) {  // not already solved case
                    nbrs[j].cost += next.cost;
                    fringe.push(nbrs[j]);
#ifdef ACCOUNT
                    pushes++;
#endif
                }
            }
        }
    }
    return -1;
}

int main() {
    cin >> N;
    for (int j=0; j < N; j++)
        cin >> cap[j];
    cin >> V;

    int best = solve();
    if (best == -1)
        cout << "impossible" << endl;
    else
        cout << best << endl;

#ifdef ACCOUNT
    cerr << "Total of " << pushes << " pushes and " << pops << " pops" << endl;
#endif
}
