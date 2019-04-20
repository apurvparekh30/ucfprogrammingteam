import java.util.*;

class Solution {
    static Scanner fs = new Scanner(System.in);

    static Map<Character,Integer> map;
    static char []input;
    static char []perm;
    static int attempt = 10;
    public static void main(String[] args) {
        input = fs.next().toCharArray();
        perm = fs.next().toCharArray();
        map = new HashMap<>();
        for(char c:input){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
                continue;
            }
            map.put(c,1);
        }
        int length = input.length;
        for(char c:perm){
            if(attempt <= 0)
                break;
            if(map.containsKey(c)){
                length = length - map.get(c);
                map.remove(c);
            }
            else {
                attempt--;
            }
        }
        if(length == 0)
            System.out.println("WIN");
        else if(attempt == 0)
            System.out.println("LOSE");
    }
}