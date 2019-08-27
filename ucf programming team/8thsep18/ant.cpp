#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

struct edge{
    int a,b,ct;
    edge(){}
    edge(int a,int b,int ct):a(a),b(b),ct(ct){}
    bool operator <(const edge& e) const {
        return this->ct<e.ct;
    }
};

int pr[101];
int rnk[101];
vector<edge> vt;
int comp;

int find(int p){
    return pr[p]==p ? p:(pr[p]=find(pr[p]));
}

int main(){
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        for(int i=0;i<101;i++) pr[i]=i;
        fill(rnk,rnk+101,0);
        vt.clear();
        int n,m;
        scanf("%d%d",&n,&m);
        comp=n;
        for(int i=0;i<m;i++){
            int u,v,ct;
            scanf("%d%d%d",&u,&v,&ct);
            vt.push_back(edge(u,v,ct));
        }
        sort(vt.begin(),vt.end());
        int cost = 0;
        for(int i=0;i<m;i++){
            int u=vt[i].a;
            int v=vt[i].b;
            int ct=vt[i].ct;
            int x = find(u);
            int y = find(v);

            if(x!=y){
                if(rnk[x]>rnk[y]) pr[y]=x;
                else{
                    pr[x]=y;
                    if(rnk[x]==rnk[y]) rnk[y]++;
                }
                cost+=ct;
                comp--;
            }
        }
        printf("Campus #%d: ",t);
        if(comp!=1){
            printf("I'm a programmer, not a miracle worker!\n");
        }
        else 
            printf("%d\n",cost);
    }
}