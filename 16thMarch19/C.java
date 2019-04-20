import java.util.*;

class Solution {

    static Scanner fs = new  Scanner(System.in);
    static Set<Long> set;
    static char []input;

    static boolean process(String s){
        boolean flag = true;
        while(flag){
            flag = false;
            String temp = "";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='*'){
                    flag = true;
                    temp = s.substring(0,i);
                    temp = temp + s.charAt(i+1);
                    temp = temp + s.substring(i+2, s.length());
                    s = temp;
                    break;
                }
            }
        }
        long sum = 0;
        for(int i=0;i<s.length();){
            if(Character.isDigit(s.charAt(i))){
                int curr = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    curr = curr * 10 + (s.charAt(i) - '0');
                    i++;
                }
                sum = sum + curr;
            }
            else {
                i++;
            }
            
        }
        if(set.contains(sum)){
            return true;
        }
        set.add(sum);
        return false;
    }

    static int rec(int i,String exp){
        //System.out.println(exp);
        if(i >= input.length){
            if(process(exp)){
                return 0;
            }
            return 1;
        }
        int count = 0;
        if(Character.isDigit(input[i])){
            while(i < input.length && Character.isDigit(input[i])){
                exp+=input[i];
                i++;
            }
            if(i < input.length){
                count += rec(i+1,exp + "+");
                count += rec(i+1,exp + "*");
            }
            else {
                count += rec(i+1,exp);
                count += rec(i+1,exp);
            }
            
        }
        return count;
    }

    public static void main(String[] args) {
        input = fs.next().toCharArray();
        set = new HashSet<>();
        System.out.println(rec(0,""));
    }
}