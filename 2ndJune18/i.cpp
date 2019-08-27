#include <bits/stdc++.h>
using namespace std;

int main() {
    
    string str;
    getline(cin,str);
    getline(cin,str);
    int n=stoi(str);
    vector<string> s[n];
    int i=0;
    while(n--){
        getline(cin,str);
        string word;
        stringstream line(str);
        while(getline(line,word,',')){
            s[i].push_back(word);
        }
        i++;
    }
    printf("\n");
    int mask=0;
    int minOp=INT_MAX;

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i==j) continue;
            
        }
    }

    return 0;
}