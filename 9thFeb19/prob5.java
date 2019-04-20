// sparse matrix multiplcation
// read n 
// serialize and desealized bst
// LRU Cache
// BST iterator
// flattened nested list iterator
// add and search word


import java.util.*;

class prob5 {

    static Scanner fs = new Scanner(System.in);
    static long x;
    
    static String []things = {"","thousand","million","billion","trillion","quadrillion","quintillion"};
    static String []ones = {"","one","two","three","four","five","six","seven","eight","nine"};
    static String []tens = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    static String []twos = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};


    static String HUNDRED = " hundred ";
    static StringBuilder sb = new StringBuilder();
    
    static void small(int x){
        if(x > 99){
            sb.append(ones[x/100]);
            sb.append(HUNDRED);
        }
        x = x % 100;
        if(x >= 20){
            sb.append(tens[x/10] + " " + ones[x%10]+ " ");
        }
        else if(x>=10){
            sb.append(twos[x%10] + " ");
        }
        else if(x!=0) {
            sb.append(ones[x] + " ");
        }
    }

    static void big(long x,int c){
        if(x==0)
            return;
        big(x/1000,c+1);
        small((int)(x%1000));
        if(x%1000 !=0 && c!=0) {
            sb.append(things[c] + " ");
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            x = fs.nextLong();
            sb = new StringBuilder();
            big(x,0);
            System.out.println(sb);
        }
    }
}