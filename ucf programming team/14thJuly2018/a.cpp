// Apurv Parekh
// 14th July 2018

#include <bits/stdc++.h>

using namespace std;

int n,m,p;
int ans;
int main() {
    scanf("%d%d%d",&n,&m,&p);
    ans = (n*(n+1)*m*(m+1))/4;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(2*(i+j) < p){
                int tmp;
                tmp = ((n-i)+1) * ((m-j)+1);
                ans-=tmp;
            }
        }
    }
    printf("%d\n",ans);
    return 0;
}