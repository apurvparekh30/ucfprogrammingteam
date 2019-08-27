#include <algorithm>
#include <cstdio>
#include <unordered_map>

using namespace std;

const int maxx = 1e9;

int c;
int st[31];
unordered_map <int,bool> memo[31];

int change(int idx,int curr){
    if(curr == 0) return true;
    if(curr < 0) return false;
    if(idx>=c) return false;
    if(memo[idx][curr]) return memo[idx][curr];
    return (memo[idx][curr] = (change(idx+1,curr-st[idx]) | change(idx+1,curr)));
}

int main() {
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        for(int i=0;i<31;i++) memo[i].clear();
        scanf("%d",&c);
        int sum = 0;
        for(int i=0;i<c;i++){
            scanf("%d",&st[i]);
            sum+=st[i];
        }
        int ans = -1;
        for(int i=1;i<=sum;i++){
            if(!change(0,i)){
                ans=i;
                break;
            }
        }
        printf("Set #%d: ",t);
        if(ans==-1)
            printf("%d\n\n",sum+1);
        else    
            printf("%d\n\n",ans);

    }
    return 0;
}