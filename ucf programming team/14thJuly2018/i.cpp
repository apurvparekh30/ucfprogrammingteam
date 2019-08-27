// Apurv Parekh
// 14th July 2018

#include <bits/stdc++.h>

using namespace std;

const int maxx = 1e5;

int n,w;
int t[16],wt[16];
int totalTime ,mask;
int prevCount,groupTime;

void backtrack(int i,int gwt,int tm,int count,int msk){
   
    if(mask&(1<<i)) return;
    if(w<gwt) return;
    if(prevCount < count){
        groupTime = tm;
        mask=msk;
        prevCount = count;
    }
    else if(count == prevCount){
        if(tm < groupTime){
            groupTime = tm;
            mask = msk;
        }
    }
    if(i==n) return;
    backtrack(i+1,gwt+wt[i],max(tm,t[i]),count+1,msk|(1<<i));
    backtrack(i+1,gwt,tm,count,msk);
}

int main() {
    scanf("%d%d",&w,&n);
    for(int i=0;i<n;i++){
        scanf("%d%d",&t[i],&wt[i]);
    }
    totalTime = 0;
    mask = 0;
    for(int i=0;i<n;i++){
        if(mask&(1<<i)) continue;
        prevCount = 0;
        groupTime = 0;
        backtrack(i,0,0,0,mask);
        totalTime = totalTime + groupTime;
    }
    printf("%d\n",totalTime);
    return 0;
}