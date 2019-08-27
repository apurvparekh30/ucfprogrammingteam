#include <bits/stdc++.h>

using namespace std;

int main() {
    int n,k,a,b;
    scanf("%d%d%d%d",&n,&k,&a,&b);
    vector<vector<int>> ls(n+1,vector<int>(n+1,b));
    for(int i=0;i<k;i++){
        int u,v;
        scanf("%d%d",&u,&v);
        ls[u][v] = a;
        ls[v][u] = a;
    }
    int src = 1;
    set<pair<int,int>> setds;
    vector<int> dist(n+1,INT_MAX);
    dist[src] = 0;
    setds.insert(make_pair(0,src));

    while(!setds.empty()){
        pair<int,int> tmp = *(setds.begin());
        setds.erase(setds.begin());
        int u = tmp.second;
        
        for(int i=1;i<n+1;i++){
            int v = i;
            int weight = ls[u][i];
            if(dist[v] > dist[u] + weight){
                if(dist[v]!= INT_MAX){
                    setds.erase(setds.find(make_pair(dist[v],v)));
                }
                dist[v] = dist[u] + weight;
                setds.insert(make_pair(dist[v],v));
            }
        }
    }
    printf("%d\n",dist[n]);
    return 0;
}