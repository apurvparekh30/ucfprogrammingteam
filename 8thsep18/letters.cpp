#include <algorithm>
#include <cstdio>
#include <iostream>
#include <string>

using namespace std;

int main(){
    string a,b;
    int tc=0;
    while(1){
        tc++;
        getline(cin,a);
        getline(cin,b);
        if(a=="END" && b=="END") break;
        sort(a.begin(),a.end());
        sort(b.begin(),b.end());
        printf("Case %d: ",tc);
        if(a==b){
            printf("same\n");
        }
        else printf("different\n");
    }
    return 0;
}