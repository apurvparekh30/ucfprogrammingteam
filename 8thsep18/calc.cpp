#include <algorithm>
#include <cstdio>
#include <queue>
#include <unordered_map>

using namespace std;

const int maxx = 1e9;

struct st{
    int v,ct;
    st(){}
    st(int v,int ct):v(v),ct(ct){}
};

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        int no;
        scanf("%d",&no);
        int mx = -1;
        for(int i=1;i<100;i++){
            if(i==no) continue;
            int src = no;
            queue<st> q;
            bool vis[1000001];
            fill(vis,vis+1000001,false);
            vis[src]=true;
            q.push(st(src,0));
            int steps;
            while(!q.empty()){
                st curr=q.front();
                q.pop();
                int u=curr.v;
                int ct = curr.ct;
                if(u == i){
                    steps = ct;
                    break;
                }  
                if(u+1 < 1e6){
                    if(!vis[u+1]){
                        q.push(st(u+1,ct+1));
                    }
                } 
                if(u*3 < 1e6){
                    if(!vis[u*3]){
                        q.push(st(u*3,ct+1));
                    }
                }
                if(u/2 > 0){
                    if(!vis[u/2]){
                        q.push(st(u/2,ct+1));
                    }
                }
            }
            mx = max(mx,steps);
        }
        printf("%d\n",mx);
    }
    return 0;
}