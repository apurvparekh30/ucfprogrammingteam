#include <string>
#include <algorithm>
#include <cstdio>
#include <vector>
#include <iostream>
#include <unordered_map>

using namespace std;

bool isEqual(string a,string b){
    sort(a.begin(),a.end());
    sort(b.begin(),b.end());
    return a==b;
}

int main(){
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        int no; scanf("%d",&no);
        string a,b,c,res;
        cin>>a>>b>>res;
        c=a+b;
        printf("%d ",t);
        if(c==res){
            printf("0\n");
            continue;
        }
        int l = c.length();
        vector<char> v(l);
        if(isEqual(c,res)){
            unordered_map<string,bool> mp;
            mp[c]=true;
            int cnt=0;
            while(1){
                cnt++;
                int i=0,j=no;
                int vi=0;
                for(;i<no;i++,j++){
                    v[vi]=c[j]; vi++;
                    v[vi]=c[i]; vi++;
                }
                c = string(v.begin(),v.end());
                if(c==res){
                    printf("%d\n",cnt);
                    break;
                }
                if(mp[c]){
                    printf("-1\n");
                    break;
                }
                mp[c]=true;
            }
        }
        else{
            printf("-1\n");
        }
    }
}