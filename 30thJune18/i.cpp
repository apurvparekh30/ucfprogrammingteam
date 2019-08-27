#include <bits/stdc++.h>

using namespace std;

int p[5001],r[5001];

int n,k;
int arr[5001];

int ans = 0;

int findSet(int i){
    return (p[i]==i) ? i : (p[i] = findSet(p[i]));
}

bool isSameSet(int i,int j){
    return findSet(i) == findSet(j);
}

int main() {
    scanf("%d %d",&n,&k);
    for(int i=0;i<k;i++){
        scanf("%d",&arr[i]);
    }
    for(int i=1;i<=n;i++){
        p[i] = i;
    }
    for(int i=0;i<n;i++){
        string line;
        scanf("% ");
        getline(cin,line);
        stringstream strm(line);
        int source;
        strm >> source;
        int dest;
        while(strm >> dest){
            if(!isSameSet(source,dest)){
                int x = findSet(source);
                r[x]++;
                if(r[ans] < r[x]) ans = x;
                else{
                    if( r[ans] == r[x])
                        ans = min(ans,x);
                }
            }
        }
    }
    printf("%d\n",ans);
    return 0;
}