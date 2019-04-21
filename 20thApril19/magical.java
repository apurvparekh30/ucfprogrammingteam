import java.util.*;

class magical {

    static Scanner fs = new Scanner(System.in);
    static long n;
    static Random r = new Random();
    
    public static void main(String[] args) {
        n = fs.nextLong();
        n = n - 3;
        long ans = n;
        for(long i=2;i*i<=n;i++){
            if(n % i == 0){
                if(i <= 3){
                    if(n/i > 3)
                        ans = n / i;
                }
                else {
                    ans = i;
                    break;
                }
            }
        }
        
        System.out.println(ans);
        
    }
}