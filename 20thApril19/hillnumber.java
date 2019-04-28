import java.util.*;

class hillnumber {
    static Scanner fs = new Scanner(System.in);
    static char []num;

    static long [][][][] dp;

    static boolean isHill(){ 
        for(int i=2;i<num.length;i++){
            if(num[i-2] > num[i-1] && num[i] > num[i-1])
                return false;
        }
        return true;
    }

    static long rec(int i,int lastDigit,boolean isDown,boolean isLastMax){
        if(i==num.length)
            return 1;
        if(dp[i][lastDigit][isDown ? 1:0][isLastMax?1:0]!=-1)
            return dp[i][lastDigit][isDown ? 1:0][isLastMax?1:0];
        int max = (isLastMax? num[i]-'0':9);
        long counter = 0;
        
        for(int k=0;k<=max;k++) {
            if(!isDown || (isDown && k<=lastDigit)) {
                counter += rec(i+1,k,(k - lastDigit < 0 ? true:(false||isDown)),(isLastMax && k==max));
            }
        }
        return dp[i][lastDigit][isDown ? 1:0][isLastMax?1:0] = counter;
    }

    public static void main(String[] args) {
        num = fs.next().toCharArray();
        if(isHill()){
            dp = new long[num.length][10][2][2];
            for(long [][][]a:dp){
                for(long [][]aa:a) {
                    for(long []aaa:aa){
                        Arrays.fill(aaa,-1);
                    }
                }
            }
            long ans = rec(0,0,false,true);
            System.out.println(ans-1);
        }
        else {
            System.out.println(-1);
        }
    }
}