#include <bits/stdc++.h>

using namespace std;

int main(){
    int n,d;
    scanf("%d %d",&n,&d);
    int arr[n];
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int total = 0;
    for(int i=n-1;i>=0;){
        if(d){
            int curr=arr[i];
            i--;
            while(((curr+arr[i])%10) < 5 && i>=0){
                curr+=arr[i];
                i--;
            }
            total+= curr -(curr%10);
            d--;
        }
        else{
            total += arr[i];
            i--;
        }
    }
    int q = total/10;
    if(total%10 < 5){
        total = q * 10;
    }
    else{
        total = (q+1) * 10;
    }
    printf("%d\n",total);
    return 0;
}