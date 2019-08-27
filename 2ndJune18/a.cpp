#include <bits/stdc++.h>

using namespace std;

vector<string> v;

string solve(string s){
    for(auto str:v){
        if(s.length() > str.length()) continue;
        int pos=-1;
        bool flag=true;
        string temp = str;
        for(auto c:s){
            c = tolower(c);
            temp=temp.substr(pos+1);
            pos=temp.find(c);
            if(pos==-1){
                flag=false;
                break;
            }
        }
        if(flag) return str;
    }
    return "No valid word";
}

int main() {
    int N,M;
    scanf("%d %d",&N,&M);
    while(N--){
        string s;
        cin>>s;

        v.push_back(s);
    }
    while(M--){
        string s;
        cin>>s;
        cout<<solve(s)<<'\n';
    }
    return 0;
}