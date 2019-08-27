#include <bits/stdc++.h>

using namespace std;

int main() {

    unordered_map <string,int> kattis,DOM;
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        char result[20];
        scanf("%s",&result);
        DOM[result]++;
    }
    for(int i=0;i<n;i++){
        char result[20];
        scanf("%s",&result);
        kattis[result]++;
    }
    int count=0;
    for(auto s:kattis){
        count+=min(kattis[s.first],DOM[s.first]);
    }
    printf("%d\n",count);
}