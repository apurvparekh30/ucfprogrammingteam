import java.util.*;

class simplicity {

    static Scanner fs = new Scanner(System.in);
    
    public static void main(String[] args) {
        char []string = fs.next().toCharArray();
        HashMap<Character,Integer> map = new HashMap();
        int n = 0;
        for(char c:string){
            map.put(c,map.getOrDefault(c, 0)+1);
        }
        n = map.size();
        if(n<=2) {
            System.out.println(0);
            return;
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int i = 0;
        int cnt = 0;
        while(n > 2){
            int c = list.get(i);
            n = n - 1;
            cnt = cnt + c;
            i++;
        }
        System.out.println(cnt);
    }
}