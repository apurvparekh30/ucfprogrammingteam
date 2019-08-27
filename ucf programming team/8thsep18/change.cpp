#include <algorithm>
#include <cstdio>
#include <unordered_map>
#include <cmath>

using namespace std;

const int maxx = 1e9;

int c;
int st[31];
unordered_map <int,int> memo;

int main() {
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
         memo.clear();
        scanf("%d",&c);
        int sum = 0;
        for(int i=0;i<c;i++){
            int no;
            sum+=no;
            if(no==1){
                memo[1]++;
                continue;
            }
            while(no%2==0){
                memo[2]++;
                no=no/2;
            }
            for(int k=3;k<=sqrt(no);k+=2){
                while(no%k==0){
                    memo[k]++;
                    no=no/i;
                }
            }
        }
        int ans = -1;
        if(memo[1]==0) ans=1;
        else{
            for(int i=2;i<=sum;i++){
               while(i%2==0){
                   if(memo[2]==0){
                       ans = 2;
                       i=i/2;
                       break;
                   }
               }

                for(int r=3;r<=sqrt(i) && ans==-1;r+=2){
                    while(i%r==0){
                        if(memo[r]==0){
                            ans=i;
                            break;
                        }
                    }
                }
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