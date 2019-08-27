#include <bits/stdc++.h>

using namespace std;

int N,T;
int total=0;
priority_queue<int> pq[17];

void recur(int curr,int amt){
    if(total<amt){
        total=amt;
    }
    if(curr>=T) return;
    for(int i=curr;i<T;i++){
        if(pq[i].empty()) continue;
        int currAmt=pq[i].top();
        pq[i].pop();
        recur(curr+1,amt+currAmt);
        pq[i].push(currAmt);
    }
}

int main() {
    scanf("%d %d",&N,&T);
    while(N--){
        int a,b;
        scanf("%d %d",&a,&b);
        pq[b].push(a);
    }
    recur(0,0);
    printf("%d\n",total);
    return 0;
}