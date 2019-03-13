import java.util.*;

class a {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static Map<String,List<String>> map;
    static Set<String> done;
    static Set<String> stack;
    static List<String> nodes;

    static boolean dfs(String node){
        if(stack.contains(node))
            return true;
        if(done.contains(node))
            return false;
        stack.add(node);
        done.add(node);
        for(String next:map.get(node)){
            if(dfs(next))
                return true;
        }
        stack.remove(node);
        return false;
    }

    public static void main(String[] args) {
        n = fs.nextInt();
        map = new HashMap<>();
        nodes = new ArrayList<>();
        while(n-- > 0) {
            String u,s,v;
            u = fs.next();
            s = fs.next();
            v = fs.next();
            nodes.add(u);
            nodes.add(v);
            if(!map.containsKey(u))
                map.put(u,new ArrayList<>());
            if(!map.containsKey(v))
                map.put(v,new ArrayList<>());
            if(s.equals(">")){
                String temp = v;
                v = u;
                u = temp;
            }
            List<String> list = map.get(u);
            list.add(v);
            map.put(u,list);
        }
        done = new HashSet<>();
        stack = new HashSet<>();
        StringBuilder sb = new StringBuilder("possible");
        for(String node:nodes){
            if(dfs(node)){
                sb = new StringBuilder("impossible");
                break;
            }
        }
        System.out.println(sb);
    }
}