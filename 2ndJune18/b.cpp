#include <bits/stdc++.h>

using namespace std;

int arr[26];

int getOdds(){
    int count=0;
    for(int i=0;i<26;i++){
        if(arr[i] % 2 != 0){
            count++;
        }
    }
    return count;
}

int main() {
    string s;
    cin>>s;
    
    for(char c:s){
        arr[c-'a']++;
    }
    int res=getOdds();
    if(res==0){
        printf("0\n");
    }
    else {
        printf("%d\n",res-1);
    }
    
    return 0;
}