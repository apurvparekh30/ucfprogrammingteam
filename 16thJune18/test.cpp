int total=0;
    for(int i=0;i<n;){
        if(d){
            int curr = arr[i];
            i++;
            if(curr%10 < 5){
                while(((curr+arr[i])%10)<5 && i<n){
                    curr+=arr[i];
                    i++;
                }
                total+=curr-(curr%10);
                d--;
            }
            else{
                while(((curr+arr[i])%10)>=5 && i<n){
                    curr+=arr[i];
                    i++;
                }
                curr+=arr[i];
                i++;
                total+=curr-(curr%10);
                d--;
            }
        }
        else{
            total+=arr[i];
            i++;
        }
    }
    if(total%10 >= 5){
        total = total + 5;
        total = total - (total%10);
    }
    else{
        total = total - (total%10);
    }
    printf("%d\n",total);